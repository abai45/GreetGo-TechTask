CREATE TABLE clients (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(255) NOT NULL,
                         last_name VARCHAR(255) NOT NULL,
                         phone VARCHAR(255) UNIQUE NOT NULL,
                         second_phone VARCHAR(255) UNIQUE NOT NULL,
                         birthday DATE,
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE audit (
                       id SERIAL PRIMARY KEY,
                       client_id INTEGER NOT NULL,
                       date TIMESTAMP NOT NULL,
                       operation_type VARCHAR(255) NOT NULL,
                       FOREIGN KEY (client_id) REFERENCES clients(id)
);
