CREATE TABLE IF NOT EXISTS teacher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    stafflv VARCHAR(10),
    gender VARCHAR(1) DEFAULT NULL
)