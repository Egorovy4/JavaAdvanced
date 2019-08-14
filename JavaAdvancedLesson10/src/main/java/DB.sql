DROP DATABASE IF EXISTS bookstore;
CREATE DATABASE bookstore CHAR SET utf8;
USE bookstore;

CREATE TABLE user (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    age INT NOT NULL,
    role VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE product (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	description TEXT,
	price DECIMAL(5, 2) NOT NULL
);

CREATE TABLE bucket (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT DEFAULT NULL,
    product_id INT DEFAULT NULL,
    purchase_date TIMESTAMP NULL DEFAULT NULL
);

ALTER TABLE bucket ADD FOREIGN KEY(user_id) 
	REFERENCES user(id) ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE bucket ADD FOREIGN KEY(product_id)
	REFERENCES product(id) ON DELETE CASCADE ON UPDATE RESTRICT;