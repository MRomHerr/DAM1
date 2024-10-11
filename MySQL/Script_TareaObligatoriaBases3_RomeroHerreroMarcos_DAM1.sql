use rrhh;

-- 1 Mostrar el nombre del empleado en formato “Apellido, Nombre” con el nombre de columna "Empleado", código de trabajo y 
-- el salario de los empleados que son Manager (su código de trabajo acaba en ‘MAN’ o ‘MGR’) y cuyo salario sea mayor de 12000 
-- ordenados alfabéticamente por apellido.
select concat(last_name, ', ', first_name) as empleado, job_id as 'codigo de trabajo', salary as salario
from employee
where (job_id like '%MAN' or job_id like '%MGR') and salary > 12000
order by first_name;


-- 2 Mostrar el nombre del empleado en formato "Nombre, Apellido” con el nombre de columna "Empleado", el salario, porcentaje de 
-- comisión (0.20 es el 20%) con el título '% Comision' (debe aparecer sin decimales), la comisión correspondiente y salario total 
-- (salario + comisión) para los empleados cuyo salario sea superior a 10000. Para aquellos empleados que no tengan comisión se debe
-- de indicar 'NO TIENE' tanto en la columna correspondiente al porcentaje de la comisión como en la comisión resultado de aplicar 
-- dicho porcentaje. Se debe de ordenar el resultado de menor a mayor salario total. Todos los resultados deben aparecer sin decimales.
select concat(first_name, ' ', last_name) as empleado, salary as salario, 
	case 
        when commission_pct is null then 'no tiene' 
        else concat(format(commission_pct * 100, 0), '%') 
    end as '% comision',
    case 
        when commission_pct is null then 'no tiene' 
        else salary * commission_pct 
    end as comision, 
    salary + case 
        when commission_pct is null then 0 
        else salary * commission_pct 
    end as 'salario total'
from employee
where salary > 10000
order by 'salario total';


-- 3 Mostrar un listado con el código de empleado, fecha de contratación en formato ‘DD-MMM-YY’ y una columna que muestre si el día 
-- uno de febrero de 2015 llevaba más de 2 años y tres meses con el nombre de columna “BONUS”, indicando "BONUS" en el caso de tener o 
-- "NO" en caso contrario para todos los empleados que ganen más de 12000 y hayan entrado antes del 1 de mayo de 2015.
select employee_id as 'codigo de empleado',
    date_format(hire_date, '%d-%m-%y') as 'fecha de contratación',
    if(datediff('2015-02-01', hire_date) > (2*365 + 3*30), 'BONUS', 'NO') as BONUS
from employee
where salary > 12000 and hire_date < '2015-05-01';


-- 4 Mostrar un listado que muestre el código de empleado, apellido, salario y una columna que se llame “STARS” que muestre una 
-- cadena formada por una estrella (asterisco *) por cada 5000 unidades de salario que tiene el empleado (ejemplo: si alguien tiene 
-- de salary = 10000, se mostrará en dicha columna **), si gana menos de 5000 debe mostrar la cadena ‘#’. Ordenar el resultado de mayor
-- a menor salario (salary).
select employee_id as 'codigo de empeado', last_name as apellido, salary as salario,
    case 
        when salary < 5000 then '#'
        else repeat('*', floor(salary / 5000))
    end as STARTS
from employee
order by salary desc;


-- 5 Mostrar un listado que contenga el código de empleado, su apellido en mayúscula, longitud de su apellido y el nombre del empleado de 
-- tal manera que las 4 primeras letras del nombre y la última estén en minúsculas y el resto en mayúsculas, para todos los empleados cuya 
-- la longitud de su nombre esté entre seis y nueva caracteres.
select employee_id as 'código de empleado', upper(last_name) as 'apellido en mayúscula', length(last_name) as 'longitud del apellido',
    concat(lower(substr(first_name, 1, 4)), upper(substr(first_name, 5, length(first_name) - 5)), lower(substr(first_name, -1))) as 'nombre modificado'
from employee
where length(first_name) between 6 and 9;
    
    
-- 6 Mostrar cuántos países empiezan por A y cuantos por C. No se puede usar CASE-WHEN ni LIKE.
select sum(substr(country_name, 1, 1) = 'a') as 'países que empiezan por a', sum(substr(country_name, 1, 1) = 'c') as 'países que empiezan por c'
from country;
    
    
-- 7 Mostrar para cada año, entre 2012 y 2015 el número de empleados, así como el salario más alto y el más bajo que ha tenido la empresa, 
-- para aquellos años en los que el salario más alto no excediera de 17000 y el más bajo fuera de al menos 2600.
select year(hire_date) as año, count(*) as 'número de empleados', max(salary) as 'salario más alto', min(salary) as 'salario más bajo'
from employee
where year(hire_date) between 2012 and 2015
group by year(hire_date)
having max(salary) <= 17000 and min(salary) >= 2600;


-- 8 Mostrar el oficio, el salario medio de dicho oficio, y el número de empleados que hay de cada uno de ellos, cuyo salario medio está 
-- comprendido en la franja de 3000 a 5000.
select j.job_title as oficio, avg(e.salary) as 'salario medio', count(*) as 'número de empleados'
from employee e
join job j on e.job_id = j.job_id
group by j.job_title
having avg(e.salary) between 3000 and 5000;


-- 9 Mostrar un listado con el nombre del empleado (formato Apellido, Nombre), el salario y el nombre del departamento en el que trabaja para 
-- todos los empleados cuyo apellido empieza por la letra K.
select concat(e.last_name, ', ', e.first_name) as 'nombre del empleado', e.salary as 'salario', d.department_name as 'nombre del departamento'
from employee e
join department d on e.department_id = d.department_id
where e.last_name like 'k%';
     
     
-- 10 Mostrar para cada nombre de departamento y para cada nombre de puesto de trabajo cuántos empleados hay. Tener en cuenta que es posible
-- que haya empleados que no estén asignados a un departamento.
select concat(e.last_name, ', ', e.first_name) as 'nombre del empleado', e.salary as 'salario', d.department_name as 'nombre del departamento'
from employee e
join department d on e.department_id = d.department_id
where e.last_name like 'k%';


-- 11 Mostrar cuantos empleados y cuál es el salario medio de los empleados que trabajan en cada país (se debe de mostrar el nombre del país). 
-- Tener en cuenta que hay un empleado sin departamento asignado. Para los empleados sin país asignado se debe mostrar "Sin asignar".
select coalesce(c.country_name, 'sin asignar') as 'país', count(e.employee_id) as 'número de empleados', avg(e.salary) as 'salario medio'
from employee e
left join department d on e.department_id = d.department_id 
left join location l on d.location_id = l.location_id
left join country c on l.country_id = c.country_id
group by c.country_name;


-- 12 Mostrar el apellido y el oficio de los empleados y su superior de aquellos empleados que no trabajan en el mismo país que su superior. 
select e1.last_name as 'apellido del empleado', j1.job_title as 'oficio del empleado', e2.last_name as 'apellido del superior', j2.job_title as 'oficio del superior'
from employee e1
join job j1 on e1.job_id = j1.job_id
join department d1 on e1.department_id = d1.department_id
join location l1 on d1.location_id = l1.location_id
join employee e2 on e1.manager_id = e2.employee_id
join job j2 on e2.job_id = j2.job_id
join department d2 on e2.department_id = d2.department_id
join location l2 on d2.location_id = l2.location_id
where l1.country_id <> l2.country_id;
    
    
    -- PARTE 2
    
-- Primera consulta se trata de una consulta simple. Se deben de usar al menos una función para trabajar con cadenas de texto, una función 
-- para trabajar con fechas, y la función SUBSTR, además de algún filtro con WHERE.
   
-- 1 Enunciado: Obtén el nombre y las primeras tres letras del apellido en mayúsculas de los empleados que fueron contratados en julio de 2016.
select first_name as nombre, concat(upper(substr(last_name, 1, 3)),  lower(substr(last_name, -3))) as 'apellido modificado'
from employee
where month(hire_date) = 7 and year(hire_date) = 2016;



-- Segunda consulta. Se deben de usar al menos tres funciones de agregación, filtrado de filas WHERE y filtrado con HAVING.
    
-- 2 Enunciado: Obtén el identificador del departamento, el número total de empleados, el salario promedio (redondeado a 3 decimales) y 
-- el salario máximo de cada departamento de la tabla employee para aquellos departamentos que tienen más de 10 empleados contratados 
-- después del 1 de enero del 2000
select department_id as 'codigo de departamento', count(employee_id) as 'número de empleados', round(avg(salary), 3) as 'salario promedio', max(salary) as 'salario máximo'
from employee
where hire_date > '2000-01-01'
group by department_id
having COUNT(employee_id) > 10;

    
-- Tercera consulta. Debe de ser una consulta multitabla, uso obligado de LEFT JOIN en el que se tengan que consultar al menos 3 tablas distintas. 

-- 3 Enunciado: Obtén el nombre, el apellido, el oficio y el nombre del departamento de los empleados que tienen un salario mayor a 10000.
select e.first_name as nombre, e.last_name as apellido, j.job_title as oficio, d.department_name as departamento
from employee e
left join job j on e.job_id = j.job_id
left join department d on e.department_id = d.department_id
where e.salary > 10000;


