
DROP DATABASE IF EXISTS AEROPUERTO;

CREATE DATABASE IF NOT EXISTS AEROPUERTO;
USE AEROPUERTO;



-- -----------------------------------------------------
-- Tabla AEROLÍNEA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS AEROLÍNEA (
	Cód_Aerolínea INT NOT NULL,
	Nombre VARCHAR(45) UNIQUE NOT NULL,
	Flota INT NOT NULL,
    Alianza VARCHAR(45) CHECK (Alianza IN ('OneWorld', 'SkyTeam', 'StarAlliance', 'Ninguna')),
	PRIMARY KEY (Cód_Aerolínea)
);

-- -----------------------------------------------------
-- Tabla AVIÓN
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS AVIÓN (
	Matrícula INT NOT NULL,
    Estado VARCHAR(13) CHECK (Estado IN ('operativo', 'mantenimiento')),
	Modelo VARCHAR(45) NOT NULL,
	Cap_Pasajeros INT NOT NULL,
	Cap_Carga INT NOT NULL,
	Cap_Combustible INT NOT NULL,
	FechaMantenimiento DATE NOT NULL,
	Cód_Aerolínea INT NOT NULL,
	PRIMARY KEY (Matrícula, Cód_Aerolínea),
	FOREIGN KEY (Cód_Aerolínea) REFERENCES AEROLINEA (Cód_Aerolínea) ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Tabla CONTROL
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS CONTROL (
	Cód_Control INT NOT NULL,
    Tipo VARCHAR(25) CHECK (tipo IN ('Acceso', 'Pasaportes', 'Inspección adicional')),
    Autoridades VARCHAR(25) CHECK (Autoridades IN ('Seguridad del aeropuerto', 'Policía')),
	PRIMARY KEY (Cód_Control)
);

-- -----------------------------------------------------
-- Tabla TERMINAL
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TERMINAL (
	Nombre_Terminal VARCHAR(45) NOT NULL,
	Puerta_Embarque INT UNIQUE NOT NULL,
	Servicios_Disponibles VARCHAR(45) NOT NULL,
	Cód_Control INT NOT NULL,
	PRIMARY KEY (Nombre_Terminal, Cód_Control),
    FOREIGN KEY (Cód_Control) REFERENCES CONTROL (Cód_Control) ON DELETE CASCADE
);


-- -----------------------------------------------------
-- Tabla PASAJERO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PASAJERO (
	TipoDocumento VARCHAR(15) CHECK (TipoDocumento IN ('DNI', 'Pasaporte')),
	NumDocumento INT NOT NULL,
	NombreCompleto VARCHAR(100) NOT NULL,
	FechaNacimiento DATE NOT NULL,
	Nacionalidad VARCHAR(45) NOT NULL,
    Visado VARCHAR(2) CHECK (visado IN ('si', 'no')),
	Email VARCHAR(100) NULL,
	PRIMARY KEY (TipoDocumento, NumDocumento)
);

-- -----------------------------------------------------
-- Tabla TRIPULACIÓN
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TRIPULACIÓN (
	Cód_Tripulación INT NOT NULL,
	NombreCompleto VARCHAR(100) NOT NULL,
    Función VARCHAR(9) CHECK (funcion IN ('piloto', 'azafato')),
	NumLicencia INT UNIQUE NOT NULL,
	Antigüedad DATE NOT NULL,
    Comandante VARCHAR(2) CHECK (Comandante IN ('si', 'no')),
	PRIMARY KEY (Cód_Tripulación)
);

-- -----------------------------------------------------
-- Tabla DESTINO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DESTINO (
	Cód_OACI VARCHAR(4) NOT NULL,   			
	Cód_IATA VARCHAR(3) NOT NULL,
	Ciudad VARCHAR(45) NOT NULL,
	País VARCHAR(45) NOT NULL,
    Zona_Schengen VARCHAR(2) CHECK (ZonaSchengen IN ('si', 'no')),
	Horario_Destino VARCHAR(45) NOT NULL,
	PRIMARY KEY (Cód_OACI, Cód_IATA)
);

-- -----------------------------------------------------
-- Tabla PLAN_VUELO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PLAN_VUELO (
	Cód_Plan INT NOT NULL,
	Ruta VARCHAR(45) NOT NULL,
	Altitud DOUBLE NOT NULL,   
	Velocidad DOUBLE NOT NULL,
	H.Salida TIME NOT NULL,
	H.Llegada TIME NOT NULL,
	Notas VARCHAR(45) NOT NULL,
	Aero_Alternativo VARCHAR(45) NOT NULL,
	Cód_OACI VARCHAR(4) NOT NULL,
    Cód_IATA VARCHAR(3) NOT NULL,
	PRIMARY KEY (Cód_Plan, Cód_OACI, Cód_IATA),
	FOREIGN KEY (Cód_OACI, Cód_IATA) REFERENCES DESTINO (Cód_OACI, Cód_IATA) ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Tabla VUELO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS VUELO (
	Num_Vuelo VARCHAR(6) NOT NULL,
	Fecha DATE NOT NULL,
	H.Salida TIME NOT NULL,
	H.Llegada TIME NOT NULL,
	Duración VARCHAR(45) NOT NULL,
	Estado VARCHAR(45) NOT NULL,  		
	Servicios VARCHAR(45) NOT NULL,
	Cód_OACI VARCHAR(4) NOT NULL,
    Cód_IATA VARCHAR(3) NOT NULL,
	Matrícula INT NOT NULL,
	PRIMARY KEY (Num_Vuelo, Cód_OACI, Cód_IATA, Matrícula),
	FOREIGN KEY (Cód_OACI, Cód_IATA) REFERENCES DESTINO (Cód_OACI, Cód_IATA) ON DELETE CASCADE,
	FOREIGN KEY (Matrícula) REFERENCES AVION (Matrícula) ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Tabla BILLETE
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS BILLETE (
	NumBillete INT NOT NULL,
	Cód_Reserva INT NOT NULL,
    Tarifa VARCHAR(15) CHECK (Tarifa IN ('económica', 'business', 'primera')),
	Asiento INT NOT NULL,
	Equipaje INT NOT NULL,
	Num_Vuelo VARCHAR(6) NOT NULL,
	Cód_Aerolínea INT NOT NULL,
	PRIMARY KEY (NumBillete, Num_Vuelo, Cód_Aerolinea),
    FOREIGN KEY (Num_Vuelo) REFERENCES VUELO (Num_Vuelo) ON DELETE CASCADE,
    FOREIGN KEY (Cód_Aerolínea) REFERENCES AEROLINEA (Cód_Aerolínea) ON DELETE CASCADE
);


-- -----------------------------------------------------
-- Tabla PASA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PASA (
	Cód_Control INT NOT NULL,
	TipoDocumento VARCHAR(15) CHECK (TipoDocumento IN ('DNI', 'Pasaporte')),
	NumDocumento INT NOT NULL,
	PRIMARY KEY (Cód_Control, TipoDocumento, NumDocumento),
    FOREIGN KEY (Cód_Control) REFERENCES CONTROL (Cód_Control) ON DELETE CASCADE,
    FOREIGN KEY (TipoDocumento, NumDocumento) REFERENCES PASAJERO (TipoDocumento, NumDocumento) ON DELETE CASCADE
);


-- -----------------------------------------------------
-- Tabla TRABAJA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TRABAJA (
	Num_Vuelo VARCHAR(6) NOT NULL,
	Cód_Tripulación INT NOT NULL,
	PRIMARY KEY (Num_Vuelo, Cód_Tripulación),
    FOREIGN KEY (Num_Vuelo) REFERENCES VUELO (Num_Vuelo) ON DELETE CASCADE,
    FOREIGN KEY (Cód_Tripulación) REFERENCES TRIPULACION (Cód_Tripulación) ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Tabla OPERA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS OPERA (
	Nombre_Terminal VARCHAR(45) NOT NULL,
	Cód_Aerolínea INT NOT NULL,
	PRIMARY KEY (Nombre_Terminal, Cód_Aerolínea),
    FOREIGN KEY (Nombre_Terminal) REFERENCES TERMINAL (Nombre_Terminal) ON DELETE CASCADE,
    FOREIGN KEY (Cód_Aerolínea) REFERENCES AEROLINEA (Cód_Aerolínea) ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Tabla COMPRA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS COMPRA (
	TipoDocumento VARCHAR(15) CHECK (TipoDocumento IN ('DNI', 'Pasaporte')),
	NumDocumento INT NOT NULL,
	NumBillete INT NOT NULL,
	Precio DOUBLE NOT NULL,
	PRIMARY KEY (TipoDocumento, NumDocumento, NumBillete),
	FOREIGN KEY (TipoDocumento, NumDocumento) REFERENCES PASAJERO (TipoDocumento, NumDocumento) ON DELETE CASCADE,
	FOREIGN KEY (NumBillete) REFERENCES BILLETE (NumBillete) ON DELETE CASCADE
);


-- Insertar datos en la tabla DESTINO
INSERT INTO DESTINO 
    (Cód_OACI, Cód_IATA, Ciudad, País, Zona_Sehengen, Horario_Destino) 
VALUES
    ('MKY1', 'M01', 'Motunui', 'Polinesia', 'no', 'UTC+13'),
    ('ARL1', 'A01', 'Arendelle', 'Noruega', 'si', 'UTC+1'),
    ('AGB1', 'A02', 'Agrabah', 'Australia', 'no', 'UTC+3'),
    ('ZOO1', 'Z01', 'Zootrópolis', 'China', 'no', 'UTC-6');

-- Insertar datos en la tabla VUELO
INSERT INTO VUELO 
    (Num_Vuelo, Fecha, H.Salida, H.Llegada, Duración, Estado, Servicios, Cód_OACI, Cód_IATA, Matrícula) 
VALUES
    ('VL123', '2024-07-01', '06:00:00', '09:00:00', '3 horas', 'A tiempo', 'Películas, Wi-Fi', 'MKY1', 'M01', 101),
    ('VL124', '2024-07-02', '07:30:00', '10:30:00', '3 horas', 'Retrasado', 'Comida incluida', 'ARL1', 'A01', 102),
    ('VL125', '2024-07-03', '08:00:00', '13:00:00', '5 horas', 'A tiempo', '', 'AGB1', 'A02', 103),
    ('VL126', '2024-07-04', '09:00:00', '11:00:00', '2 horas', 'A tiempo', 'Entretenimiento', 'ZOO1', 'Z01', 104);

-- Insertar datos en la tabla PLAN_VUELO
INSERT INTO PLAN_VUELO 
    (Cód_Plan, Ruta, Altitud, velocidad, H.Salida, H.Llegada, Notas, Aero_Alternativo, Cód_OACI, Cód_IATA) 
VALUES
    (1, 'R1-R2-R3', 33000, 480, '06:00:00', '09:00:00', 'Vuelo directo', 'MKY2', 'MKY1', 'M01'),
    (2, 'R4-R5', 35000, 500, '07:00:00', '10:00:00', 'Zonas restringidas', 'ARL2', 'ARL1', 'A01'),
    (3, 'R6', 30000, 450, '08:00:00', '11:00:00', 'Vuelo directo', 'AGB2', 'AGB1', 'A02'),
    (4, 'R7-R8', 31000, 460, '09:00:00', '12:00:00', 'Aviso de tormentas', 'ZOO2', 'ZOO1', 'Z01');

-- Insertar datos en AVION
INSERT INTO AVIÓN 
    (Matrícula, Estado, Modelo, Cap_Pasajeros, Cap_Carga, Cap_Combustible,  FechaMantenimiento, Cód_Aerolinea) 
VALUES
    (101, 'operativo', 'Boeing 747', 416, 15000, 183380, '2022-06-01', 1),
    (102, 'operativo', 'Airbus A380', 555, 20000, 310000, '2022-07-15', 2),
    (103, 'operativo', 'Boeing 777', 396, 14000, 117500, null, 3),
    (104, 'operativo', 'Airbus A320', 150, 7300, 27000, '2022-08-10', 4);

-- Insertar datos en AEROLINEA
INSERT INTO AEROLÍNEA 
    (Cód_Aerolinea, Nombre, Flota, Alianza) 
VALUES
    (01, 'Magic Carpet Airlines', 5, 'SkyTeam'),
    (02, 'Fantasia Flights', 7, 'OneWorld'),
    (03, 'Neverland Airways', 4, 'StarAlliance'),
    (04, 'Pixie Dust Travel', 3, 'Ninguna');

-- Insertar datos en TERMINAL
INSERT INTO TERMINAL 
    (Nombre_Terminal, Puerta_Embarque, Servicios_Disponibles, Cód_Control) 
VALUES
    ('T1', 'A13', 'WiFi, Restaurantes', 'C1'),
    ('T3', 'B17', 'Duty-Free, Souvenirs', 'C2'),
    ('T4s', 'C21', 'Juegos para niños, Librería', 'C3'),
    ('T4', 'D39', 'Nap-room, Lounge VIP', 'C4');

-- Insertar datos en CONTROL
INSERT INTO CONTROL 
    (Cód_Control, Tipo, Autoridades) 
VALUES
    ('C1','Pasaportes', 'Seguridad del aeropuerto'),
    ('C2', 'Acceso', 'Policía'),
    ('C3', 'Inspección adicional', 'Seguridad'),
    ('C4', 'Pasaportes', 'Policía');

-- Insertar datos en la tabla PASA
INSERT INTO PASA 
    (Cód_Control, TipoDocumento, NumDocumento) 
VALUES
    ('C1', 'DNI', '11223344D'),
    ('C2', 'DNI', '44556677T'),
    ('C3','Pasaporte', 'PGS334435'),
    ('C2', 'Pasaporte', 'CDB778899');

-- Insertar datos en PASAJERO
INSERT INTO PASAJERO 
    (TipoDocumento, NumDocumento,  NombreCompleto, FechaNacimiento, Nacionalidad, Visado, Email) 
VALUES
    ('DNI', '11223344D', 'Aladdin', '1992-11-25', 'Agrabano', 'si', 'aladdin@disney.com'),
    ('DNI', '44556677T', 'Buzz Lightyear', '1995-11-22', 'Espacial', 'no', 'buzz@pixar.com'),
    ('Pasaporte', 'PGS334435', 'Mike Wazowski', '2001-11-02', 'Monstruopolitano', 'no', 'mike@monstersinc.com'),
    ('Pasaporte', 'CDB778899', 'Jack Skellington', '1993-10-13', 'Halloweenesco', 'si', 'jack@halloween.com');

-- Insertar datos en la tabla BILLETE
INSERT INTO BILLETE 
    (NumBillete, Cód_Reserva, Tarifa, Asiento, Equipaje, Num_Vuelo, Cód_Aerolínea) 
VALUES
    (1001, 2001, 'turista', '12F', 1, 'VL123', 01),
    (1002, 2002, 'business', '12F', 2, 'VL124', 02),
    (1003, 2003, 'primera', '22D', 2, 'VL125', 03),
    (1004, 2004, 'turista', '25F', 0, 'VL126', 04);

-- Insertar datos en la tabla TRABAJA
INSERT INTO TRABAJA 
    (Num_Vuelo, Cód_Tripulación) 
VALUES
    ('VL123', 999),
    ('VL124', 888),
    ('VL125', 777),
    ('VL126', 666);

-- Insertar datos en TRIPULACION
INSERT INTO TRIPULACIÓN 
    (Cód_Tripulación, NombreCompleto, Función, NumLicencia, Antigüedad, Comandante) 
VALUES
    (999, 'Mickey Mouse', 'piloto', 5555, '2008-11-18', 'si'),
    (888, 'Woody', 'azafato', 6666, '2010-06-18', 'no'),
    (777, 'Peter Pan', 'piloto', 7777, '2012-02-05', 'no'),
    (666, 'Harry Potter', 'azafato', 8888, '2014-06-27', 'no');

-- Insertar datos en OPERA
INSERT INTO OPERA 
    (Nombre_Terminal, Cód_Aerolínea) 
VALUES
    ('T1', 01),
    ('T3', 02),
    ('T4s', 03),
    ('T4', 04);

-- Insertar datos en COMPRA
INSERT INTO COMPRA 
    (Precio, TipoDocumento, NumDocumento, NumBillete) 
VALUES
    (340, 'DNI', 'piloto', '11223344D', 1001),
    (92, 'DNI', 'azafato', '44556677T', 1002),
    (920, 'Pasaporte', 'piloto', 'PGS334435', 1003),
    (110, 'Pasaporte', 'azafato','CDB778899', 1004);
