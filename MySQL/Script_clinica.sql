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
