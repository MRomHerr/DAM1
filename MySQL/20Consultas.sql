create database if not exists jer6_3;
use jer6_3;
CREATE TABLE DEPT (
    DEPTNO INT PRIMARY KEY,
    DNAME VARCHAR(14),
    LOC VARCHAR(13)
);

CREATE TABLE EMP (
    EMPNO INT PRIMARY KEY,
    ENAME VARCHAR(10),
    JOB VARCHAR(9),
    MGR INT,
    HIREDATE DATE,
    SAL DEC(7,2),
    COMM DEC(7,2),
    DEPTNO INT
);

ALTER TABLE EMP ADD CONSTRAINT fk_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO);

INSERT INTO DEPT VALUES
    (10,'ACCOUNTING','NEW YORK'),
    (20,'RESEARCH','DALLAS'),
    (30,'SALES','CHICAGO'),
    (40,'OPERATIONS','BOSTON');

INSERT INTO EMP VALUES
    (7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20),
    (7499,'ALLEN','SALESMAN',7698,'1981-2-20',1600,300,30),
    (7521,'WARD','SALESMAN',7698,'1981-2-22',1250,500,30),
    (7566,'JONES','MANAGER',7839,'1981-4-2',2975,NULL,20),
    (7654,'MARTIN','SALESMAN',7698,'1981-9-28',1250,1400,30),
    (7698,'BLAKE','MANAGER',7839,'1981-5-1',2850,NULL,30),
    (7782,'CLARK','MANAGER',7839,'1981-6-9',2450,NULL,10),
    (7788,'SCOTT','ANALYST',7566,'1987-7-13',3000,NULL,20),
    (7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10),
    (7844,'TURNER','SALESMAN',7698,'1981-9-8',1500,0,30),   
    (7876,'ADAMS','CLERK',7788,'1987-7-13',1100,NULL,20),
    (7900,'JAMES','CLERK',7698,'1981-12-3',950,NULL,30),
    (7902,'FORD','ANALYST',7566,'1981-12-3',3000,NULL,20),
    (7934,'MILLER','CLERK',7782,'1982-1-23',1300,NULL,10);

CREATE TABLE BONUS (
    ENAME VARCHAR(10),
    JOB VARCHAR(9),
    SAL DEC(7,2),
    COMM DEC(7,2)
);

CREATE TABLE SALGRADE (
    GRADE INT,
    LOSAL INT,
    HISAL INT
);

INSERT INTO SALGRADE VALUES (1,700,1200),
    (2,1201,1400),
    (3,1401,2000),
    (4,2001,3000),
    (5,3001,9999);




-- 1. Mostrar el número de empleados que tiene la empresa y el número de empleados que cobran comisión

 select count(*), count(comm) from emp;





-- 2. Contar el número de empleados que hay en el departamento 20

select count(*) from emp where deptno = 20;



-- 3. Contar el número de empleados que tiene la empresa en 1981

select count(*) from emp where hiredate like' %1981%';

select count(*) from emp where hiredate between  '1981/01/01' and '1981/12/31';

select count(*) from emp where extract(year from hiredate) = 1981;



-- 4. Los salarios máximos y mínimos de aquellos empleados que tengan el oficio (job) CLERK

select max(sal), min(sal) from emp where job like 'CLERK';



-- 5. Salario medio de los empleados que su nombre empiece por J.

select avg(sal) from emp where ename like 'J%';  




-- 7. Mostrar la suma del salario cuyo salario sea superior a 1800

select sum(sal) from emp where sal > 1800;




-- 8. Mostrar el numero de oficios hay en el departamento 10

select count(distinct job) from emp where deptno = 10;




-- 9. Mostrar para los empleados del dpto 20 el mensaje ‘Ename gana SAL Euros’. El campo ENAME esta la primera en mayúscula y las siguientes en minúscula.



select concat(upper(left(ename,1)), lower(substring(ename,2)), ' gana ', sal, ' euros ') from emp where deptno = 20; 



select concat(' gana ', upper(left(ename,1)), lower(substring(ename,2)), sal, ' euros ') from emp where deptno = 20;





select concat(upper(substring(ename,1,1)), lower(substring(ename,2)), ' gana ', sal, ' euros ') from emp where deptno = 20; 




-- 10. Mostrar todos los empleados cuyo nombre tiene cinco o más caracteres.

select * from emp where length(ename) >4;



-- -------------------------------------------------------------------------------------------------------------------------------------


-- 11. Mostrar la media del salario de los empleados cuyo oficio tenga 7 caracteres

select avg(sal) from emp where length(job) =7;  



-- 12. Mostrar el nombre añadiendo un * por la derecha y dicho nombre añadiendo un asterisco
-- por la izquierda a todos los empleados del dpto 10. En ambos casos se debe alcanzar una
-- longitud de 10 caracteres.

select 
	LPAD(ename, 10, '*') AS 'asterisco izquierda',
	RPAD(ename, 10, '*') AS 'asterisco derecha' 
	FROM emp WHERE deptno = 10;



-- 13.Eliminar los caracteres asterisco a las cadenas '*****PEPITO', 'MANOLITA*****' y a la cadena de caracteres '*******LOLO*****' (FROM DUAL)

SELECT 
    REPLACE('*****PEPITO', '*', ''),
    REPLACE('MANOLITA*****', '*', ''),
    REPLACE('*******LOLO*****', '*', '')
FROM DUAL; -- En Oracle, DUAL es una tabla especial de sistema que contiene exactamente una fila y una sola columna llamada DUMMY. 
-- Se utiliza principalmente en situaciones donde la sintaxis de SQL requiere una cláusula FROM, pero no necesariamente se necesita acceder a una tabla real.
SELECT 
    TRIM(leading '*' from '*****PEPITO'),
    TRIM(trailing '*' from 'MANOLITA*****') ,
    TRIM(both '*' from '*******LOLO*****') 
FROM DUAL; 



--  14. Mostrar la fecha correspondiente a cinco meses después de la fecha del sistema. (FROM DUAL)

select DATE_ADD(SYSDATE(),INTERVAL 5 MONTH) FROM DUAL;


-- 15. Mostrar el último día de este mes. (FROM DUAL)

select last_day(sysdate()) as 'último día del mes' from dual;

-- SELECT SYSDATE FROM DUAL;
-- Esta consulta devolverá la fecha y hora actuales del sistema en el formato apropiado para la configuración de fecha y hora de la 
-- base de datos en la que se está ejecutando.
-- last_day ultimo dia del mes
-- para fechas utilizar el sysdate o el dateadd
-- muestra la diferencia de dias ente fechas SELECT TIMESTAMPDIFF(day, '2022-01-01', '2022-01-31') AS DateDiff;
-- SYDATE() , CURDATE() Y NOW() hacen lo mismo NOW TE DA MAS INFORMACION

-- 16. Mostrar cuantos meses llevan trabajando los empleados cuyo oficio es MANAGER. Redondear el resultado a dos decimales.

SELECT ENAME, ROUND(TIMESTAMPDIFF(month, HIREDATE,SYSDATE()),2) AS 'meses trabajados'
FROM EMP
WHERE JOB = 'MANAGER';




-- 17.  Mostrar cuantos meses, años y trienios cumplidos llevan trabajando los empleados cuyo oficio es MANAGER. Redondear el resultado a dos decimales.

SELECT ENAME,
ROUND(TIMESTAMPDIFF(month, HIREDATE,SYSDATE()),2) AS 'meses trabajados',
ROUND(TIMESTAMPDIFF(year, HIREDATE,SYSDATE()),2) AS 'años trabajados',
ROUND(TIMESTAMPDIFF(year, HIREDATE,SYSDATE())/3,2) AS 'trienios trabajados'
from EMP
WHERE JOB = 'MANAGER';


 -- 19. Mostrar para todos los empleados que sean CLERK la fecha de ingreso, diez días mas y diez días menos
SELECT ENAME, HIREDATE, 
DATE_ADD(HIREDATE, INTERVAL 10 DAY) AS 'Diez días después', 
DATE_SUB(HIREDATE, INTERVAL 10 DAY) AS 'Diez días antes'
from EMP
WHERE JOB = 'CLERK';

SELECT ENAME, HIREDATE, 
HIREDATE + 10 'Diez días después', 
HIREDATE - 10  'Diez días antes'
from EMP
WHERE JOB = 'CLERK';


-- 20. Mostrar un listado con el nombre, salario y comisión de los empleados del dpto 30. si no tiene comisión, poner 0

select ENAME, SAL, COALESCE(COMM, 0) -- CUANDO ES NULO ME LO REEMPLAZA POR 0
from EMP where DEPTNO=30;



-- 21. Mostrar un listado con el nombre, salario, comisión y el total de lo que va a cobrar de los
-- empleados del dpto 30. si no tiene comisión, poner ‘---’

select ENAME as NOMBRE, SAL as SALARIO, 
COALESCE(COMM, '---') as COMISION, 
(SELECT SUM(SAL) FROM EMP WHERE DEPTNO=30)  as 'SALARIO TOTAL DEL DEPARTAMENTO 30'
from EMP where DEPTNO=30;



select ENAME as NOMBRE, SAL as SALARIO, 
COALESCE(COMM, '---') as COMISION, 
COALESCE(SAL + COMM, SAL) as COMISION,  as 'SALARIO TOTAL DEL DEPARTAMENTO 30'
from EMP where DEPTNO=30;

-- 22.Para todos los empleados cuyo nombre tiene una A, mostrar un listado con el nombre,
-- comisión y la cadena 'TIENE' en el caso de que tenga comisión y 'NO TIENE' en caso
-- contrario.

select ENAME as NOMBRE, COMM as COMISION, 
CASE 
     WHEN COMM IS NOT NULL THEN 'TIENE'
     ELSE 'NO TIENE'
 END AS CADENA
from EMP where ENAME like '%A%';


SELECT ENAME AS NOMBRE, 
       COMM AS COMISION, 
       IFNULL(COMM, 'NO TIENE') AS TIENE_COMISION
FROM EMP 
WHERE ENAME LIKE '%A%';



-- 23. Mostrar el nombre la fecha y la fecha en formato 'DD-MM-YYYY' de todos empleados que
-- sean CLERK
select ENAME as NOMBRE, DATE_FORMAT(HIREDATE,'%d/%m/%Y') as 'FECHA DE CONTRATACION'
from EMP WHERE JOB = 'CLERK';
-- %D me muestra los dias como 1rd,3rd 17th
-- %M me muestra los meses por su nombre en vez del numero
-- %y me muetsra los años por las dos ultimas cifras




 -- 24. Mostrar el nombre y la fecha de entrada de los empleados que han entrado en la empresa en
-- el mes de Febrero.

select ENAME as NOMBRE, HIREDATE as 'FECHA DE CONTRATACION'
from EMP WHERE month(HIREDATE) = 2;



 -- 25. Igual que en el caso anterior, pero solo se puede comparar con la cadena de texto 'FEB'

select ENAME as NOMBRE, HIREDATE as 'FECHA DE CONTRATACION'
from EMP WHERE DATE_FORMAT(HIREDATE,'%b') = 'FEB';


select ename,
hiredate,
monthname(hiredate)
from emp
where UPPER(monthname(hiredate)) like 'FEB%'
 
 -- %b NOMBRE DEL MES EN FORMATO ABREVIADO
 
 
 
-- 26. ¿Cuantos empleados entraron a trabajar un Viernes?.

select ename as nombre, (select COUNT(*)
from EMP WHERE DAYOFWEEK(HIREDATE) = 6)as 'NUMERO DE EMPLEADOS QUE ENTRARON UN VIERNES'
from EMP WHERE DAYOFWEEK(HIREDATE) = 6;


select count(*) as numEm
from emp
where dayname(hiredate) = 'FRIDAY'
-- EMPIEZA A CONTAR LA SEMANA DESDE EL DOMINGO
   

-- 27. Hacer un listado de los nombres de empleado que tienen un letra A, una letra C o bien tiene
-- las dos letras. El resultado son dos columnas una con el resultado en cuestión y otra con una explicación: 'TIENE UNA A', 'TIENE UNA C', 'TIENE AMBAS LETRAS'


select 
ename,
case 
	when ename like '%A%C%' or ename like '%C%A%' then 'TIENE AMBAS'
	when ename like '%A%' then 'TIENE UNA A'
	when ename like '%C%' then 'TIENE UNA C'
	
	else 'NINGUNA'
end as letras
from emp







-- 28. Mostrar un listado con el nombre, fecha de entrada y la cadena 'PRIMER TRAMO', si
-- entraron a trabajar desde Enero a Junio, 'SEGUNDO TRAMO' si entraron a trabajar desde
-- Julio a Octubre 'TERCER TRAMO' y en caso contrario.


select 
ename,
hiredate,
case 
	when month(hiredate) between 1 and 6 then 'PRIMER TRAMO'
	when month(hiredate) between 7 and 10 then 'SEGUNDO TRAMO'
	else 'TERCER TRAMO'
	
end as tramos
from emp
end







-- 29. Mostrar la suma del salario de los empleados cuyo salario es superior a 1.800.


select sum(sal) from emp where sal > 1800






-- 30. ¿Cuantos oficios diferentes hay en el dpto 10?.

select count(distinct job) from emp where deptno=10

-- 31. Mostrar la media del salario de los empleados cuyo oficio tenga 7 caracteres.

select avg(sal) as medio from emp where length(job) = 7




-- en el group by los null cuentan como otro grupo, si hago una suma por comision y hay varios que tienen null, la comisionn de los null se sumara.
-- lo que se ponga en el select tambien hay que ponerlo en el group by3



select comm, sum(sal) from emp group by COMM 




select deptno, min(ename) primero, max(ename) ultimo
from emp
group by deptno



SELECT COUNT(DISTINCT job) FROM EMP;


SELECT deptno, COUNT(DISTINCT job) FROM EMP GROUP BY deptno;



-- Igual que para el resto de consultas vistas previamente, en una consulta de agrupación o
-- resumen también se pueden realizar filtrado de filas con WHERE


SELECT job, COUNT(*) CANTIDAD, MIN(sal) as 'Minimo Salario'
, MAX(sal) as
'Maximo Salario' FROM emp WHERE hiredate BETWEEN '1981-01-01' AND '1981-
12-31' GROUP BY job;


-- La cláusula HAVING se emplea para controlar cuál de los conjuntos de filas se visualiza con lo
-- cual es necesario realizar primero el agrupamiento mediante GROUP BY.
-- La cláusula HAVING se usa con funciones de grupo, no con campos de agrupación.
-- Ejemplo: ¿Qué departamento tiene más de tres empleados? 

SELECT deptno, COUNT(*) FROM emp GROUP BY deptno HAVING COUNT(*)>3;

select deptno as departamento, sum(sal) as 'salario total' from emp 
where hiredate BETWEEN '1981-01-01' AND '1981-12-31'
group by deptno having avg(sal)>1000


-- Es importante entender que la clausula HAVING se usa con funciones de grupo, no con campos
-- de agrupación.
-- Si se desea aplicar una condición a un campo de agrupamiento se usa para ello la clausula WHERE.
-- Ejemplo: Obtener el salario máximo de los departamentos número 10 y 30.

SELECT deptno, MAX(sal) MAXSAL FROM emp WHERE deptno IN (10,30) GROUP BY
deptno;
OJO, si hacemos: SELECT deptno, MAX(sal) MAXSAL FROM emp GROUP BY deptno
IN (10,30); DA ERROR

-- with rollup, se pone al final y antes de order by y no se suel usar, da informacion añadida como la suma de todos lo salarios
select deptno, job, sum(sal) a suma
from emp e group by deptno, job with rollup order by deptno asc



-- 1.	Muestra los números de departamento, número de empleados, máximo salario, mínimo salario y salario medio de cada uno de los departamentos. 

SELECT deptno as DEPARTAMENTO, COUNT(ENAME) as 'NÚMERO DE EMPLEADOS', MAX(sal) 'SALARIO MÁXIMO', MIN(sal) as 'SALARIO MÍNIMO', AVG(SAL) as 'SALARIO MEDIO' 
FROM emp 
GROUP by deptno;


-- 2.	Muestra los diversos trabajos y el número total de empleados con cada grupo de trabajo que ganen más de 1500.
SELECT JOB as TRABAJOS, COUNT(ENAME) as 'NÚMERO DE EMPLEADOS'
from emp 
where SAL>1500
GROUP by JOB;

-- 3.	Muestra los números de departamento y el salario total de los departamentos que tengan más de cuatro empleados.

select DEPTNO, SUM(SAL) as 'SALARIO TOTAL' 
from emp 
group by DEPTNO
having COUNT(ENAME)>4;


-- 4.	Crear un informe en el que se muestre el número de ‘CLERK’ y ‘SALESMAN’ se han contratado por cada mes del año. El informe debe estar ordenado por el mes del año. 

SELECT JOB as TRABAJOS,COUNT(JOB) as 'NUMERO DE CLERK Y SALESMAN', EXTRACT(MONTH FROM hiredate) as 'MES DE CONTRATO'
FROM emp 
WHERE JOB IN ('CLERK','SALESMAN')
GROUP BY JOB, EXTRACT(MONTH FROM hiredate)
ORDER BY EXTRACT(MONTH FROM hiredate);

-- 5.	Análogamente al anterior, mostrar para cada mes de treinta días cuantos empleados de cada oficio se han contratado.

SELECT JOB as TRABAJOS,COUNT(JOB) as 'NUMERO DE GENTE CONTARATDA',EXTRACT(MONTH FROM hiredate) as 'MES DE CONTRATO'
FROM emp 
WHERE EXTRACT(MONTH FROM hiredate) IN (4,6,9,11)   -- ES LO MISMO DAY(LAST_DAY(HIREDATE))=30
GROUP BY JOB, EXTRACT(MONTH FROM hiredate)
ORDER BY EXTRACT(MONTH FROM hiredate);

-- 6.	Mostrar un informe que muestre para cada número de letras del nombre de empleado, cuantos empleados hay y su salario medio redondeado a dos decimales.

select LENGTH(ENAME) as 'LONGITUD DEL NOMBRE', COUNT(ENAME) as 'numero de empleadosL', ROUND(AVG(SAL),2) as 'SALARIO MEDIO'
from emp 
group by LENGTH(ENAME);

-- 7.	Visualizar los números de departamento con más de tres empleados en cada departamento cuyo gasto salarial total del departamento sea mayor que 10,000.

select DEPTNO as DEPARTAMENTO, SUM(SAL) as 'GASTO TOTAL'
from emp 
group by DEPTNO
having COUNT(ENAME)>3 and sum(sal)>10000;

-- 8.	Mostrar para cada uno de los empleados que tiene subordinados a su cargo que número de subordinados y la suma total de sus salarios. El listado debe mostrar las cantidades formateadas y debe estar ordenado por número de subordinados descendentemente.

select MGR as JEFES, COUNT(ENAME) as 'NUMERO DE SUBORDINADOS', SUM(SAL) as 'GASTO TOTAL'
from emp 
where mgr is not null
group by MGR
order by COUNT(ENAME) DESC;


-- 9.	Mostrar cuantos empleados de cada departamento tienen superior.

select deptno as departamento, COUNT(*) as numero
from emp 
where mgr is not null
group by deptno;

-- 10.	Mostrar cuantos empleados de cada oficio han entrado en cada año. Mostrar el año con cuatro cifras y el listado ordenado por año y por oficio.

SELECT JOB as OFICIO, COUNT(ENAME) as 'NUMERO DE EMPLEADOS', EXTRACT(YEAR from HIREDATE) as 'AÑO'
from EMP 
group by JOB, AÑO
order by AÑO, JOB;


SELECT JOB as OFICIO, COUNT(ENAME) as 'NUMERO DE EMPLEADOS', SUBSTRING(EXTRACT(YEAR from HIREDATE), 3, 2) as 'AÑO'
FROM EMP 
GROUP BY JOB, AÑO
ORDER BY AÑO, JOB;

SUBSTRING(EXTRACT(YEAR from HIREDATE)  HACE QUE EL AÑO SOLO SE MUESTRE EN 2 CIFRAS, EL 3 INDICA DONDE EMPIEZA EN EL CASO DE 2024 EMPIEZA EN EL SEGUNDO 2, EL 2 INDICA CUANTAS COFRAS DEBE MOSTAR




-- 1.	Mostrar el nombre y salario de todos los empleados que trabajan en Chicago.
select e.ename nombre, e.sal salario
from emp e join dept d using(deptno)
where d.loc='Chicago';

select e.ename nombre, e.sal salario
from emp e join dept d on(e.deptno=d.deptno)
where d.loc='Chicago';

select e.ename nombre, e.sal salario
from emp e natural join dept d
where d.loc='Chicago';


-- 2.	Mostrar el nombre, el oficio y el nombre de departamento en que trabajan de todos los empleados que ganan en un salario entre 1500 y 2000.
select e.ename nombre, e.job oficio, e.deptno departamento
from emp e
where e.sal between 1500 and 2000;

select e.ename nombre, e.job oficio, d.dname departamento
from emp e join dept d on (e.deptno=d.deptno)
where e.sal between 1500 and 2000;


-- 3.	Mostrar las parejas de empleados cuyo primer componente es un MANAGER y cuya suma de salarios esta entre 3750 y 4000.

SELECT e1.ENAME as empleado1, e1.job, e2.ENAME AS empleado2, e2.job, (e1.SAL + e2.SAL) as 'salario total'
FROM EMP e1 cross join EMP e2 
WHERE e1.JOB = 'MANAGER' AND (e1.SAL + e2.SAL) BETWEEN 3750 AND 4000;

SELECT e1.ENAME as empleado1, e1.job, e2.ENAME AS empleado2, e2.job, (e1.SAL + e2.SAL) as 'salario total'
FROM EMP e1 join EMP e2 on (e1.empno<>e2.empno) -- <> signfica distinto
WHERE e1.JOB = 'MANAGER' AND (e1.SAL + e2.SAL) BETWEEN 3750 AND 4000;

-- 4.	Mostrar un resumen de salarios medios de las combinaciones de MANAGER-EMPLEADO (distinto a MANAGER).

SELECT e1.ENAME as empleado1, e2.ENAME AS empleado2, (e1.SAL + e2.SAL) as 'salario total'
FROM EMP e1
JOIN EMP e2 ON e1.MGR = e2.EMPNO
WHERE e1.JOB = 'MANAGER' AND (e1.SAL + e2.SAL) BETWEEN 3750 AND 4000;

-- 5.	Mostrar un informe que muestre el nombre de empleado, el salario y la categoría salarial indicada con tantos asteriscos como grado salarial de todos los empleados que son SALESMAN

SELECT e.ENAME AS nombre, e.SAL AS salario, REPEAT('*', sg.GRADE) AS 'categporia salarial'
FROM EMP e JOIN SALGRADE sg ON (e.SAL BETWEEN sg.LOSAL AND sg.HISAL)
WHERE e.JOB = 'SALESMAN'; -- si la cadena de texto esta vacia no lo hace asiqu e mejor hacerlo co rpad

SELECT e.ENAME AS nombre, e.SAL AS salario, rpad('', sg.grade, '*')
FROM EMP e JOIN SALGRADE sg ON (e.SAL BETWEEN sg.LOSAL AND sg.HISAL)
WHERE e.JOB = 'SALESMAN';

-- 6.	Indicar el nombre y el salario de los empleados que trabajan en DALLAS y que tienen una categoría salarial cuatro.

SELECT e.ENAME AS nombre, e.SAL AS salario, REPEAT('*', sg.GRADE) AS 'categoria salarial'
FROM EMP e JOIN DEPT d ON (e.DEPTNO = d.DEPTNO)
JOIN SALGRADE sg ON (e.SAL BETWEEN sg.LOSAL AND sg.HISAL)
WHERE d.loc = 'DALLAS' and sg.GRADE=4;

-- 7.	Mostrar un informe con el nombre de departamento y el número de empleados que tiene adscrito. Deben aparecer todos los departamentos, si no tiene empleados se debe mostrar un cero.

select d.dname as departamento, count(e.empno) as empleados
from emp e right join dept d on (d.deptno=e.DEPTNO)
group by d.dname;

-- count(*) devuelve la el numero de fils aunque este vcia


-- 8.	Mostrar un informe con la categoría salarial, el número de empleados que tienen esa categoría salarial y la suma de los salarios ordenado por categoria salarial. Se debe tener en cuenta que es posible que categoría salarial que no la tenga ningún empleado.

SELECT sg.GRADE AS 'categoria salarial', COALESCE(COUNT(e.EMPNO), 0) AS 'numero de empleados', COALESCE(SUM(e.SAL), 0) AS 'salario total'
FROM SALGRADE sg LEFT JOIN EMP e ON e.SAL BETWEEN sg.LOSAL AND sg.HISAL
GROUP BY sg.GRADE
ORDER BY sg.GRADE;


-- coalesce hace que los valores que sean null los pase a 0 para que no de ningun error en la suma

-- 9.	Mostrar el un informe que indique cuantos empleados hay en cada ciudad que no tienen personal a su cargo. Deben aparecer todas las ciudades.
-- ***PISTA: Como primer paso se puede hacer esto, para ver los empleados que no tienen personal a su cargo ***PISTA

SELECT d.LOC AS ciudad, COUNT(e.EMPNO) AS 'empleados sin personal a su cargo'
FROM DEPT d LEFT JOIN EMP e ON (d.DEPTNO = e.DEPTNO)
AND e.EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL)
GROUP BY d.LOC;

SELECT d.LOC AS ciudad, COUNT(e1.EMPNO) AS 'empleados sin personal a su cargo'
FROM DEPT d LEFT JOIN EMP e1 ON (d.DEPTNO = e1.DEPTNO)
LEFT join EMP e2 ON (e2.mgr=e1.empno)
where e2.ename is null
GROUP BY d.LOC;

-- 10.	Mostrar el nombre y categoría salarial de los empleados y sus superiores que cumplen la condición de que ambos trabajen en la misma ciudad.

SELECT e.ename as nombre, sg.GRADE AS 'categoria salarial', e.MGR as jefes
FROM SALGRADE sg
JOIN EMP e ON (e.SAL BETWEEN sg.LOSAL AND sg.HISAL)
JOIN EMP e ON (DEPT d on (d.LOC=d.LOC)
GROUP BY sg.GRADE
ORDER BY e.MGR;




