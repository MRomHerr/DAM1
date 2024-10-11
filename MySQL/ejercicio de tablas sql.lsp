DROP DATABASE cadenaTiendas;
CREATE DATABASE cadenaTiendas;
USE cadenaTiendas;
CREATE TABLE tienda (
	tiendaID DECIMAL(5) PRIMARY KEY,
	direccion VARCHAR(20),
	poblacion VARCHAR(20),
	provincia VARCHAR(20),
	codpostal DECIMAL(5) NOT NULL
);
insert into tienda values(1,"direc","pob","prov",28000);

CREATE TABLE fabricante (
	fabricanteID DECIMAL(5) PRIMARY KEY,
	nombre VARCHAR(20),
	nif VARCHAR(10) NOT NULL
);

CREATE TABLE articulo (
	articuloID DECIMAL(5) PRIMARY KEY,
	nombre VARCHAR(20),
	fabricanteID DECIMAL(5),
	PVD DECIMAL(7,2) DEFAULT 0,
	PVP DECIMAL(7,2) DEFAULT ‘0’,
	FOREIGN KEY (fabricanteID) REFERENCES fabricantes(fabricanteID)
);

CREATE TABLE existencia (
	existenciaID DECIMAL(6),
	tiendaID VARCHAR(20),
	articuloID VARCHAR(10),
	cantidad DECIMAL(6)
);

CREATE TABLE empleado (
    empleadoID DECIMAL(5) PRIMARY KEY,
    nombre VARCHAR(50),
    tiendaID DECIMAL(5),
    salario DECIMAL(10,2) constraint empleados_salario_chk_mayor_0 check(salario >0),
    FOREIGN KEY (tiendaID) REFERENCES tiendas(tiendaID)
);




-- 1. Añadir una nueva columna a la tabla 'tiendas'

ALTER TABLE tienda
ADD COLUMN nombre_columna;


-- 2. Modificar el tipo de la columna 'codpostal' en la tabla 'tienda'

ALTER TABLE tienda
MODIFY COLUMN codpostal varchar(10);


-- 3. Eliminar la columna 'nif' de la tabla 'fabricante'

ALTER TABLE fabricante
drop COLUMN nif;

-- 4. Añadir una nueva columna a la tabla 'fabricante'

ALTER TABLE fabricante
ADD COLUMN nombre_columna;

-- 5. Añadir una restricción NOT NULL a la columna 'fabricanteID' en la tabla 'articulo'

ALTER TABLE articulo MODIFY fabricanteID INT NOT NULL;

UPDATE articulo SET fabricanteID = 0 WHERE fabricanteID IS NULL;


-- 6. Eliminar la tabla 'existencias'

drop TABLE existencias;

-- 7. Añadir una restricción UNIQUE a la columna 'nombre' en la tabla 'empleado'

ALTER TABLE empleado
ADD CONSTRAINT Unombre UNIQUE (nombre);

-- 8. Borrar la restricción del check de la columna salario de la tabla empleado

ALTER TABLE empleado
DROP CONSTRAINT empleados_salario_chk_mayor_0;


-- 9. Añadir los campos contacto VARCHAR(20) y telefono VARCHAR(15) en la tabla TIENDA. Mostrar una descripción de la tabla.

ALTER TABLE tienda
ADD COLUMN contacto VARCHAR(20), 
ADD COLUMN telefono VARCHAR(15);

-- 10. Cambiar la longitud del campo dirección a cuarenta caracteres en la tabla TIENDA. Mostrar una descripción de la tabla.

ALTER TABLE tienda MODIFY direccion VARCHAR(40);

-- 11. Cambiar el campo dirección para que sea no nulo. Mostrar una descripción de la tabla.

ALTER TABLE articulo MODIFY direccion VARCHAR(40) NOT NULL;
describe tienda;

-- 12. Añadir la restricción que sea mayor o igual que cero al campo cantidad en la tabla EXISTENCIA. Mostrar una descripción de la tabla.

ALTER TABLE existencia
MODIFY cantidad DECIMAL CHECK (cantidad >= 0);

describe existencia;

-- ejercicio4_5
CREATE TABLE empleados_alter (
numemp INT PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
edad INT,
oficina INT,
titulo VARCHAR(20),
contrato DATE NOT NULL,
director INT NOT NULL,
cuota INT,
ventas INT);

CREATE TABLE oficinas_alter (
oficina INT PRIMARY KEY,
ciudad VARCHAR(20),
region VARCHAR(20),
dir INT NOT NULL,
objetivo INT,
ventas INT);

CREATE TABLE productos_alter (
idfab VARCHAR(10),
idproducto VARCHAR(20),
descripcion VARCHAR(30) NOT NULL,
precio INT NOT NULL,
existencias INT ,
CONSTRAINT cp PRIMARY KEY (idfab,idproducto) );
    
CREATE TABLE clientes_alter(
numclie INT PRIMARY KEY ,
nombre VARCHAR(30) NOT NULL,
repclie INT ) ;


CREATE TABLE pedidos_alter (
numpedido INT PRIMARY KEY,
fechapedido DATE NOT NULL,
clie INT NOT NULL,
rep INT NOT NULL,
fab VARCHAR(10) NOT NULL,
producto VARCHAR(20) NOT NULL,
cant INT NOT NULL,
importe INT NOT NULL);

-- Añadir a la tabla empleados las claves foráneas que le faltan. (la columna oficina indica la oficina donde trabaja el empleado y la columna director indica quién dirige al empleado, su jefe inmediato).
 
 ALTER TABLE empleados
ADD CONSTRAINT FK_Oficina
FOREIGN KEY (oficina) REFERENCES oficinas(id_oficina);

ALTER TABLE empleados
ADD CONSTRAINT FK_Director
FOREIGN KEY (director) REFERENCES directores(id_director);


-- Añadir a la definición de clientes_alter la columna limitecredito.
alter table cliente and column limitecredito INT;

-- Hacer que no puedan haber dos empleados con el mismo nombre
ALTER TABLE empleados
ADD CONSTRAINT UC_Nombre UNIQUE (nombre);