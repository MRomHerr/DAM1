-- 1. Nombre de las editoriales americanas 
SELECT pub_name as "NOMBRE DE LAS EDITORIALES AMERICANAS"
FROM PUBLICACION
WHERE country = 'USA';

-- 2. Mostrar los libros con más de 200 páginas (nombre de libro y el número de páginas) ordenado por números de páginas. 
SELECT book_name AS "NOMBRE DEL LIBRO", No_page AS "Nº PÁGINAS"
FROM LIBRO
WHERE No_page > 200
ORDER BY No_page;

-- 3. Cantidad de Libros escritos en inglés y cantidad de libros escritos en Hindi, sin utilizar la cláusula WHERE. 
SELECT 
    (SELECT COUNT(*) FROM LIBRO WHERE pub_lang = 'English') AS "LIBROS EN INGLÉS",
    (SELECT COUNT(*) FROM LIBRO WHERE pub_lang = 'Hindi') AS "LIBROS EN HINDI";

-- 4. Editoriales localizadas en New York, ordenadas de menor a mayor por su número de "branch". No se puede utilizar el operador =. 
SELECT pub_name AS "NOMBRE DE LA EDITORIAL"
FROM PUBLICACION 
WHERE pub_city LIKE '%New York%'
ORDER BY  no_of_branch ASC;

-- 5.  Autores Americanos que viven en Houston o Florida (nombre del autor, país y ciudad). No se puede usar el operador "=", ni los nombres "Houston” ni "Florida".
SELECT aut_name AS "NOMBRE DEL AUTOR", country AS "PAIS DEL AUTOR", home_city AS "CIUDAD DEL AUTOR"
FROM AUTOR
WHERE country LIKE '%USA' AND home_city NOT IN ('New York','Atlanta');

-- 6. Autores no americanos cuyo idioma de habla de su país es el inglés (nombre del autor, país y ciudad). Ordénalos por país y por nombre alfabético.
SELECT aut_name AS "NOMBRE DEL AUTOR", country AS "PAIS DEL AUTOR", home_city AS "CIUDAD DEL AUTOR"
FROM AUTOR
WHERE country IN('UK','Australia','Canada')
ORDER BY country, aut_name ASC;

-- 7. Contar el número de autores ordenados por país, ordenados de forma alfabética. 
SELECT country AS "PAIS DEL AUTOR", COUNT(*) AS "NUMERO DE AUTORES"
FROM AUTOR
GROUP BY country
ORDER BY country ASC;
-- B) Ordénalo también por el número de autores de forma descendente. 
SELECT country AS "País", COUNT(*) AS "Número de Autores"
FROM AUTOR
GROUP BY country
ORDER BY COUNT(*) DESC;

-- 8. Contar el número de autores cuyo país hablan el INGLÉS como idioma oficial. 
SELECT COUNT(*) AS "NUMERO DE AUTORES"
FROM AUTOR
WHERE country IN ('USA', 'CANADA', 'AUSTRALIA', 'UK');
-- B) Muestra el número de autores por cada país que habla INGLÉS de forma descendente. 
SELECT country, COUNT(*) AS "NUMERO DE AUTORES"
FROM AUTOR
WHERE country IN ('USA', 'CANADA', 'AUSTRALIA', 'UK')
GROUP BY country
ORDER BY "NUMERO DE AUTORES" DESC;

-- 9. Contar el número de autores cuyo país no hablan el INGLÉS como idioma oficial. B) Muestra los países y ordénalos por países de forma ascendente. 
SELECT COUNT(*) AS "NUMERO DE AUTORES", country AS "PAIS"
FROM AUTOR
WHERE country NOT IN ('USA', 'UK', 'Canada', 'Australia')
GROUP BY country
ORDER BY country ASC;

-- 10. Número de publicaciones en los países de USA y UK., por ciudad. Para ello se requiere agrupar por País y ciudad. 
SELECT country, pub_city, COUNT(*) AS "NUMERO DE PUBLICACIONES"
FROM PUBLICACION 
JOIN LIBRO ON PUBLICACION.pub_id = LIBRO.pub_id
WHERE country IN ('USA', 'UK')
GROUP BY country, pub_city
ORDER BY country, pub_city ASC;

-- 11. Contar el número de publicaciones por idioma único y el promedio de páginas por libro con máximo dos decimales, por cada categoría de libros (cate_id). 
SELECT cate_id,pub_lang,COUNT(*) AS "NUMERO DE PUBLICACIONES",ROUND(AVG(no_page), 2) AS "PROMEDIO DE PAGINAS"
FROM LIBRO
GROUP BY cate_id, pub_lang;

-- 12. Media de precios de los libros, con formato € en la misma columna. Redondéalo a dos dígitos decimales. 
SELECT CONCAT('€', ROUND(AVG(book_price), 2)) AS "MEDIA DEL PRECIO"
FROM LIBRO;

-- 13. Números de libros escritos en cada idioma, de mayor a menor número. (te tiene que dar 16 libros) 
-- a) Realízalo primero con dos sentencias SELECT. 
SELECT pub_lang AS IDIOMA, COUNT(*) AS "NUMERO DE LIBROS"
FROM LIBRO
GROUP BY pub_lang

SELECT idioma, num_libros
FROM (
  SELECT pub_lang AS IDIOMA, COUNT(*) AS "NUMERO DE LIBROS"
 FROM LIBRO
  GROUP BY pub_lang
) AS subconsulta
ORDER BY num_libros DESC;


-- b) Realízalo con una sola sentencia SELECT. 
SELECT idioma, num_libros
FROM (
  SELECT pub_lang AS IDIOMA, COUNT(*) AS "NUMERO DE LIBROS"
 FROM LIBRO
  GROUP BY pub_lang
) AS subconsulta
ORDER BY num_libros DESC;

-- 14. Obtener el número de editoriales que tiene cada ciudad. 
SELECT pub_city AS CIUDAD, COUNT(DISTINCT pub_name) AS "NUMERO DE EDITORIALES"
FROM PUBLICACION
GROUP BY pub_city;

-- 15. Obtener el número de editoriales de cada ciudad de Estados Unidos.
SELECT pub_city AS CIUDAD, COUNT(DISTINCT pub_name) AS "NUMERO DE EDITORIALES"
FROM PUBLICACION
WHERE country = 'USA'
GROUP BY pub_city;

-- 16. Libros publicados en los años 2002 y 2003. Mostrar nombre del libro, categoría y año, ordenado por categoría de forma ascendente y fecha de publicación de forma descendente. La fecha de publicación se mostrará en formato Europeo. 
SELECT l.book_name AS "NOMBRE DEL LIBRO", c.nombre AS CATEGORIA, DATE_FORMAT(l.dt_of_pub, '%d-%m-%Y') AS "FECHA DE PUBLICACION"
FROM LIBRO l
JOIN CATEGORIA c ON l.cate_id = c.cate_id
WHERE YEAR(l.dt_of_pub) IN (2002, 2003)
ORDER BY c.nombre ASC, l.dt_of_pub DESC;

-- 17. Contar el número de libros publicados por cada categoría ordenados por categoría. 
SELECT cate_id AS CATEGORIA, COUNT(*) AS "NUMERO DE LIBROS"
FROM LIBRO
GROUP BY cate_id
ORDER BY categoria ASC;

-- 18. Muestras las categorías y sus números de publicaciones que hayan tenido dos o más libros publicados 
SELECT cate_id AS CATEGORIA, COUNT(*) AS n"NUMERO DE LIBROS"
FROM LIBRO
GROUP BY cate_id
HAVING COUNT(*) >= 2
ORDER BY categoria ASC;

-- 19. Contar el número de libros publicados entre los años 2001 y 2003, según cada categoría. 
SELECT cate_id AS CATEGORIA, COUNT(*) AS "NUMERO DE LIBROS"
FROM LIBRO
WHERE YEAR(dt_of_pub) BETWEEN 2001 AND 2003
GROUP BY cate_id
ORDER BY cate_id ASC;

-- 20. Nombre y precio del libro más barato, junto a su autor, y que aparezca el  símbolo Euro dentro de la columna precio. 
SELECT LIBRO.book_name AS "NOMBRE DEL LIBRO", CONCAT(MIN(LIBRO.book_price), ' €') AS "PRECIO DEL LIBRO", AUTOR.aut_name AS "NOMBRE DEL AUTOR"
FROM LIBRO 
JOIN AUTOR ON LIBRO.aut_id = AUTOR.aut_id
WHERE LIBRO.book_price = (SELECT MIN(book_price) FROM LIBRO)
GROUP BY LIBRO.book_name, AUTOR.aut_name;

-- 21. Nombre y precio del libro más caro en dólares. Cambio actual a 1,19$ por  Euro. 
SELECT LIBRO.book_name AS "NOMBRE DEL LIBRO", CONCAT(MAX(LIBRO.book_price * 1.19), ' $') AS "PRECIO DEL LIBRO EN DÓLARES", AUTOR.aut_name AS "NOMBRE DEL AUTOR"
FROM LIBRO 
JOIN AUTOR  ON LIBRO.aut_id = AUTOR.aut_id
WHERE LIBRO.book_price = (SELECT MAX(book_price) FROM LIBRO)
GROUP BY LIBRO.book_name, AUTOR.aut_name;

-- 22. Número de libros publicados por cada editorial. Mostrar el nombre de la  editorial y el número de libros publicados. 
SELECT PUBLICACION.pub_name AS "NOMBRE DE LA EDITORIAL", COUNT(LIBRO.book_id) AS "NÚMERO DE LIBROS PUBLICADOS"
FROM LIBRO 
JOIN PUBLICACION ON LIBRO.pub_id = PUBLICACION.pub_id
GROUP BY PUBLICACION.pub_name;

-- 23. Número total de Publicaciones de cada editorial americana. 
SELECT pub_name AS "NOMBRE DE LA EDITORIAL", COUNT(*) AS "NUMERO DE PUBLICACIONES"
FROM PUBLICACION WHERE country = 'USA'
GROUP BY pub_name;

-- 24. Número total de Publicaciones de las editoriales americanas, utilizando dos  tablas en la consulta. Aparecerá el número total y el país (resultado la suma  del apartado anterior). Realízalo de 2 formas diferentes CON/SIN GROUP  BY+HAVING. 
-- CON
SELECT country, COUNT(*) AS "NUMERO DE PUBLICACIONES"
FROM PUBLICACION 
JOIN LIBRO  ON PUBLICACION.pub_id = LIBRO.pub_id
WHERE country = 'USA'
GROUP BY country
HAVING COUNT(*) > 0;
-- SIN
SELECT country, COUNT(*) AS "NUMERO DE PUBLICACIONES"
FROM PUBLICACION 
JOIN LIBRO  ON PUBLICACION.pub_id = LIBRO.pub_id
WHERE country = 'USA';

-- 25. Mostrar el libro más caro de cada categoría: Nombre del libro, categoría,  precio y año de publicación (solo el año). 
SELECT book_name AS "Nombre del Libro", cate_id AS "Categoría", book_price AS "Precio", YEAR(dt_of_pub) AS "Año de Publicación"
FROM LIBRO
WHERE (cate_id, book_price) IN (SELECT cate_id, MAX(book_price)FROM LIBRO
GROUP BY cate_id);

-- 26. Del apartado anterior, muestra el nombre de la categoría en lugar del  identificador de la categoría, ordenado por categoría de forma ascendente.
SELECT LIBRO.book_name AS "Nombre del Libro", nombre AS "Categoría", LIBRO.book_price AS "Precio", YEAR(LIBRO.dt_of_pub) AS "Año de Publicación"
FROM LIBRO 
JOIN CATEGORIA ON LIBRO.cate_id = CATEGORIA.cate_id
WHERE (LIBRO.cate_id, LIBRO.book_price) IN (SELECT cate_id, MAX(book_price) FROM LIBRO GROUP BY cate_id)
ORDER BY nombre ASC;

-- 27. Obtén los libros más baratos de las categorías de Física y termodinámica.  Muestra el nombre de la categoría, nombre del libro y su precio.
SELECT CATEGORIA.nombre AS "Categoría", LIBRO.book_name AS "Nombre del Libro", LIBRO.book_price AS "Precio"
FROM LIBRO 
JOIN CATEGORIA ON LIBRO.cate_id = CATEGORIA.cate_id
WHERE CATEGORIA.nombre IN ('Física', 'Termodinámica')
AND LIBRO.book_price = (SELECT MIN(book_price) FROM LIBRO WHERE cate_id = LIBRO.cate_id)
ORDER BY CATEGORIA.nombre ASC;

-- 28. Obtén las publicaciones que se hayan hecho de Física. Muestra el nombre  de la publicación, el libro y su autor. 
SELECT PUBLICACION.pub_name AS "Nombre de la Publicación", LIBRO.book_name AS "Nombre del Libro", AUTOR.aut_name AS "Nombre del Autor"
FROM PUBLICACION 
JOIN LIBRO ON PUBLICACION.pub_id = LIBRO.pub_id
JOIN AUTOR ON LIBRO.aut_id = AUTOR.aut_id
JOIN CATEGORIA ON LIBRO.cate_id = CATEGORIA.cate_id
WHERE CATEGORIA.nombre = 'Física';

-- 29. Seleccionar los libros escritos por autores australianos, mostrando el autor,  su libro, el nombre de la categoría del libro y la editorial que lo ha publicado. 
SELECT AUTOR.aut_name AS "Autor",book_name AS "Libro", CATEGORIA.nombre AS "Categoría", PUBLICACION.pub_name AS "Editorial"
FROM LIBRO 
JOIN AUTOR ON LIBRO.aut_id = AUTOR.aut_id
JOIN CATEGORIA ON LIBRO.cate_id = CATEGORIA.cate_id
JOIN PUBLICACION ON LIBRO.pub_id = PUBLICACION.pub_id
WHERE LIBRO.aut_id IN (SELECT aut_id FROM AUTOR WHERE country = 'Australia');

-- 30. Obtén las publicaciones de los autores cuyo nombre sea William. Muestra el nombre de los autores, sus libros, el nombre de su categoría, la editorial y su  precio con el símbolo del €, ordenándolos por esta última de forma  descendente. 
SELECT AUTOR.aut_name AS "Autor", book_name AS "Libro", CATEGORIA.nombre AS "Categoría", PUBLICACION.pub_name AS "Editorial", CONCAT(LIBRO.book_price, ' €') AS "Precio"
FROM LIBRO 
JOIN AUTOR ON LIBRO.aut_id = AUTOR.aut_id
JOIN CATEGORIA ON LIBRO.cate_id = CATEGORIA.cate_id
JOIN PUBLICACION ON LIBRO.pub_id = PUBLICACION.pub_id
WHERE AUTOR.aut_name = 'William'
ORDER BY LIBRO.book_price DESC;

-- 31. Muestra los libros, autores, nombre de la CATEGORIA y precio, de los libros  cuyo precio se encuentre entre 100 y 200€. 
SELECT L.book_name AS "Libro", A.aut_name AS "Autor", C.nombre AS "Categoría", CONCAT(L.book_price, ' €') AS "Precio"
FROM LIBRO L
JOIN AUTOR A ON L.aut_id = A.aut_id
JOIN CATEGORIA C ON L.cate_id = C.cate_id
WHERE L.book_price BETWEEN 100 AND 200;
