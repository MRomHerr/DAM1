CREATE DATABASE nombre_basedatos;

USE nombre_basedatos;

CREATE TABLE Palabras (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Palabra VARCHAR(255) NOT NULL
);

CREATE TABLE Puntajes (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Usuario VARCHAR(255) NOT NULL,
    Palabra VARCHAR(255) NOT NULL,
    IntentosRestantes INT NOT NULL,
    LetrasAcertadas VARCHAR(255) NOT NULL
);

-- Insertar algunas palabras de ejemplo
INSERT INTO Palabras (Palabra) VALUES ('programacion'), ('java'), ('ahorcado'), ('conexion'), ('basedatos');
