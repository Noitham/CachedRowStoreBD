-- Crear usuari per a accés local.
CREATE USER 'storeusr'@'localhost' IDENTIFIED BY 'storepsw';
-- Crear base de dades.
CREATE DATABASE dbstore
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
-- Assignar permisos a l'usuari local sobre la base de dades.

GRANT SELECT, INSERT, UPDATE, DELETE ON dbstore.* TO 'storeusr'@'localhost';

USE dbstore;

-- creació taula paisos.
CREATE TABLE products (
id INT(4) NOT NULL AUTO_INCREMENT,
code VARCHAR(20) UNIQUE NOT NULL,
name VARCHAR(40) DEFAULT NULL,
price DOUBLE DEFAULT 0.0,
stock INT(4) DEFAULT 0,
PRIMARY KEY (`id`)
) ENGINE = InnoDB;


INSERT INTO products
(`id`, `code`, `name`, `price`, `stock`) VALUES
(1, 'TV01', 'Televisor 20 LCD', 1200.0 , 1),
(2, 'Fridge01', 'Fridge 120L', 700.0 , 8),
(3, 'MW01', 'Microwave', 100.0 , 10),
(4, 'MW03', 'Microwave', 300.0 , 0);
