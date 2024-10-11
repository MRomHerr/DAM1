CREATE DATABASE BD01s_Producto;
USE BD01s_Producto;

create table producto(
codigo_producto int(10) primary key,
nombre varchar(100) not null,
precio double not null,
foreign key (codigo_fabricante) references fabricante(codigo_fabricante) on update cascade on delete set null);

create table fabricante (
codigo_fabricante int(10) primary key,
nombre varchar(100) not null);

INSERT INTO fabricante (nombre) VALUES ('Sony'),('Creative Labs'),('Hewlett-Packard'),('Iomega'),('Fujitsu'),('Winchester'),('Bose');
INSERT INTO producto (nombre,precio,codigo) VALUES ('Hard drive',240,5),('Memory',120,6),('ZIP drive',150),('Floppy disk',5,6),('Monitor',250,1),('DVD driver',180,2),('CD drive',90,2),('Printer',270,3),('Toner cartridge',66,3),('DVD burner',180,2);


-- 1 Selecciona todos los productos que hay en la tabla añadiendo un campo después de precio que muestre la unidad de €.
SELECT codigo, nombre, CONCAT(precio, ' €') AS precio_unitario
FROM producto;

-- 2 Nombre y precio de productos con precio menor de 120€ en formato descendente, mostrando la moneda.
SELECT nombre, CONCAT(precio, '€') AS moneda
FROM producto
WHERE precio < 120
ORDER BY precio DESC;

-- 3a Nombre y precio de productos con precio mayor o igual a 180€ de forma Ascendente, mostrando la moneda.
SELECT nombre, CONCAT(precio, '€') AS moneda
FROM producto
WHERE precio >= 180
ORDER BY precio ASC;

-- 3b Nombre y precio de productos que no tienen un precio mayor o igual a 180€, mostrando la moneda.
SELECT nombre, CONCAT(precio, '€') AS moneda
FROM producto
WHERE precio < 180;


-- 3c Nombre y precio de productos que tienen un precio entre 100€ y 200€ en formato ascendente, mostrando la moneda.
SELECT nombre, CONCAT(precio, '€') AS precio
FROM producto
WHERE precio BETWEEN 100 AND 200
ORDER BY precio ASC;

-- 4a Mostrar el nombre y el precio de los productos en dólares. Para ello tendrás que buscar el cambio actual del euro a dólar y recalcular sus
-- precios. Se mostrará la moneda de Dólar con el símbolo $. Define una variable que se llame dólar para realizar los cálculos.
SELECT nombre, CONCAT('$', precio/1.19) AS precio_en_dolares FROM producto;

-- 4b Redondear el valor anterior a dos decimales con la función matemática ROUND: ROUND(campo, nºdecimales).
SELECT nombre, CONCAT('$', precio/1.19) AS precio_en_dolares FROM producto;
SELECT nombre, ROUND(precio_en_dolares, 2) AS precio_redondeado FROM producto;


-- 5 Muestra todos los productos que tengan un precio mayor de 150€ cuyo fabricante sea Fujitsu. Fija el código del fabricante mediante una variable en un SELECT.
SET @codigo_fabricante=5;
SELECT * FROM producto WHERE precio > 150 AND codigo_fabricante = @codigo_fabricante;

-- 6 Listar todos los productos donde el código del fabricante sea 1,3 ó 5.
SELECT * FROM producto WHERE codigo_fabricante = 1 or codigo_fabricante = 3 or codigo_fabricante = 5;

-- 7 Listar todos los productos que sean DVD.
SELECT * FROM producto WHERE nombre = 'DVD driver' OR nombre = 'DVD burner';

-- 8 Listar todos los productos que sean CD o DVD.
SELECT * FROM producto WHERE nombre = 'CD drive' OR nombre = 'DVD driver' OR nombre = 'DVD burner';

-- 9 Listar todos los productos que sean drive o disk.
SELECT * FROM producto WHERE nombre LIKE '%drive%' OR nombre LIKE '%disk%';

-- 10 Listar los productos que acaben con la letra “e”.
SELECT * FROM producto WHERE nombre LIKE '%e';

-- 11 Listar los fabricantes que comiencen por la letra S.
SELECT * FROM fabricante WHERE nombre LIKE 'S%';

-- 12 Listar los fabricantes que contengan la letra S y la letra E.
SELECT * FROM fabricante WHERE nombre LIKE '%S%E%';

-- 13 Listar los productos que comiencen por la letra C o la letra D y acaben por la letra E.
SELECT * FROM producto WHERE (nombre LIKE 'C%e' OR nombre LIKE 'D%e');

-- 14 Listar los productos que no contengan ni CD ni DVD.
SELECT * FROM producto WHERE nombre NOT LIKE '%CD%' AND nombre NOT LIKE '%DVD%';

-- 15 Seleccionar productos que contengan la palabra drive y no sean ni CD ni DVD.
SELECT * FROM producto WHERE nombre LIKE '%drive%' AND nombre NOT LIKE '%CD%' AND nombre NOT LIKE '%DVD%';

-- 16 Muestra la información completa de los productos con código 1,5,8 sin utilizar la palabra reservada OR y AND. Ordénalos por precio de mayor a menor.
SELECT * FROM producto WHERE codigo_producto IN (1, 5, 8) ORDER BY precio DESC;

-- 17 Muestra todos los productos cuyo precio sea a partir de 100€ y no sea ni 180 ni 240. Utiliza un solo operador de comparación.
SELECT * FROM producto WHERE precio >= 100 AND precio <> 180 AND precio <> 240;

-- 18a Selecciona los primeros 5 fabricantes.
SELECT * FROM fabricante LIMIT 5;

-- 18b Selecciona 2 fabricantes a partir del 4º.
SELECT * FROM fabricante LIMIT 2 OFFSET 3;

-- Parte II: Consultas con funciones.
-- 20 Cuenta el número de fabricantes.
SELECT COUNT(*) AS num_fabricantes FROM fabricante;

-- 21 Cuenta los fabricantes que contienen la letra e.
SELECT COUNT(*) FROM fabricante WHERE nombre LIKE '%e%';

-- 22 Muestra los códigos de fabricante distintos que aparecen en la tabla productos. No se pueden repetir.
SELECT DISTINCT codigo_fabricante FROM producto;

-- 23 Calcula la media del precio de los productos mostrando el valor de €. Utiliza la función concat().
SELECT CONCAT('€', AVG(precio)) as media_precio FROM producto;

-- 24 Calcula el precio medio de los productos en el valor monetario de Dólares mostrando su símbolo $.
SELECT CONCAT('$', AVG(precio)) AS 'Precio medio en $' FROM producto;

-- 25  Cuenta el número de productos que tiene cada fabricante, mostrando el nombre del fabricante.
SELECT fabricante.nombre, COUNT(*) AS num_productos FROM producto
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo_fabricante
GROUP BY fabricante.nombre;

-- 26 Muestra el nombre, precio y fabricante de todos los productos, ordenado por el nombre en forma ascendente. Hazlo de dos formas diferentes.
-- forma 1
SELECT producto.nombre, producto.precio, fabricante.nombre FROM producto 
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo_fabricante 
ORDER BY producto.nombre ASC;

-- forma 2
SELECT nombre, precio, (SELECT nombre FROM fabricante WHERE codigo_fabricante = producto.codigo_fabricante) AS fabricante 
FROM producto ORDER BY nombre ASC;

-- 27 Calcula el precio medio de los productos de cada fabricante, mostrando el nombre de cada fabricante y su símbolo en €. Hazlo de dos formas diferentes.
-- forma 1
SELECT f.nombre, CONCAT(ROUND(AVG(p.precio),2), ' €') as precio_medio FROM producto p 
JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante  GROUP BY f.nombre;

-- forma 2
SELECT f.nombre, CONCAT(ROUND(AVG(p.precio),2), ' €') as precio_medio FROM fabricante f 
LEFT JOIN producto p ON p.codigo_fabricante = f.codigo_fabricante GROUP BY f.nombre;

-- 28 Selecciona los nombres de los fabricantes cuya media del precio de productos supera los 150€. Mostrar el nombre fabricante y su media,
-- ordenado por su media de forma descendente. Hazlo de dos formas diferentes.

-- forma 1
SELECT f.nombre, FORMAT(AVG(p.precio),2,'de_DE') AS 'Media (€)'
FROM fabricante f
INNER JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.codigo_fabricante
HAVING AVG(p.precio) > 150
ORDER BY AVG(p.precio) DESC;

-- forma 2
SELECT f.nombre, FORMAT(media_precios,2,'de_DE') AS 'Media (€)' FROM fabricante f
INNER JOIN (
    SELECT codigo_fabricante, AVG(precio) AS media_precios
    FROM producto
    GROUP BY codigo_fabricante
    HAVING AVG(precio) > 150
) t ON f.codigo_fabricante = t.codigo_fabricante ORDER BY media_precios DESC;


-- 29 Obtén el producto más barato de todos los productos. Muestra el nombre del producto, precio en euros y el nombre del fabricante.
SELECT p.nombre AS 'Nombre Producto', CONCAT(p.precio, ' €') AS 'Precio', f.nombre AS 'Nombre Fabricante' FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante
WHERE p.precio = (SELECT MIN(precio) FROM producto);


-- 30 Obtén el producto más caro y más barato, mostrando el nombre, el precio en Euros y el nombre del fabricante.
SELECT p.nombre AS 'Nombre del producto', p.precio AS 'Precio en Euros', f.nombre AS 'Nombre del fabricante'
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante
WHERE p.precio = (SELECT MAX(precio) FROM producto)
   OR p.precio = (SELECT MIN(precio) FROM producto);
   
-- 31 Obtén el nombre de cada fabricante con el nombre y precio de su producto más caro.Para poder comprobarlo deberás añadir los siguientes productos:
-- ddr2 memory, 50€, Winchester
-- Bluetooth Speakers, 230€, bose
-- Multimedia Speakers, 140€, bose
-- Multimedia White Speakers, 80€, bose
INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES
('ddr2 memory', 50, 6),
('Bluetooth Speakers', 230, 7),
('Multimedia Speakers', 140, 7),
('Multimedia White Speakers', 80, 7);
SELECT f.nombre as nombre_fabricante, p.nombre as nombre_producto, p.precio as precio_producto
FROM fabricante f
INNER JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante
WHERE p.precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = f.codigo_fabricante);
-- b) Idem con el Producto más barato.
SELECT f.nombre as nombre_fabricante, p.nombre as nombre_producto, p.precio as precio_producto
FROM fabricante f
INNER JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante
WHERE p.precio = (SELECT MIN(precio) FROM producto WHERE codigo_fabricante = f.codigo_fabricante);
-- c) Idem con el Producto más caro y barato.
SELECT f.nombre as nombre_fabricante, 
    (SELECT p1.nombre FROM producto p1 WHERE p1.codigo_fabricante = f.codigo_fabricante AND p1.precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = f.codigo_fabricante)) as nombre_producto_caro,
    (SELECT p2.nombre FROM producto p2 WHERE p2.codigo_fabricante = f.codigo_fabricante AND p2.precio = (SELECT MIN(precio) FROM producto WHERE codigo_fabricante = f.codigo_fabricante)) as nombre_producto_barato,
    (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = f.codigo_fabricante) as precio_producto_caro,
    (SELECT MIN(precio) FROM producto WHERE codigo_fabricante = f.codigo_fabricante) as precio_producto_barato
FROM fabricante f;

-- 32 Computa el precio medio de todos los productos cuyo fabricante sea 'Creative Labs'.
SELECT AVG(precio) as precio_medio FROM producto
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Creative Labs');

-- 33 Selecciona el nombre de cada fabricante cuya media de productos sea superior a 140€ y al menos contenga 2 o más productos diferentes.
SELECT f.nombre FROM fabricante f
INNER JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.nombre
HAVING AVG(p.precio) > 140 AND COUNT(DISTINCT p.nombre) >= 2;

-- 34 Por campaña de ABRIL, actualiza los precios aplicando un descuento del 10%. Además, los precios que superen los 200 € se les añadirá un 5% adicional.
UPDATE producto SET precio = precio * 0.9 + (CASE WHEN precio > 200 THEN precio * 0.05 ELSE 0 END) WHERE MONTHNAME(NOW()) = 'April';








haz una base de datos en el lenguaje sql en el que se creen las tablas cliente, ordenes, pedido y articulo.
