-- Indsæt data i User tabellen
INSERT INTO user (email, password, role_id)
VALUES
    ('zuzu@zuzu.com', '1234', 'PROJECTLEADER'), -- Projektleder
    ('ama', '123', 'PROJECTLEADER'), -- Projektleder
    ('worker1@example.com', 'password123', 'WORKER'), -- Arbejder
    ('worker2@example.com', 'password123', 'WORKER'); -- Arbejder

-- Indsæt data i Project tabellen
INSERT INTO project (project_name, budget, project_description, user_id)
VALUES
    ('Website Development', 50000.00, 'Development of a new company website', 1), -- Projekt tilknyttet første projektleder
    ('App Development', 75000.00, 'Development of a mobile app', 1); -- Projekt tilknyttet første projektleder

-- Indsæt data i Subproject tabellen
INSERT INTO subproject (subproject_name, subproject_description, project_id)
VALUES
    ('Frontend Development', 'Develop the user interface for the website', 1), -- Subprojekt til første projekt
    ('Backend Development', 'Build the backend services for the website', 1), -- Subprojekt til første projekt
    ('UI Design', 'Design the user interface for the app', 2); -- Subprojekt til andet projekt

-- Indsæt data i Task tabellen
INSERT INTO task (task_name, startdate, enddate, status, subproject_id)
VALUES
    ('Create Homepage', '2024-11-01', '2024-11-10', 'INPROGRESS', 1), -- Opgave under frontend-udvikling
    ('Set Up Database', '2024-11-05', '2024-11-15', 'NOTSTARTED', 2), -- Opgave under backend-udvikling
    ('Prototype App UI', '2024-11-02', '2024-11-12', 'COMPLETE', 3); -- Opgave under app-UI design


-- Indsæt data i WorkerTask tabellen
INSERT INTO workertask (skills, rate, task_id, user_id)
VALUES
    ('HTML, CSS, JavaScript', 300, 1, 3), -- Arbejder 1 arbejder på Create Homepage
    ('SQL, Database Design', 350, 2, 4), -- Arbejder 2 arbejder på Set Up Database
    ('Figma, Adobe XD', 400, 3, 3); -- Arbejder 1 arbejder på Prototype App UI

-- Indsæt data i Resource tabellen
INSERT INTO resource (materialhardware, costrate, task_id)
VALUES
    ('Server Hosting', 100.00, 1), -- Ressource tilknyttet Create Homepage
    ('Design Software License', 50.00, 2), -- Ressource tilknyttet Set Up Database
    ('Cloud Storage', 75.00, 3); -- Ressource tilknyttet Prototype App UI



