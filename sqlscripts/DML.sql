-- Indsæt data i Employee-tabellen (2 projektledere og 2 arbejdere)
INSERT INTO employee (email, password, role, employee_rate, max_hours) VALUES
                                                                           ('ama', '123', 'PROJECTLEADER', 50, 40), -- Projektleder 1
                                                                           ('zuzu', '1234', 'PROJECTLEADER', 20, 35), -- Projektleder 2
                                                                           ('worker1@example.com', 'password123', 'WORKER', 25, 30), -- Arbejder 1
                                                                           ('worker2@example.com', 'password456', 'WORKER', 30, 25); -- Arbejder 2

-- Indsæt data i Project-tabellen
INSERT INTO project (project_name, budget, project_description, employee_id, material_cost, employee_cost) VALUES
                                                                                                               ('Project Alpha', 100000, 'Alpha description', 1, 2000.00, 5000.00), -- Tilknyttet Projektleder 1
                                                                                                               ('Project Beta', 50000, 'Beta description', 2, 1500.00, 3000.00);  -- Tilknyttet Projektleder 2

-- Indsæt data i Subproject-tabellen
INSERT INTO subproject (subproject_name, subproject_description, project_id) VALUES
                                                                                 ('Alpha Subproject A', 'Alpha A desc', 1),
                                                                                 ('Alpha Subproject B', 'Alpha B desc', 1),
                                                                                 ('Beta Subproject A', 'Beta A desc', 2);

-- Indsæt data i Task-tabellen
INSERT INTO task (task_name, start_date, end_date, estimated_hours, status, actual_hours, subproject_id) VALUES
                                                                                                             ('Task 1', '2024-11-01', '2024-11-05', 10, 'INPROGRESS', 5, 1),
                                                                                                             ('Task 2', '2024-11-02', '2024-11-06', 20, 'NOTSTARTED', 0, 2),
                                                                                                             ('Task 3', '2024-11-03', '2024-11-07', 15, 'COMPLETE', 15, 3);

-- Indsæt data i Employee_Task-tabellen
INSERT INTO employee_task (employee_id, task_id) VALUES
                                                     (3, 1), -- Arbejder 1 til Task 1
                                                     (4, 2), -- Arbejder 2 til Task 2
                                                     (3, 3); -- Arbejder 1 til Task 3
