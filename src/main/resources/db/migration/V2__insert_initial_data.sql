INSERT INTO clients (first_name, last_name, phone, second_phone, birthday)
VALUES
    ('John', 'Doe', '1234', '0987', '2000-01-01'),
    ('Jane', 'Doe', '2234', '1987', '1990-01-01');

INSERT INTO audit (client_id, date, operation_type)
VALUES
    (1, '2024-06-13 10:00:00', 'INSERT'),
    (2, '2024-06-13 11:00:00', 'INSERT');
