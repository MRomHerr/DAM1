/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  marco
 * Created: 12 jun 2024
 */

CREATE DATABASE trivial;

USE trivial;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    aciertos INT,
    respuestas_usuario TEXT,
    respuestas_correctas TEXT
);
