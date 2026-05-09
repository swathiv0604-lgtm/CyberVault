DROP DATABASE IF EXISTS cybervault;

CREATE DATABASE cybervault;

USE cybervault;

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE credentials(
    id INT PRIMARY KEY AUTO_INCREMENT,
    website VARCHAR(100),
    username VARCHAR(100),
    password VARCHAR(100)
);