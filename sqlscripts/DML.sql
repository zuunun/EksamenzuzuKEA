--user
INSERT INTO user (username, email, password, role, managed_projects, skills, task_comment, estimated_time, actual_time)
VALUES
    ('Alice Manager', 'alice.manager@example.com', 'password123', 'Project Leader', 3, NULL, NULL, NULL, NULL),
    ('Bob Developer', 'bob.developer@example.com', 'password456', 'Worker', NULL, 'Backend Development', NULL, 0, 0),
    ('Charlie Designer', 'charlie.designer@example.com', 'password789', 'Worker', NULL, 'Frontend Development', NULL, 0, 0);

--projekt
INSERT INTO project (project_name, startdate, enddate, budget, description, projectleader_id)
VALUES
    ('Website Redesign', '2024-01-01', '2024-12-31', 150000.00, 'Redesigning the company website for better UX.', 1),
    ('Mobile App Development', '2024-03-01', '2024-09-30', 200000.00, 'Developing a mobile app for the platform.', 1);

--subprojekt:))
INSERT INTO subproject (subproject_name, startdate, enddate, budget, project_id)
VALUES
    ('Frontend Development', '2024-01-01', '2024-06-30', 50000.00, 1),
    ('Backend Development', '2024-02-01', '2024-08-31', 75000.00, 1),
    ('App Design', '2024-03-01', '2024-06-01', 60000.00, 2),
    ('App Backend', '2024-04-01', '2024-09-30', 90000.00, 2);

--tasks
INSERT INTO task (task_name, startdate, enddate, deadline, estimated_time, status, cost, subproject_id, worker_id)
VALUES
    ('Design Homepage', '2024-01-01', '2024-03-01', '2024-03-01', 40, 'In Progress', 10000.00, 1, 3), -- Tildelt Charlie
    ('Develop API', '2024-02-01', '2024-06-01', '2024-06-01', 60, 'In Progress', 15000.00, 2, 2), -- Tildelt Bob
    ('Design App UI', '2024-03-01', '2024-04-01', '2024-04-15', 50, 'In Progress', 12000.00, 3, 3), -- Tildelt Charlie
    ('Develop App Backend', '2024-04-01', '2024-09-01', '2024-09-01', 80, 'In Progress', 18000.00, 4, 2); -- Tildelt Bob

--resourcer
INSERT INTO resource (materialhardware, cost)
VALUES
    ('React Library', 2000.00),
    ('Database Server', 10000.00),
    ('Cloud Hosting', 5000.00),
    ('Design Tool', 1000.00);

--indsætter relationer til resource_tasks
INSERT INTO resource_task (task_id, resource_id)
VALUES
    (1, 1), -- React Library til 'Design Homepage'
    (2, 2), -- Database Server til 'Develop API'
    (3, 4), -- Design Tool til 'Design App UI'
    (4, 3); -- Cloud Hosting til 'Develop App Backend'
