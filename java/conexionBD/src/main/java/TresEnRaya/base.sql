CREATE DATABASE tres_en_raya_db;

USE tres_en_raya_db;

CREATE TABLE movimientos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fila INT NOT NULL,
    columna INT NOT NULL,
    jugador CHAR(1) NOT NULL
);

CREATE TABLE resultados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ganador CHAR(1)
);
ALTER TABLE resultados ADD COLUMN fecha_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;
