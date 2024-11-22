-- Indsæt brugere
INSERT INTO user (email, password, role_id)
VALUES
    ('worker1@example.com', 'password123', 1),
    ('worker2@example.com', 'password456', 1),
    ('leader@example.com', 'securepass', 2);

-- Indsæt opgaver til arbejderne
INSERT INTO workertask (skills, estimated_time, actual_time, user_id)
VALUES
    ('Programming', 10, 8, 1),
    ('Testing', 5, 6, 2);

-- Indsæt projekter
INSERT INTO project (project_name, startdate, enddate, budget, description, projectleader_id)
VALUES
    ('Website Redesign', '2024-01-01', '2024-06-30', 50000.00, 'Redesign company website', 3),
    ('Mobile App Development', '2024-02-01', '2024-08-15', 75000.00, 'Develop a mobile app for Android and iOS', 3);

-- Indsæt delprojekter
INSERT INTO subproject (subproject_name, startdate, enddate, budget, project_id)
VALUES
    ('Frontend Development', '2024-01-01', '2024-03-31', 20000.00, 1),
    ('Backend Integration', '2024-04-01', '2024-06-30', 30000.00, 1),
    ('UI/UX Design', '2024-02-01', '2024-04-15', 15000.00, 2);

-- Indsæt opgaver
INSERT INTO task (task_name, startdate, enddate, status, cost, subproject_id, user_id)
VALUES
    ('HTML/CSS Development', '2024-01-01', '2024-01-31', 'In Progress', 5000.00, 1, 1),
    ('Database Setup', '2024-04-01', '2024-04-15', 'Complete', 3000.00, 2, 2),
    ('Prototype Design', '2024-02-01', '2024-02-15', 'Overdue', 2000.00, 3, 1);

-- Indsæt ressourcer
INSERT INTO resource (materialhardware, cost)
VALUES
    ('Laptop', 1000.00),
    ('Cloud Hosting', 500.00),
    ('Design Software License', 200.00);

-- Knyt ressourcer til opgaver
INSERT INTO resource_task (task_id, resource_id)
VALUES
    (1, 1), -- HTML/CSS task bruger Laptop
    (1, 2), -- HTML/CSS task bruger Cloud Hosting
    (3, 3); -- Prototype Design bruger Design Software License
