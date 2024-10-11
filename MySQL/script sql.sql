-- ejercicio1
create database clinica

use clinica

create table medico (
codigo char(20) primary KEY,
nombre char(20),
apellidos char(50));

create table paciente (
codigo char(20) primary KEY,
nombre char(20),
apellidos char(50));

create table ingreso (
codigo char(20) primary key,
habitacion int(2),
fecha date,
codigo_paciente char(20),
codigo_medico char(20) ,
foreign key (codigo_medico) references medico(codigo),
foreign key (codigo_paciente) references paciente(codigo));

-- ejercicio2  <>significa distinto de
create database PUBS

use PUBS

create table EMPLEADO (
DNI_empleado char(9) primary KEY,
nombre char(20) not null,
domicilio char (50)
);

create table LOCALIDAD (
COD_localidad int primary key not null,
nombre char(20) not null
);

create table PUB (
cod_PUB char(20) primary key not null,
nombre char(20)not null,
licencia_fiscal char(50) not null,
domicilio char (50),
fecha_apertura date not null,
horario char(10) not null CHECK (horario IN ('HOR1', 'HOR2', 'HOR3')),  -- horario enum ('HOR1', 'HOR2', 'HOR3')
cod_localidad int not null,
foreign key (cod_localidad) references LOCALIDAD(COD_localidad) on delete cascade
);

create table TITULAR (
DNI_titular char(9) primary key not null,
nombre char(20) not null,
domicilio char (50),
cod_PUB char(20)not null,
foreign key (cod_PUB) references PUB(cod_PUB) on delete cascade
);

create table EXISTENCIAS (
COD_articulo char(9) primary key not null,
nombre char(20) not null,
cantidad int (50) not null,
precio float not null CHECK (precio > 0),
cod_PUB char(20) not null,
foreign key (cod_PUB) references PUB(cod_PUB) on delete cascade
);

create table PUB_EMPLEADO (
Funcion char(9) primary key not null CHECK (Funcion IN ('CAMARERO', 'SEGURIDAD', 'LIMPIEZA')),,
Cod_PUB char(20) not null,
DNI_empleado char(9) not null,
foreign key (cod_PUB) references PUB(cod_PUB) on delete cascade,
foreign key (DNI_empleado) references Empleado(DNI_empleado) on delete cascade
);