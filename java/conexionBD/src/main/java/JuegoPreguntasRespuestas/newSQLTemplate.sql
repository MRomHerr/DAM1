/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  marco
 * Created: 12 jun 2024
 */

CREATE DATABASE juego_preguntas_respuestas;

USE juego_preguntas_respuestas;
CREATE TABLE jugador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    puntaje INT DEFAULT 0,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE partida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jugador_id INT,
    respuestas_jugador TEXT,
    respuestas_correctas TEXT,
    puntaje_obtenido INT,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (jugador_id) REFERENCES jugador(id)
);

-- Insertar un jugador
INSERT INTO jugador (nombre) VALUES ('Juan');

-- Insertar una partida
INSERT INTO partida (jugador_id, respuestas_jugador, respuestas_correctas, puntaje_obtenido)
VALUES (1, 'París, Cervantes, Ocho', 'París, Miguel de Cervantes, Ocho', 3);
