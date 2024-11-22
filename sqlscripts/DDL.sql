-- Fjern eksisterende database, hvis den findes
DROP DATABASE IF EXISTS project_management2;
CREATE DATABASE project_management2;
USE project_management2;

-- Opret User tabel (fælles for både Worker og Project Leader)
CREATE TABLE user (
                      user_id INT AUTO_INCREMENT PRIMARY KEY,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      role_id int NOT NULL -- Role angiver typen af bruger

);
-- Opret Project tabel
CREATE TABLE project (
                         project_id INT AUTO_INCREMENT PRIMARY KEY,
                         project_name VARCHAR(255) NOT NULL,
                         startdate DATE NOT NULL,
                         enddate DATE NOT NULL,
                         budget DECIMAL(10, 2) NOT NULL,
                         description varChar(255) NOT NULL,
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
                      startdate DATE ,
                      enddate DATE ,
                      status ENUM('In Progress', 'Complete', 'Overdue') DEFAULT 'In Progress',
                      subproject_id INT,
                      FOREIGN KEY (subproject_id) REFERENCES subproject(subproject_id)
);

CREATE TABLE workertask (
                            workertask_id INT AUTO_INCREMENT PRIMARY KEY,
                            skills VARCHAR(255),
                            rate int, task_id int,user_id int,
                            FOREIGN KEY (task_id) REFERENCES task(task_id),
                            FOREIGN KEY (user_id) REFERENCES user(user_id)
);


-- Opret Ressource tabel
CREATE TABLE resource (
                          resource_id INT AUTO_INCREMENT PRIMARY KEY,
                          materialhardware VARCHAR(255) NOT NULL,
                          costrate DECIMAL(10, 2) NOT NULL
);

-- Mange-til-mange relation mellem Task og Ressourcer
CREATE TABLE resource_task (
                               task_id INT,
                               resource_id INT,
                               PRIMARY KEY (task_id, resource_id),
                               FOREIGN KEY (task_id) REFERENCES task(task_id),
                               FOREIGN KEY (resource_id) REFERENCES resource(resource_id)
);




