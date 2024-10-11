CREATE DATABASE RuletaRusaDB;

USE RuletaRusaDB;

CREATE TABLE Jugadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE Partidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jugador_id INT,
    puntos INT,
    perdio BOOLEAN,
    FOREIGN KEY (jugador_id) REFERENCES Jugadores(id)
);
