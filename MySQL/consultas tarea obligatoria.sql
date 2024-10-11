use rrhh;

-- 1
SELECT CONCAT(last_name, ', ', first_name) AS Empleado, job_id AS 'codigo de trabajo', salary AS salario
FROM employee
WHERE (job_id LIKE '%MAN' OR job_id LIKE '%MGR') AND salary > 12000
ORDER BY first_name;

-- 2
SELECT CONCAT(first_name, ' ', last_name) AS Empleado, salary as salario, 
	CASE 
        WHEN commission_pct is null THEN 'NO TIENE' 
        ELSE CONCAT(FORMAT(commission_pct * 100, 0), '%') 
    END AS '% Comision',
    CASE 
        WHEN commission_pct is null THEN 'NO TIENE' 
        ELSE salary * commission_pct 
    END AS Comision, 
    salary + CASE 
        WHEN commission_pct is null THEN 0 
        ELSE salary * commission_pct 
    END AS 'Salario Total'
FROM employee
where salary > 10000
ORDER BY 'salario total';

-- 3
SELECT 
    employee_id,
    DATE_FORMAT(hire_date, '%d-%m-%y') AS hire_date,
    IF(DATEDIFF('2015-02-01', hire_date) > (2*365 + 3*30), 'BONUS', 'NO') AS BONUS
FROM 
    employee
WHERE 
    salary > 12000 AND 
    hire_date < '2015-05-01';

-- 4
SELECT 
    employee_id,
    last_name,
    salary,
    CASE 
        WHEN salary < 5000 THEN '#'
        ELSE REPEAT('*', FLOOR(salary / 5000))
    END AS STARS
FROM 
    employee
ORDER BY 
    salary DESC;


-- 5
SELECT 
    employee_id AS 'Código de Empleado',
    UPPER(last_name) AS 'Apellido en Mayúscula',
    LENGTH(last_name) AS 'Longitud del Apellido',
    CONCAT(
        LOWER(SUBSTRING(first_name, 1, 4)),
        UPPER(SUBSTRING(first_name, 5, LENGTH(first_name) - 5)),
        LOWER(SUBSTRING(first_name, -1))
    ) AS 'Nombre Modificado'
FROM 
    employee
WHERE 
    LENGTH(first_name) BETWEEN 6 AND 9;
    
-- 6
SELECT 
    SUM(SUBSTRING(country_name, 1, 1) = 'A') AS 'Países que empiezan por A',
    SUM(SUBSTRING(country_name, 1, 1) = 'C') AS 'Países que empiezan por C'
FROM 
    country;
    
    
-- 7
SELECT 
    YEAR(hire_date) AS 'Año',
    COUNT(*) AS 'Número de Empleados',
    MAX(salary) AS 'Salario Más Alto',
    MIN(salary) AS 'Salario Más Bajo'
FROM 
    employee
WHERE 
    YEAR(hire_date) BETWEEN 2012 AND 2015
GROUP BY 
    YEAR(hire_date)
HAVING 
    MAX(salary) <= 17000 AND MIN(salary) >= 2600;


-- 8
SELECT 
    job.job_title AS 'Oficio',
    AVG(employee.salary) AS 'Salario Medio',
    COUNT(*) AS 'Número de Empleados'
FROM 
    employee
JOIN 
    job ON employee.job_id = job.job_id
GROUP BY 
    job.job_title
HAVING 
    AVG(employee.salary) BETWEEN 3000 AND 5000;



-- 9
SELECT 
    CONCAT(employee.last_name, ', ', employee.first_name) AS 'Nombre del Empleado',
    employee.salary AS 'Salario',
    department.department_name AS 'Nombre del Departamento'
FROM 
    employee
JOIN 
    department ON employee.department_id = department.department_id
WHERE 
    employee.last_name LIKE 'K%';
    
    
    
-- 10  revisar todo peronsobretodo a partir de aqui
SELECT 
    CONCAT(employee.last_name, ', ', employee.first_name) AS 'Nombre del Empleado',
    employee.salary AS 'Salario',
    department.department_name AS 'Nombre del Departamento'
FROM 
    employee
JOIN 
    department ON employee.department_id = department.department_id
WHERE 
    employee.last_name LIKE 'K%';



