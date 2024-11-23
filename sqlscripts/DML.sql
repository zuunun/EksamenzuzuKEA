-- Insert data i User tabellen
INSERT INTO user (email, password, role_id)
VALUES
    ('amalie@example.com', '123', 'PROJECTLEADER'),
    ('worker1@example.com', 'password123', 'WORKER'),
    ('worker2@example.com', 'password123', 'WORKER');

-- Insert data i Project tabellen
INSERT INTO project (project_name, budget, project_description, projectleader_id)
VALUES
    ('Website Development', 50000.00, 'Development of a new company website', 1),
    ('App Development', 75000.00, 'Development of a mobile app', 1);

-- Insert data i Subproject tabellen
INSERT INTO subproject (subproject_name, subproject_description, project_id)
VALUES
    ('Frontend Development', 'Develop the user interface for the website', 1),
    ('Backend Development', 'Build the backend services for the website', 1),
    ('UI Design', 'Design the user interface for the app', 2);

-- Insert data i Task tabellen
INSERT INTO task (task_name, startdate, enddate, status, subproject_id)
VALUES
    ('Create Homepage', '2024-11-01', '2024-11-10', 'INPROGRESS', 1),
    ('Set Up Database', '2024-11-05', '2024-11-15', 'NOTSTARTET', 2),
    ('Prototype App UI', '2024-11-02', '2024-11-12', 'COMPLETE', 3);

INSERT INTO workertask (skills, hourly_rate, task_id, user_id)
VALUES
    ('HTML, CSS, JavaScript', 300, 1, 2),
    ('SQL, Database Design', 350, 2, 3),
    ('Figma, Adobe XD', 400, 3, 2);


INSERT INTO resource (materialhardware, costrate, task_id)
VALUES
    ('Server Hosting', 100.00, 1),
    ('Design Software License', 50.00, 2),
    ('Cloud Storage', 75.00, 3);

