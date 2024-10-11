CREATE database tienda;
USE tienda;

create table cliente(
idCliente int(3) primary key,
nomCliente varchar(50),
ciudad varchar(100))
engine=InnoDB, charset=utf8mb4;

create table orden(
idOrden int(4) not null primary key,
fecha date not null,
constraint fk_01 foreign key(idCliente) references orden(cliente) on update cascade on delete set null,
idCliente int(3))
engine=InnoDB, charset=utf8mb4;

create table articulo(
numArticulo int(4) not null primary key,
nomArticulo varchar(60) not null,
precio double(5,2) not null)
engine=InnoDB, charset=utf8mb4;

create table pedido(
idOrden int(4) not null primary key,
constraint fk_02 foreign key(idArticulo) references pedido(articulo) on update cascade on delete no action,
numArticulo int(4) not null,
cantidad int(2) not null)
engine=InnoDB, charset=utf8mb4;

insert into cliente values ('101','Hierro','Madrid');
insert into cliente values ('107','Juan','Jaén');
insert into cliente values ('180','Pedro','Burgos');

insert into orden values ('2301','2021-02-23','101');
insert into orden values ('2302','2021-02-24','107');
insert into orden values ('2303','2021-02-25','180');

insert into articulo values ('3786','Red','35,00');
insert into articulo values ('4018','Raqueta','65,00');
insert into articulo values ('9132','Paq-3','4,75');
insert into articulo values ('5794','Paq-6','5,00');
insert into articulo values ('3141','Funda','10');

insert into pedido values ('2301','3786','3');
insert into pedido values ('2301','4018','6');
insert into pedido values ('2301','9132','8');
insert into pedido values ('2302','5794','4');
insert into pedido values ('2303','4018','2');
insert into pedido values ('2303','3141','2');











