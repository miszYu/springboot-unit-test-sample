DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    score DOUBLE,
    graduate BOOLEAN,
    create_date TIMESTAMP
);
DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(30),
   stafflv VARCHAR(10),
   gender VARCHAR(1) DEFAULT NULL
)


