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
   id int PRIMARY KEY AUTO_INCREMENT,
   name varchar(30),
   stafflv varchar(10),
   gender varchar(1) DEFAULT NULL
)


