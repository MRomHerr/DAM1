CREATE DATABASE Cafeteria;

USE Cafeteria;

CREATE TABLE Platos (
    id_plato INT(7)PRIMARY KEY,
    nombre_plato VARCHAR(50) NOT NULL,
    precio_plato DOUBLE(4) NOT NULL
);

CREATE TABLE Ensaladas (
    id_ensalada INT(5)PRIMARY KEY,
    nombre_ensalada VARCHAR(50) NOT NULL,
    precio_ensalada DOUBLE(4) NOT NULL
);

CREATE TABLE Reservas (
    id_reserva INT(10)PRIMARY KEY,
    id_plato INT(7),
    FOREIGN KEY (id_plato) REFERENCES Platos(id_plato),
    id_ensalada INT(5),
	FOREIGN KEY (id_ensalada) REFERENCES Ensaladas(id_ensalada),
    nombre_cliente VARCHAR(50) NOT NULL,
    fecha_reserva DATE NOT NULL,
    hora_cancelacion TIME
);

BEGIN TRANSACTION;

INSERT INTO Platos VALUES
(1564554,'Espagueti a la boloñesa',4.60);
(4784158,'Macarrones a la carbonara',4.60);
(1486579,'Lentejas vegetarianas',4.60);
(1572267,'Lomo a la plancha con pimientos',4.60);
(2554789,'Judiones de Segovia',4.60);
(7896314,'Guisado con alcachofas',4.60);
(7899254'Fabes con espinacas',4.60);
(7651652'Arroz negro',4.60);

INSERT INTO Ensaladas VALUES
(21648,'Ensalada de Pimientos',4.00);
(15472,'Ensalada de Pollo',4.00);