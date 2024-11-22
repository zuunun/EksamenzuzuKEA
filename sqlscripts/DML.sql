-- Indsæt data i Project Leader (Projektleder)
INSERT INTO projectleader (projectleader_name, email, password, managed_projects)
VALUES
    ('Alice Project Manager', 'alice.manager@example.com', 'password123', 2),
    ('Bob Project Manager', 'bob.manager@example.com', 'password456', 1);

-- Indsæt data i Worker (Bruger)
INSERT INTO worker (worker_username, worker_email, worker_skills, task_comment, estimated_time, actual_time)
VALUES
    ('Charlie Worker', 'charlie.worker@example.com', 'Frontend Development', NULL, 0, 0),
    ('David Worker', 'david.worker@example.com', 'Backend Development', NULL, 0, 0);

-- Indsæt data i Project
INSERT INTO project (project_name, startdate, enddate, budget, description, projectleader_id)
VALUES
    ('Website Redesign', '2024-01-01', '2024-12-31', 150000.00, 'Redesigning the company website for better UX.', 1),
    ('Mobile App Development', '2024-03-01', '2024-09-30', 200000.00, 'Developing a mobile app for the platform.', 2);

-- Indsæt data i Subproject
INSERT INTO subproject (subproject_name, startdate, enddate, budget, project_id)
VALUES
    ('Frontend Development', '2024-01-01', '2024-06-30', 50000.00, 1),
    ('Backend Development', '2024-02-01', '2024-08-31', 75000.00, 1),
    ('App Design', '2024-03-01', '2024-06-01', 60000.00, 2),
    ('App Backend', '2024-04-01', '2024-09-30', 90000.00, 2);

-- Indsæt data i Task
INSERT INTO task (task_name, task_description, deadline, estimated_time, status, cost, subproject_id, worker_id)
VALUES
    ('Design Homepage', 'Create a user-friendly homepage design.', '2024-03-01', 40, 'In Progress', 10000.00, 1, 1),
    ('Build API', 'Develop the backend API for the platform.', '2024-06-01', 60, 'In Progress', 15000.00, 2, 2),
    ('Design App UI', 'Design a user-friendly mobile app UI.', '2024-04-15', 50, 'In Progress', 12000.00, 3, 1),
    ('Develop App Backend', 'Develop the backend for the mobile app.', '2024-09-01', 80, 'In Progress', 18000.00, 4, 2);

-- Indsæt data i Resource
INSERT INTO resource (resource_name, materialhardware, cost, co2)
VALUES
    ('React Library', 'Software', 2000.00, 50),
    ('Database Server', 'Hardware', 10000.00, 300),
    ('Cloud Hosting', 'Infrastructure', 5000.00, 100),
    ('Design Tool', 'Software', 1000.00, 10);

-- Indsæt data i Resource_Task
INSERT INTO resource_task (task_id, resource_id)
VALUES
    (1, 1), -- React Library til 'Design Homepage'
    (2, 2), -- Database Server til 'Build API'
    (3, 4), -- Design Tool til 'Design App UI'
    (4, 3); -- Cloud Hosting til 'Develop App Backend'

