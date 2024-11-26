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
                          employee_rate INT
);

-- Opret Project tabel
CREATE TABLE project (
                         project_id INT AUTO_INCREMENT PRIMARY KEY,
                         project_name VARCHAR(255) NOT NULL,
                         budget DECIMAL(10, 2) NOT NULL,
                         project_description VARCHAR(255) NOT NULL,
                         employee_id INT, -- Reference til employee_id fra Employee tabellen (projektlederen)
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
                      status ENUM('INPROGRESS', 'COMPLETE', 'OVERDUE', 'NOTSTARTED') DEFAULT 'INPROGRESS', -- Status på opgaven
                      duration INT,
                      subproject_id INT, -- Reference til subproject_id fra Subproject tabellen
                      FOREIGN KEY (subproject_id) REFERENCES subproject(subproject_id),
                      employee_id INT, -- Reference til employee_id fra Employee tabellen
                      FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

-- Opret Resource tabel (til at håndtere ressourcer for opgaver)
CREATE TABLE resource (
                          resource_id INT AUTO_INCREMENT PRIMARY KEY,
                          material_hardware VARCHAR(255) NOT NULL, -- Ressourcens navn
                          task_id INT, -- Reference til task_id fra Task tabellen
                          FOREIGN KEY (task_id) REFERENCES task(task_id)
);

-- Opret Ressource_Task tabel (til mange-til-mange forhold mellem Resource og Task)
CREATE TABLE resource_task (
                               resource_id INT,
                               task_id INT,
                               PRIMARY KEY (task_id, resource_id), -- Primær nøgle for mange-til-mange forhold
                               FOREIGN KEY (task_id) REFERENCES task(task_id),
                               FOREIGN KEY (resource_id) REFERENCES resource(resource_id)
);