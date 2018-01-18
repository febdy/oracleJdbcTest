/*
1) EMPLOYEE 테이블에서 이름(Last Name)에 “hae”를 포함하고 있는 사원들과 같은 부서에서 근무하고 있는 사원의 
EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPARTMENT_ID 를 출력하라. 
*/
SELECT employee_id,
	   first_name,
	   last_name,
	   department_id
FROM employees
WHERE department_id = ( SELECT department_id
					    FROM employees
					    WHERE last_name like '%hae%' )
ORDER BY employee_id DESC;


/*
2) 각 도시(city)별 가장 연봉을 많이 받고 있는 사원의 도시 이름(City), First Name, Last Name, 급여를 조회하라. 
급여 순으로 오름차순 정렬하시오. (1-2.sql)
*/  
SELECT A.city, A.first_name, A.last_name, A.salary
FROM (SELECT first_name, last_name, salary, lo.city
      FROM employees em, departments de, locations lo
      WHERE em.department_id = de.department_id
      AND de.location_id = lo.location_id) A
      ,
     (SELECT lo.city, MAX(em.salary) salary
      FROM employees em, departments de, locations lo
      WHERE em.department_id = de.department_id
      AND de.location_id = lo.location_id
      GROUP BY lo.city) B
WHERE A.salary = B.salary
AND A.city = B.city
ORDER BY A.salary ASC;