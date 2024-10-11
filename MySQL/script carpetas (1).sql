create database IE_SanJuandelaCruz;
USE IE_SanJuandelaCruz;

create table carpeta(
idcarpeta int (7) not null primary key,
nombre varchar(10) not null,
constraint fk_01 foreign key(contiene) references carpeta(carpeta) on update cascade on delete set null,
contiene varchar(10) not null;
descripción varchar(100);

insert into carpeta values(1234567,'DAM','Juan',null);
insert into carpeta values(7654321,'DAM','Sara',null);
insert into carpeta values(7415263,'DAW','Elena',null);
insert into carpeta values(3562417,'DAW','Pepe',null);
