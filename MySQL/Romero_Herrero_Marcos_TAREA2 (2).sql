DROP DATABASE IF EXISTS AEROPUERTO;

CREATE DATABASE IF NOT EXISTS AEROPUERTO;

USE AEROPUERTO;

-- -----------------------------------------------------
-- Tabla AEROLINEA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS AEROLINEA (
	cod_aerolinea INT NOT NULL,
	nombre VARCHAR(45) UNIQUE NOT NULL,
	flota INT NOT NULL,
   alianza VARCHAR(45) CHECK (alianza IN ('OneWorld', 'SkyTeam', 'StarAlliance', 'Ninguna')),
	PRIMARY KEY (cod_aerolinea)
);
-- -----------------------------------------------------
-- Tabla AVION
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS AVION (
	matricula INT NOT NULL,
   estado VARCHAR(13) CHECK (estado IN ('operativo', 'mantenimiento')),
	modelo VARCHAR(45) NOT NULL,
	capacidadPasajeros INT NOT NULL,
	capacidadCarga INT NOT NULL,
	capacidadCombustible INT NOT NULL,
	fechaMantenimiento DATE NULL,
	cod_aerolinea INT NOT NULL,
	PRIMARY KEY (matricula),
	FOREIGN KEY (cod_aerolinea) REFERENCES AEROLINEA (cod_aerolinea) ON DELETE CASCADE ON UPDATE CASCADE
);
-- -----------------------------------------------------
-- Tabla CONTROL
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS CONTROL (
	cod_control INT NOT NULL,
   tipoControl VARCHAR(25) CHECK (tipoControl IN ('Acceso', 'Pasaportes', 'Inspección adicional')),
   autoridades VARCHAR(45) CHECK (autoridades IN ('Seguridad del aeropuerto', 'Policía', 'Seguridad del aeropuerto y Policía')),
	PRIMARY KEY (cod_control)
);
-- -----------------------------------------------------
-- Tabla TERMINAL
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TERMINAL (
	nombreTerminal VARCHAR(45) NOT NULL,
	puertaEmbarque INT UNIQUE NOT NULL,
	serviciosDisponibles VARCHAR(45) NOT NULL,
	cod_control INT NOT NULL,
	PRIMARY KEY (nombreTerminal),
   FOREIGN KEY (cod_control) REFERENCES CONTROL (cod_control) ON DELETE CASCADE ON UPDATE CASCADE
);
-- -----------------------------------------------------
-- Tabla PASAJERO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PASAJERO (
	tipoDocumento VARCHAR(15) CHECK (tipoDocumento IN ('DNI', 'Pasaporte')),
	numDocumento VARCHAR(9) NOT NULL,
	categoria VARCHAR(45) NOT NULL,
	nombreCompleto VARCHAR(100) NOT NULL,
	fechaNacimiento DATE NOT NULL,
	nacionalidad VARCHAR(45) NOT NULL,
   visado VARCHAR(2) CHECK (visado IN ('si', 'no')),
	email VARCHAR(100) NULL,
	PRIMARY KEY (tipoDocumento, numDocumento)
);
-- -----------------------------------------------------
-- Tabla TRIPULACION
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TRIPULACION (
	cod_tripulacion INT NOT NULL,
	nombreCompleto VARCHAR(100) NOT NULL,
   funcion VARCHAR(9) CHECK (funcion IN ('piloto', 'azafato')),
	numLicencia INT UNIQUE NOT NULL,
	antiguedad DATE NOT NULL,
   comandante VARCHAR(2) CHECK (comandante IN ('si', 'no')),
	PRIMARY KEY (cod_tripulacion)
);
-- -----------------------------------------------------
-- Tabla DESTINO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DESTINO (
	codigoOACI VARCHAR(4) NOT NULL,
	codigoIATA VARCHAR(3) NOT NULL,
	ciudad VARCHAR(45) NOT NULL,
	pais VARCHAR(45) NOT NULL,
   zonaSchengen VARCHAR(2) CHECK (zonaSchengen IN ('si', 'no')),
	zonaHorariaDestino VARCHAR(45) NOT NULL,
	PRIMARY KEY (codigoOACI, codigoIATA)
);
-- -----------------------------------------------------
-- Tabla PLAN_VUELO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PLAN_VUELO ( -- ENTIDAD DEBIL
	cod_plan_vuelo INT NOT NULL,
	ruta VARCHAR(45) NOT NULL,
	altitud DOUBLE NOT NULL,
	velocidadPrevista DOUBLE NOT NULL,
	horarioSalidaEstimado TIMESTAMP NOT NULL,
	horarioLlegadaEstimado TIMESTAMP NOT NULL,
	notas VARCHAR(45) NOT NULL,
	aeropuertoAlternativo VARCHAR(45) NOT NULL,
	codigoOACI VARCHAR(4) NOT NULL,
   codigoIATA VARCHAR(3) NOT NULL,
	PRIMARY KEY (cod_plan_vuelo, codigoOACI, codigoIATA),
	FOREIGN KEY (codigoOACI, codigoIATA) REFERENCES DESTINO (codigoOACI, codigoIATA) ON DELETE CASCADE ON UPDATE CASCADE
);
-- -----------------------------------------------------
-- Tabla VUELO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS VUELO (
	numVuelo VARCHAR(6) NOT NULL,
	fecha DATE NOT NULL,
	horaSalida TIMESTAMP NOT NULL,
	horaLlegada TIMESTAMP NOT NULL,
	duracion VARCHAR(45) NOT NULL,
	estado VARCHAR(45) NOT NULL,
	servicio VARCHAR(45) NOT NULL,
	codigoOACI VARCHAR(4) NOT NULL,
   codigoIATA VARCHAR(3) NOT NULL,
	matricula INT NOT NULL,
	PRIMARY KEY (numVuelo, fecha),
	FOREIGN KEY (codigoOACI, codigoIATA) REFERENCES DESTINO (codigoOACI, codigoIATA) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (matricula) REFERENCES AVION (matricula) ON DELETE CASCADE ON UPDATE CASCADE
);
-- -----------------------------------------------------
-- Tabla BILLETE
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS BILLETE (
	numBillete INT NOT NULL,
	codigoReserva INT NOT NULL,
   tarifa VARCHAR(15) CHECK (tarifa IN ('turista', 'business', 'primera')),
	asiento INT NOT NULL,
	equipaje INT NOT NULL,
	numVuelo VARCHAR(6) NOT NULL,
	cod_aerolinea INT NOT NULL,
	PRIMARY KEY (numBillete),
   FOREIGN KEY (numVuelo) REFERENCES VUELO (numVuelo) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (cod_aerolinea) REFERENCES AEROLINEA (cod_aerolinea) ON DELETE CASCADE ON UPDATE CASCADE
);
-- ---------------------------------------------------
-- Tabla PASA creada de la relación CONTROL y PASAJERO
-- ---------------------------------------------------
CREATE TABLE IF NOT EXISTS PASA (
	cod_control INT NOT NULL,
	tipoDocumento VARCHAR(15) CHECK (tipoDocumento IN ('DNI', 'Pasaporte')),
	numDocumento VARCHAR(9) NOT NULL,
	PRIMARY KEY (cod_control, tipoDocumento, numDocumento),
   FOREIGN KEY (cod_control) REFERENCES CONTROL (cod_control) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (tipoDocumento, numDocumento) REFERENCES PASAJERO (tipoDocumento, numDocumento) ON DELETE CASCADE
);
-- -------------------------------------------------------
-- Tabla TRABAJA creada de la relación VUELO y TRIPULACION
-- -------------------------------------------------------
CREATE TABLE IF NOT EXISTS TRABAJA (
	numVuelo VARCHAR(6) NOT NULL,
	cod_tripulacion INT NOT NULL,
	PRIMARY KEY (numVuelo, cod_tripulacion),
   FOREIGN KEY (numVuelo) REFERENCES VUELO (numVuelo) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (cod_tripulacion) REFERENCES TRIPULACION (cod_tripulacion) ON DELETE CASCADE ON UPDATE CASCADE
);
-- ------------------------------------------------------
-- Tabla OPERA creada de la relación TERMINAL y AEROLINEA
-- ------------------------------------------------------
CREATE TABLE IF NOT EXISTS OPERA (
	nombreTerminal VARCHAR(45) NOT NULL,
	cod_aerolinea INT NOT NULL,
	PRIMARY KEY (nombreTerminal, cod_aerolinea),
   FOREIGN KEY (nombreTerminal) REFERENCES TERMINAL (nombreTerminal) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (cod_aerolinea) REFERENCES AEROLINEA (cod_aerolinea) ON DELETE CASCADE ON UPDATE CASCADE
);
-- -----------------------------------------------------
-- Tabla COMPRA creada de la relación PASAJERO y BILLETE
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS COMPRA (
	tipoDocumento VARCHAR(15) CHECK (tipoDocumento IN ('DNI', 'Pasaporte')),
	numDocumento VARCHAR(9) NOT NULL,
	numBillete INT NOT NULL,
	precio INT NOT NULL,
	PRIMARY KEY (tipoDocumento, numDocumento, numBillete),
	FOREIGN KEY (tipoDocumento, numDocumento) REFERENCES PASAJERO (tipoDocumento, numDocumento) ON DELETE CASCADE,
	FOREIGN KEY (numBillete) REFERENCES BILLETE (numBillete) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insertar datos en AEROLINEA
INSERT INTO AEROLINEA (cod_aerolinea, nombre, flota, alianza) VALUES
(1, 'Magic Carpet Airlines', 5, 'SkyTeam'),
(2, 'Fantasia Flights', 7, 'OneWorld'),
(3, 'Neverland Airways', 4, 'StarAlliance'),
(4, 'Pixie Dust Travel', 3, 'Ninguna');

-- Insertar datos en AVION
INSERT INTO AVION (matricula, estado, modelo, capacidadPasajeros, capacidadCarga, capacidadCombustible, fechaMantenimiento, cod_aerolinea) VALUES
(101, 'operativo', 'Boeing 747', 416, 15000, 183380, '2022-06-01', 1),
(102, 'operativo', 'Airbus A380', 555, 20000, 310000, '2022-07-15', 2),
(103, 'mantenimiento', 'Boeing 777', 396, 14000, 117500, '2022-05-20', 3),
(104, 'operativo', 'Airbus A320', 150, 7300, 27000, '2022-08-10', 4);

-- Insertar datos en CONTROL
INSERT INTO CONTROL (cod_control, tipoControl, autoridades) VALUES
(1, 'Acceso', 'Seguridad del aeropuerto'),
(2, 'Pasaportes', 'Policía'),
(3, 'Inspección adicional', 'Seguridad del aeropuerto'),
(4, 'Pasaportes', 'Seguridad del aeropuerto y Policía');

-- Insertar datos en TERMINAL
INSERT INTO TERMINAL (nombreTerminal, puertaEmbarque, serviciosDisponibles, cod_control) VALUES
('Terminal 1', 101, 'WiFi, Comida rápida', 1),
('Terminal 2', 102, 'Duty-Free, Lounge VIP', 2),
('Terminal 3', 103, 'Juegos para niños, Librería', 3),
('Terminal 4', 104, 'Nap-room, Lounge VIP', 4);

-- Insertar datos en PASAJERO
INSERT INTO PASAJERO (tipoDocumento, numDocumento, categoria, nombreCompleto, fechaNacimiento, nacionalidad, visado, email) VALUES
('DNI', '11223344D', 'Turista', 'Aladdin', '1992-11-25', 'Agrabano', 'no', 'aladdin@disney.com'),
('Pasaporte', '44556677T', 'Business', 'Buzz Lightyear', '1995-11-22', 'Estadounidense', 'no', 'buzz@pixar.com'),
('DNI', 'PGS334435', 'Primera', 'Mike Wazowski', '2001-11-02', 'Monstruopolitano', 'no', 'mike@monstersinc.com'),
('Pasaporte', 'CDB778899', 'Turista', 'Jack Skellington', '1993-10-13', 'Halloweenesco', 'no', 'jack@halloween.com');

-- Insertar datos en TRIPULACION
INSERT INTO TRIPULACION (cod_tripulacion, nombreCompleto, funcion, numLicencia, antiguedad, comandante) VALUES
(1, 'Mickey Mouse', 'piloto', 5555, '2008-11-18', 'si'),
(2, 'Woody', 'azafato', 6666, '2010-06-18', 'no'),
(3, 'Peter Pan', 'piloto', 7777, '2012-02-05', 'no'),
(4, 'Hercules', 'azafato', 8888, '2014-06-27', 'no');

-- Insertar datos en la tabla DESTINO
INSERT INTO DESTINO (codigoOACI, codigoIATA, ciudad, pais, zonaSchengen, zonaHorariaDestino) VALUES
('MKY1', 'M01', 'Motunui', 'Polinesia', 'no', 'UTC+13'),
('ARL1', 'A01', 'Arendelle', 'Noruega', 'si', 'UTC+1'),
('AGB1', 'A02', 'Agrabah', 'Marruecos', 'no', 'UTC+3'),
('ZOO1', 'Z01', 'Zootrópolis', 'China', 'no', 'UTC-6');

-- Insertar datos en la tabla PLAN_VUELO
INSERT INTO PLAN_VUELO (cod_plan_vuelo, ruta, altitud, velocidadPrevista, horarioSalidaEstimado, horarioLlegadaEstimado, notas, aeropuertoAlternativo, codigoOACI, codigoIATA) VALUES
(1, 'Ruta 1', 33000, 480, '2024-07-01 06:00:00', '2024-07-01 09:00:00', 'Vuelo directo', 'MKY2', 'MKY1', 'M01'),
(2, 'Ruta 2', 35000, 500, '2024-07-02 07:00:00', '2024-07-02 10:00:00', 'Tormentas', 'ARL2', 'ARL1', 'A01'),
(3, 'Ruta 3', 30000, 450, '2024-07-03 08:00:00', '2024-07-03 11:00:00', 'Vuelo directo', 'AGB2', 'AGB1', 'A02'),
(4, 'Ruta 4', 31000, 460, '2024-07-04 09:00:00', '2024-07-04 12:00:00', 'Tormentas', 'ZOO2', 'ZOO1', 'Z01');

-- Insertar datos en la tabla VUELO
INSERT INTO VUELO (numVuelo, fecha, horaSalida, horaLlegada, duracion, estado, servicio, codigoOACI, codigoIATA, matricula) VALUES
('VL123', '2024-07-01', '2024-07-01 06:00:00', '2024-07-01 09:00:00', '3 horas', 'A tiempo', 'Películas, Wi-Fi', 'MKY1', 'M01', 101),
('VL124', '2024-07-02', '2024-07-02 07:00:00', '2024-07-02 10:00:00', '3 horas', 'A tiempo', 'Comida incluida', 'ARL1', 'A01', 102),
('VL125', '2024-07-03', '2024-07-03 08:00:00', '2024-07-03 11:00:00', '3 horas', 'A tiempo', 'Asientos extra', 'AGB1', 'A02', 103),
('VL126', '2024-07-04', '2024-07-04 09:00:00', '2024-07-04 12:00:00', '3 horas', 'A tiempo', 'Entretenimiento a bordo', 'ZOO1', 'Z01', 104);

-- Insertar datos en la tabla BILLETE
INSERT INTO BILLETE (numBillete, codigoReserva, tarifa, asiento, equipaje, numVuelo, cod_aerolinea) VALUES
(1001, 2001, 'turista', 12, 1, 'VL123', 1),
(1002, 2002, 'business', 1, 2, 'VL124', 2),
(1003, 2003, 'primera', 2, 2, 'VL125', 3),
(1004, 2004, 'turista', 25, 1, 'VL126', 4);

INSERT INTO PASA (cod_control, tipoDocumento, numDocumento) VALUES
(1, 'DNI', '11223344D'),
(2, 'Pasaporte', '44556677T'),
(3, 'DNI', 'PGS334435'),
(2, 'Pasaporte', 'CDB778899');

-- Insertar datos en la tabla TRABAJA
INSERT INTO TRABAJA (numVuelo, cod_tripulacion) VALUES
('VL123', 1),
('VL124', 2),
('VL125', 3),
('VL126', 4);

-- Insertar datos en COMPRA
INSERT INTO COMPRA (tipoDocumento, numDocumento, numBillete, precio) VALUES
('DNI', '11223344D', 1001, 340),
('Pasaporte', '44556677T', 1002, 92),
('DNI', 'PGS334435', 1003, 920),
('Pasaporte', 'CDB778899', 1004, 110);

-- Insertar datos en OPERA
INSERT INTO OPERA (nombreTerminal, cod_aerolinea) VALUES
('Terminal 1', 1),
('Terminal 2', 2),
('Terminal 3', 3),
('Terminal 4', 4);

