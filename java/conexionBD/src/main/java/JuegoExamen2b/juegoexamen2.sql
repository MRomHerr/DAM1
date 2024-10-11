/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  marco
 * Created: 12 jun 2024
 */

CREATE DATABASE juegoexamen2;

USE juegoexamen2;

CREATE TABLE usuarios (
    dni VARCHAR(10) PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL
);

CREATE TABLE partidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(10),
    fecha DATETIME,
    puntuacion DOUBLE,
    numero_adivinar INT,
    FOREIGN KEY (dni) REFERENCES usuarios(dni)
);

CREATE TABLE intentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    partida_id INT,
    intento INT,
    FOREIGN KEY (partida_id) REFERENCES partidas(id)
);
