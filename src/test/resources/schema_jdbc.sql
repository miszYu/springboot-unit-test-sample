DROP TABLE IF EXISTS student;
CREATE TABLE student (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(30),
                         score DOUBLE,
                         graduate BOOLEAN,
                         create_date TIMESTAMP
);