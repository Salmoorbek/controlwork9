INSERT INTO users (name, email, password,enabled, role)
VALUES
    ('Менеджер', 'manager@example.com', '$2a$10$cxWIKm8ILPuE8IEpw2jsJ.FjiiSW8T2Qy6HdYE0T/yHzBE/kYRygq',true, 'MANAGER'),
    ('Разработчик 1', 'developer1@example.com', '$2a$10$cxWIKm8ILPuE8IEpw2jsJ.FjiiSW8T2Qy6HdYE0T/yHzBE/kYRygq',true, 'DEVELOPER'),
    ('Разработчик 2', 'developer2@example.com', '$2a$10$cxWIKm8ILPuE8IEpw2jsJ.FjiiSW8T2Qy6HdYE0T/yHzBE/kYRygq',true, 'DEVELOPER'),
    ('Разработчик 3', 'developer3@example.com', '$2a$10$cxWIKm8ILPuE8IEpw2jsJ.FjiiSW8T2Qy6HdYE0T/yHzBE/kYRygq',true, 'DEVELOPER'),
    ('Разработчик 4', 'developer4@example.com', '$2a$10$cxWIKm8ILPuE8IEpw2jsJ.FjiiSW8T2Qy6HdYE0T/yHzBE/kYRygq',true, 'DEVELOPER');

INSERT INTO tasks (title, creation_date, developer_id, status)
VALUES ('Task 1', CURRENT_DATE, 1, 'IN_PROGRESS');

INSERT INTO tasks (title, creation_date, developer_id, status)
VALUES ('Task 2', CURRENT_DATE, 2, 'COMPLETED');