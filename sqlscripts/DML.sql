-- Indsæt data i Employee-tabellen
INSERT INTO employee (email, password, role, employee_rate, max_hours) VALUES
                                                                           ('ama', '123', 'PROJECTLEADER', 50, 40),
                                                                           ('zuzu', '1234', 'WORKER', 20, 35),
                                                                           ('worker2@example.com', 'password123', 'WORKER', 25, 30);

-- Indsæt data i Project-tabellen
INSERT INTO project (project_name, budget, project_description, employee_id, material_cost, employee_cost) VALUES
                                                                                                               ('Project Alpha', 100000, 'Alpha description', 1, 2000.00, 5000.00),
                                                                                                               ('Project Beta', 50000, 'Beta description', 1, 1500.00, 3000.00);

-- Indsæt data i Subproject-tabellen
INSERT INTO subproject (subproject_name, subproject_description, project_id) VALUES
                                                                                 ('Alpha Subproject A', 'Alpha A desc', 1),
                                                                                 ('Alpha Subproject B', 'Alpha B desc', 1),
                                                                                 ('Beta Subproject A', 'Beta A desc', 2);

-- Indsæt data i Task-tabellen
INSERT INTO task (task_name, start_date, end_date, estimated_hours, status, actual_hours, subproject_id, employee_id) VALUES
                                                                                                                          ('Task 1', '2024-11-01', '2024-11-05', 10, 'INPROGRESS', 5, 1, 2),
                                                                                                                          ('Task 2', '2024-11-02', '2024-11-06', 20, 'NOTSTARTED', 0, 2, 3),
                                                                                                                          ('Task 3', '2024-11-03', '2024-11-07', 15, 'COMPLETE', 15, 3, 2);

-- Indsæt data i Employee_Task-tabellen
INSERT INTO employee_task (employee_id, task_id) VALUES
                                                     (2, 1),
                                                     (3, 2),
                                                     (2, 3);

