-- Fjern eksisterende database, hvis den findes, og opret en ny
DROP DATABASE IF EXISTS project_management;
CREATE DATABASE project_management;
USE project_management;

-- Opret User tabel (fælles for både Worker og Project Leader)
CREATE TABLE user (
                      user_id INT AUTO_INCREMENT PRIMARY KEY,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      role_id ENUM('PROJECTLEADER', 'WORKER') DEFAULT 'WORKER' -- Role angiver typen af bruger
);

-- Opret Project tabel
CREATE TABLE project (
                         project_id INT AUTO_INCREMENT PRIMARY KEY,
                         project_name VARCHAR(255) NOT NULL,
                         budget double NOT NULL,
                         project_description VARCHAR(255) NOT NULL,
                         user_id INT, -- Reference til user_id fra User tabellen (projektlederen)
                         FOREIGN KEY (user_id) REFERENCES user(user_id)
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
                      startdate DATE,
                      enddate DATE,
                      status ENUM('INPROGRESS', 'COMPLETE', 'OVERDUE', 'NOTSTARTED') DEFAULT 'INPROGRESS', -- Status på opgaven
                      subproject_id INT, -- Reference til subproject_id fra Subproject tabellen
                      FOREIGN KEY (subproject_id) REFERENCES subproject(subproject_id)
);

-- Opret WorkerTask tabel (for at matche arbejdere med opgaver)
CREATE TABLE workertask (
                            workertask_id INT AUTO_INCREMENT PRIMARY KEY,
                            skills VARCHAR(255), -- Arbejderens færdigheder
                            rate INT, -- Løn eller sats pr. time
                            task_id INT, -- Reference til task_id fra Task tabellen
                            user_id INT, -- Reference til user_id fra User tabellen (arbejderen)
                            FOREIGN KEY (task_id) REFERENCES task(task_id),
                            FOREIGN KEY (user_id) REFERENCES user(user_id)
);

-- Opret Resource tabel (til at håndtere ressourcer for opgaver)
CREATE TABLE resource (
                          resource_id INT AUTO_INCREMENT PRIMARY KEY,
                          materialhardware VARCHAR(255) NOT NULL, -- Ressourcens navn
                          costrate DECIMAL(10, 2) NOT NULL, -- Omkostninger for ressourcen
                          task_id INT, -- Reference til task_id fra Task tabellen
                          FOREIGN KEY (task_id) REFERENCES task(task_id)
);