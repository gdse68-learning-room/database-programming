DROP DATABASE IF EXISTS kade;

CREATE DATABASE IF NOT EXISTS kade;

SHOW DATABASES;

USE kade;

CREATE TABLE user(
    user_name VARCHAR(35) PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    password VARCHAR(155) NOT NULL,
    tel VARCHAR(35) NOT NULL
);

CREATE TABLE customer(
    id VARCHAR(35) PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    address TEXT NOT NULL,
    tel VARCHAR(15) NOT NULL
);

SHOW TABLES;