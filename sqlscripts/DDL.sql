-- Fjern eksisterende database, hvis den findes
DROP DATABASE IF EXISTS project_management;
CREATE DATABASE project_management;
USE project_management;

-- Opret User tabel (fælles for både Worker og Project Leader)
CREATE TABLE user (
                      user_id INT AUTO_INCREMENT PRIMARY KEY,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      role_id int NOT NULL -- Role angiver typen af bruger

);
CREATE TABLE workertask (
                            workertask_id INT AUTO_INCREMENT PRIMARY KEY,
                            skills VARCHAR(255),
                            estimated_time INT DEFAULT 0,
                            actual_time INT DEFAULT 0
);

-- Opret Project tabel
CREATE TABLE project (
                         project_id INT AUTO_INCREMENT PRIMARY KEY,
                         project_name VARCHAR(255) NOT NULL,
                         startdate DATE NOT NULL,
                         enddate DATE NOT NULL,
                         budget DECIMAL(10, 2) NOT NULL,
                         description TEXT NOT NULL,
                         projectleader_id INT NOT NULL,
                         FOREIGN KEY (projectleader_id) REFERENCES user(user_id) -- peger på user-tabel
);


-- Opret Subproject tabel
CREATE TABLE subproject (
                            subproject_id INT AUTO_INCREMENT PRIMARY KEY,
                            subproject_name VARCHAR(255) NOT NULL,
                            startdate DATE NOT NULL,
                            enddate DATE NOT NULL,
                            budget DECIMAL(10, 2) NOT NULL, --  budget
                            project_id INT NOT NULL,
                            FOREIGN KEY (project_id) REFERENCES project(project_id)
);

-- Opret Task tabel
CREATE TABLE task (
                      task_id INT AUTO_INCREMENT PRIMARY KEY,
                      task_name VARCHAR(255) NOT NULL,
                      startdate DATE NOT NULL,
                      enddate DATE NOT NULL,
                      status ENUM('In Progress', 'Complete', 'Overdue') DEFAULT 'In Progress',
                      cost DECIMAL(10, 2) DEFAULT 0,
                      subproject_id INT,
                      user_id INT, -- (user-tabel)
                      FOREIGN KEY (subproject_id) REFERENCES subproject(subproject_id),
                      FOREIGN KEY (user_id) REFERENCES user(user_id) -- peger på user-tabel
);


-- Opret Ressource tabel
CREATE TABLE resource (
                          resource_id INT AUTO_INCREMENT PRIMARY KEY,
                          materialhardware VARCHAR(255) NOT NULL,
                          cost DECIMAL(10, 2) NOT NULL
);

-- Mange-til-mange relation mellem Task og Ressourcer
CREATE TABLE resource_task (
                               task_id INT,
                               resource_id INT,
                               PRIMARY KEY (task_id, resource_id),
                               FOREIGN KEY (task_id) REFERENCES task(task_id),
                               FOREIGN KEY (resource_id) REFERENCES resource(resource_id)
);

-- Views til budgetkalkulationer
CREATE VIEW subproject_budget_view AS
SELECT
    sp.subproject_id,
    sp.subproject_name,
    sp.budget AS allocated_budget,
    COALESCE(SUM(t.cost), 0) AS used_budget,
    (sp.budget - COALESCE(SUM(t.cost), 0)) AS remaining_budget
FROM subproject sp
         LEFT JOIN task t ON sp.subproject_id = t.subproject_id
GROUP BY sp.subproject_id, sp.subproject_name, sp.budget;

CREATE VIEW project_budget_view AS
SELECT
    p.project_id,
    p.project_name,
    p.budget AS total_budget,
    COALESCE(SUM(sp.budget), 0) AS allocated_subproject_budget,
    (p.budget - COALESCE(SUM(sp.budget), 0)) AS remaining_budget
FROM project p
         LEFT JOIN subproject sp ON p.project_id = sp.project_id
GROUP BY p.project_id, p.project_name, p.budget;


-- Triggers til budgetvalidering
DELIMITER $$

CREATE TRIGGER validate_subproject_budget
    BEFORE INSERT ON subproject
    FOR EACH ROW
BEGIN
    DECLARE total_subproject_budget DECIMAL(10,2);
    SELECT COALESCE(SUM(budget), 0) INTO total_subproject_budget
    FROM subproject
    WHERE project_id = NEW.project_id;

    IF (total_subproject_budget + NEW.budget >
        (SELECT budget FROM project WHERE project_id = NEW.project_id)) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Subproject budget exceeds project budget!';
END IF;
END$$

CREATE TRIGGER validate_task_budget
    BEFORE INSERT ON task
    FOR EACH ROW
BEGIN
    DECLARE total_task_cost DECIMAL(10,2);
    SELECT COALESCE(SUM(cost), 0) INTO total_task_cost
    FROM task
    WHERE subproject_id = NEW.subproject_id;

    IF (total_task_cost + NEW.cost >
        (SELECT budget FROM subproject WHERE subproject_id = NEW.subproject_id)) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Task cost exceeds subproject budget!';
END IF;
END$$

DELIMITER ;
