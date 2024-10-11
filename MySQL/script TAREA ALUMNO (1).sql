CREATE database tareaalumno;
USE traeaalumno;

create table ciclo(
idciclo varchar(5) not null,
nombreciclo varchar(45) not null) engine = InnoDB, charset = utf8mb4;

create table alumno(
NIA INT(8) not null primary key auto_increment,
constraint fk_01 foreign key(idciclo) references alumno(ciclo) on update cascade on delete no action,
idciclo varchar(5) not null,
nombrealumno varchar(20) not null,
numneroalumno varchar(2)) engine = InnoDB, charset = utf8mb4;


insert into alumno (idciclo,numeroalumno,nombrealumno) values (14302,"Juan",1);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14302,"Pepe",2);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14302,"Elena",3);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14302,"Marta",4);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14302,"Hugo",5);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14303,"Sara",1);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14303,"Inés",2);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14303,"Carlos",3);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14303,"Manolo",4);
insert into alumno (idciclo,numeroalumno,nombrealumno) values (14303,"Manuel",5);

insert into ciclo values (14302,"DAM");
insert into ciclo values (14302,"DAM");
insert into ciclo values (14302,"DAM");
insert into ciclo values (14302,"DAM");
insert into ciclo values (14302,"DAM");
insert into ciclo values (14303,"DAw");
insert into ciclo values (14303,"DAw");
insert into ciclo values (14303,"DAw");
insert into ciclo values (14303,"DAw");
insert into ciclo values (14303,"DAw");


