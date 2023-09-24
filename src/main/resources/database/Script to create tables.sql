CREATE DATABASE IF NOT EXISTS alurahotel;

USE alurahotel;

CREATE TABLE IF NOT EXISTS Huespedes (
	id INT AUTO_INCREMENT NOT NULL,
    name_huesped VARCHAR(25) NOT NULL,
    surname VARCHAR(25) NOT NULL,
    birthdate DATE,
    phone VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Reservas (
	id INT AUTO_INCREMENT,
    huesped_id INT NOT NULL,
    entryDate DATETIME NOT NULL,
    departureDate DATETIME NOT NULL,
    valueReserva FLOAT NOT NULL,
    wayToPay VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (huesped_id) REFERENCES Huespedes(id) ON DELETE CASCADE
);