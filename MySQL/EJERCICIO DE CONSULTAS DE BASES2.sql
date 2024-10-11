1. ¿Que empleados van alfabéticamente antes que MARTIN?.
SELECT ENAME
FROM EMP
WHERE ENAME < 'MARTIN'
ORDER BY ENAME;

2.Mostrar nombre, oficio y salario del los empleados del dpto 30 ordenados por oficio y
salario en orden descendente
SELECT ENAME, JOB, SAL
FROM EMP
WHERE DEPTNO = 30
ORDER BY JOB, SAL DESC;

3.Mostrar el nombre y salario total indicando "TOTAL" (salario + comisión) de todos los empleados que su nomina
sea mayor que 1.800
SELECT ENAME, SAL + COALESCE(COMM, 0) AS TOTAL_SALARY
FROM EMP
WHERE SAL + COALESCE(COMM, 0) > 1800;

4.Obtener el nombre y el oficio de todos los empleados del dpto 30 que no sean vendedor (Salesman)
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = 30 AND JOB != 'SALESMAN';

5. Nombre y oficio de los empleados del dpto 10 que no sean ni DIRECTOR ni PRESIDE (Manager - President)
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = 10 AND JOB NOT IN ('MANAGER', 'PRESIDENT');

6. Obtener el nombre y el oficio de todos los empleados del dpto 30 que no sean vendedor (hazlo de forma distinta a la anterior)
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = 30 AND JOB <> 'SALESMAN';

7.Mostrar todos los empleados que entraron en la empresa en 1.981
SELECT *
FROM EMP
WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;

8.Mostrar el nombre de los empleados que alfabéticamente estén entre JAMES y SCOTT
SELECT ENAME
FROM EMP
WHERE ENAME BETWEEN 'JAMES' AND 'SCOTT'
ORDER BY ENAME;

9.Mostrar el nombre y la fecha de entrada de todos los empleados que no hayan entrado a
trabajar en 1.981. Ordenar por fecha de entrada.
SELECT ENAME, HIREDATE
FROM EMP
WHERE EXTRACT(YEAR FROM HIREDATE) != 1981
ORDER BY HIREDATE;

10.Mostrar nombre, oficio y comisión todos los empleados del dpto 30 que cobran comision
SELECT ENAME, JOB, COMM
FROM EMP
WHERE DEPTNO = 30 AND COMM IS NOT NULL;

11.Mostrar nombre y oficio de todos los empleados que tengan una E en su nombre
SELECT ENAME, JOB
FROM EMP
WHERE ENAME LIKE '%E%';

12. Mostrar los empleados cuyo nombre tiene una A y después una S en su nombre. Tiene que
ser específicamente en ese orden
SELECT ENAME, JOB
FROM EMP
WHERE ENAME LIKE '%A%S%';

13. Mostrar los empleados cuyo nombre tiene una A y una S en su nombre; es decir, puede
aparecer primero una A y después una S o al contrario.
SELECT ENAME, JOB
FROM EMP
WHERE ENAME LIKE '%A%' AND ENAME LIKE '%S%';

14. Mostrar un listado con la frase 'ename is a job' para cada uno de los empleados
SELECT CONCAT(ENAME, ' is a ', JOB) AS Phrase
FROM EMP;


15. Mostrar los empleados que su jefe no sea 7782 o 7839
SELECT *
FROM EMP
WHERE MGR NOT IN (7782, 7839);

16. Mostrar nombre,salario y el salario aumentado un 1.25% de todos los empleados. Redondear
a dos decimales.
SELECT ENAME, SAL, ROUND(SAL * 1.0125, 2) AS "incremento del salario"
FROM EMP;

17. Mostrar la comisión media de los empleados de la empresa
SELECT AVG(COMM) AS "comision media"
FROM EMP;

18. Mostrar cuantos perfiles profesionales (distintos job) hay en la empresa
SELECT COUNT(DISTINCT JOB) AS "distintos jobs"
FROM EMP;

19. NO HACER!!! (TODAVÍA - Hay que ver la función que trabaja con valores NULL): Mostrar la comisión media de los empleados teniendo en cuenta que si es NULL se cuenta como cero. Redondear a dos decimales.
SELECT ROUND(AVG(COALESCE(COMM, 0)), 2) AS "comision media"
FROM EMP;


20.NO HACER!!! (TODAVÍA - Hay que ver la función que trabaja con valores NULL) Mostrar el nombre, fecha de contratación y la suma y resta quince días a dicha fecha
SELECT ENAME,
    HIREDATE AS "Fecha Contratación",
    HIREDATE + INTERVAL '15 days' AS "Fecha Contratación + 15 días",
    HIREDATE - INTERVAL '15 days' AS "Fecha Contratación - 15 días"
FROM EMP;



