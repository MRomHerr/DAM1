create database if not exists universidad;

use universidad;

create table if not exists alumno (
alumno_ID int primary key,
nombre varchar(40) not null,
direccion varchar (40) not null,
telefono varchar (12) not null
);

create table if not exists departamento (
dptoID int primary key,
nombre varchar(40) not null
);

create table if not exists asignatura (
asignaturaID int primary key,
nombre varchar(50) not null,
numhoras int check (numhoras >1 and numhoras<1000),
precio int not null,
dptoID int not null,
foreign key (dptoID) references departamento(dptoID) on delete cascade on update cascade
);

create table if not exists calificacion (
calificacionID int primary key,
alumno_ID int not null,
asignaturaID int not null,
fecha date not null,
calificacion dec(3,2) check (calificacion > 0 and calificacion < 10),
foreign key (alumno_ID) references alumno(alumno_ID) on delete cascade on update cascade,
foreign key (asignaturaID) references asignatura(asignaturaID) on delete cascade on update cascade
);

insert ignore into alumno
values (1, 'Sanchez Hermosilla, Alberto', 'Higueruelas 12', '654782615');

insert ignore into alumno values 
(2, 'Alba Tordesillas, Ana Maria', 'Picasso 112', '632487559'),
(3, 'Torres Almagro, Guillermo', 'Alcala 415 ', '651235674'),
(4, 'Llanos Lopez, Maria Luisa', 'Alcantara 53', '679254812');

insert ignore into departamento values
(1, 'Programacion'),
(2, 'Sistemas Operativos'),
(3, 'Bases de Datos');

insert ignore into asignatura values
(1, 'Fundamentos de Programacion', 120, 350, 1),
(2, 'Elementos de Hardware', 75, 200, 2),
(3, 'Programacion Avanzada en Java', 100, 400, 1),
(4, 'Sistemas Operativos Monopuesto', 200, 450, 2),
(5, 'Implantacion de Bases de Datos', 90, 300, 3),
(6, 'Bases de Datos no Relacionales', 250, 800, 3);

insert ignore into calificacion (calificacionID, alumno_ID, asignaturaID) values
(1,2,4),
(2,1,3),
(3,3,6),
(4,1,2),
(5,2,5),
(6,3,1),
(7,3,4);

commit;

insert ignore into alumno
values (5, 'Romero Cifuentes, Elena', 'Marcelo Usera 24', '624155975');

insert ignore into calificacion (calificacionID, alumno_ID, asignaturaID) values
(8,5,4),
(9,5,5);

update calificacion set fecha = str_to_date('01-06-2015', '%d-%m-%Y');

update calificacion set calificacion = 6.25 where asignaturaID = 2 and alumno_ID = 1;

update calificacion set calificacion = 9.25 where asignaturaID = 6 and alumno_ID = 3;

update calificacion set calificacion = 7.5 where asignaturaID = 1 and alumno_ID = 3;

update calificacion set calificacion = 5 where asignaturaID = 6 and calificacion = null;

insert ignore into asignatura values
(7, 'Programacion en Python', 200, 500, 1);

insert ignore into calificacion (calificacionID, alumno_ID, asignaturaID) values
(10,1,7),
(11,3,7),
(12,5,7);

update asignatura set precio = precio*1.05;

update asignatura set precio = precio*1.10 where numhoras < 100;

update asignatura set precio = precio-50 where dptoID = 3;

commit;

alter table calificacion drop constraint calificacion_chk_1;

alter table calificacion add constraint check (calificacion >= 0 and calificacion <= 10);

update calificacion set calificacion = 0 where calificacion is null;

commit;

update asignatura set dptoID = 1 where dptoID = 3;

delete from departamento where nombre = 'Bases de Datos';

rollback;