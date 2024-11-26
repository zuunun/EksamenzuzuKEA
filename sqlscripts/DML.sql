-- Indsæt data i Employee-tabellen
INSERT INTO employee (email, password, role, employee_rate)
VALUES
    ('zuzu', '1234', 'PROJECTLEADER', 500),
    ('ama', '123', 'PROJECTLEADER', 500),
    ('worker1@example.com', 'password123', 'WORKER', 300),
    ('worker2@example.com', 'password123', 'WORKER', 300);

-- Indsæt data i Project-tabellen
INSERT INTO project (project_name, budget, project_description, employee_id)
VALUES
    ('Project Alpha', 100000.00, 'Development of a new software', 1),
    ('Project Beta', 75000.00, 'Improvement of existing product', 1),
    ('Project Gamma', 50000.00, 'Research and development initiative', 2),
    ('Project Delta', 120000.00, 'Infrastructure upgrade project', 2),
    ('Project Epsilon', 85000.00, 'Marketing campaign launch', 1),
    ('Project Zeta', 60000.00, 'Customer support system enhancement', 2);


-- Indsæt data i Subproject-tabellen
INSERT INTO subproject (subproject_name, subproject_description, project_id)
VALUES
    ('Frontend Development', 'Building user interface for Alpha', 1),
    ('Backend Development', 'Creating backend services for Alpha', 1),
    ('Optimization', 'Enhancing features for Beta', 2);

-- Indsæt data i Task-tabellen
INSERT INTO task (task_name, start_date, end_date, status, duration, subproject_id, employee_id)
VALUES
    ('Create UI Components', '2024-11-01', '2024-11-15', 'INPROGRESS', 15, 1, 2),
    ('Develop APIs', '2024-11-01', '2024-11-20', 'NOTSTARTED', 20, 2, 3),
    ('Optimize Performance', '2024-11-01', '2024-11-10', 'COMPLETE', 10, 3, 2);

-- Indsæt data i Resource-tabellen
INSERT INTO resource (material_hardware, task_id)
VALUES
    ('ReactJS Framework', 1),
    ('Spring Boot Framework', 2),
    ('Performance Monitoring Tool', 3);

-- Indsæt data i Resource_Task-tabellen
INSERT INTO resource_task (resource_id, task_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);


