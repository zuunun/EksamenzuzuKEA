-- Fjern eksisterende database, hvis den findes, og opret en ny
DROP DATABASE IF EXISTS project_management;
CREATE DATABASE project_management;
USE project_management;

-- Opret Employee tabel (fælles for både Worker og Project Leader)
CREATE TABLE employee (
                          employee_id INT AUTO_INCREMENT PRIMARY KEY,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          role ENUM('PROJECTLEADER', 'WORKER') DEFAULT 'WORKER', -- Role angiver typen af bruger
                          employee_rate INT DEFAULT 0, -- Angiv en standardværdi for lønsats
                          max_hours INT DEFAULT 0      -- Angiv en standardværdi for maksimale timer
);

-- Opret Project tabel
CREATE TABLE project (
                         project_id INT AUTO_INCREMENT PRIMARY KEY,
                         project_name VARCHAR(255) NOT NULL,
                         budget DECIMAL(10, 2) NOT NULL,
                         project_description VARCHAR(255) NOT NULL,
                         employee_id INT, -- Reference til employee_id fra Employee tabellen (projektlederen)
                         material_cost DECIMAL(10, 2) DEFAULT 0.00, -- Materialeomkostninger med standardværdi
                         employee_cost DECIMAL(10, 2) DEFAULT 0.00, -- Ansatteomkostninger med standardværdi
                         FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

-- Opret Subproject tabel
CREATE TABLE subproject (
                            subproject_id INT AUTO_INCREMENT PRIMARY KEY,
                            subproject_name VARCHAR(255) NOT NULL,
                            subproject_description VARCHAR(255) NOT NULL,
                            project_id INT NOT NULL, -- Reference til project_id fra Project tabellen
                            FOREIGN KEY (project_id) REFERENCES project(project_id)
);

-- Opret Task tabel
CREATE TABLE task (
                      task_id INT AUTO_INCREMENT PRIMARY KEY,
                      task_name VARCHAR(255) NOT NULL,
                      start_date DATE,
                      end_date DATE,
                      status ENUM('INPROGRESS', 'COMPLETE', 'OVERDUE', 'NOTSTARTED') DEFAULT 'NOTSTARTED',
                      actual_hours INT DEFAULT 0,
                      estimated_hours INT DEFAULT 0,
                      subproject_id INT, -- Reference til subproject_id fra Subproject tabellen
                      FOREIGN KEY (subproject_id) REFERENCES subproject(subproject_id)
);

-- Opret Employee_Task tabel (til mange-til-mange forhold mellem Employee og Task)
CREATE TABLE employee_task (
                               employee_id INT NOT NULL,
                               task_id INT NOT NULL,
                               PRIMARY KEY (employee_id, task_id), -- Kombineret primær nøgle
                               FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
                               FOREIGN KEY (task_id) REFERENCES task(task_id)
);