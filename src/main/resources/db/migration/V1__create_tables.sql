CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(25) NOT NULL,
                       email VARCHAR(25) NOT NULL,
                       password VARCHAR(16) NOT NULL,
                       enabled BOOLEAN NOT NULL,
                       role VARCHAR(20) NOT NULL
);

CREATE TABLE tasks (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(20) NOT NULL,
                       creation_date DATE DEFAULT CURRENT_DATE,
                       developer_id BIGINT REFERENCES users(id) ON DELETE SET NULL,
                       status VARCHAR(20) NOT NULL
);

CREATE TABLE worklogs (
                          id BIGSERIAL PRIMARY KEY,
                          task_id BIGINT REFERENCES tasks(id) ON DELETE CASCADE,
                          time_spent VARCHAR(6) NOT NULL,
                          description VARCHAR(50) NOT NULL
);

CREATE TABLE attachments (
                             id BIGSERIAL PRIMARY KEY,
                             filename VARCHAR(50) NOT NULL,
                             filepath VARCHAR(100) NOT NULL,
                             task_id BIGINT REFERENCES tasks(id) ON DELETE CASCADE
);

ALTER TABLE users ALTER COLUMN password TYPE varchar(60);