
drop database if exists Empresa;
create database if not exists Empresa;
use empresa;

create table Empleados (
    nombre varchar(50),
    apellidos varchar(60),
    fechaNacimiento date,
    fechaIngreso date,
    puesto varchar(50),
    salario double(10,2));

create table EmpleadosAntiguos (
    nombre varchar(50),
    apellidos varchar(50),
    fechaNacimiento date,
    fechaIngreso date,
    fechaFinalizacion date
);



insert into Empleados VALUES
('Juan', 'Torres', '1960-01-01', '1980-05-24', 'Jefe', 60000.00),
('Sara', 'Gonzalez', '1980-05-02', '1999-06-03', 'Secretaria', 25000.00),
('Elena', 'Sanchez', '1990-09-03', '2010-11-02', 'TecnicoFP', 30000.00),
('Pepe', 'Uriel', '1991-10-04', '2015-10-01', 'Administrativo', 24000.00),
('Marcos', 'Romero', '2004-11-29', '2018-07-03', 'Administrativo', 22000.00);

create user 'marcos1'@'%' identified by '******';
grant all privileges on empresa.* to 'marcos1'@'%';
flush privileges;
exit;
