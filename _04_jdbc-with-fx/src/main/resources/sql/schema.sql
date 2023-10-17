DROP DATABASE IF EXISTS kade2;

CREATE DATABASE IF NOT EXISTS kade2;

USE kade2;

CREATE TABLE customer(
    id VARCHAR(35) PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    address TEXT NOT NULL,
    tel VARCHAR(15) NOT NULL
);

DESC customer;