CREATE DATABASE portal_db;
USE portal_db;
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);

INSERT INTO users VALUES ('admin', 'admin123');

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    salary DOUBLE
);

INSERT INTO employees VALUES (101, 'Alice', 50000), (102, 'Bob', 60000);

CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(20),
    date DATE,
    status VARCHAR(10)
);
