/*
1)	평균 연봉(salary)이 가장 높은 나라는?
 */
SELECT country_name "나라이름", salary "평균연봉"
FROM(SELECT co.country_name country_name,
            AVG(em.salary) salary
     FROM employees em, departments de, locations lo, countries co
     WHERE em.department_id = de.department_id
     AND de.location_id = lo.location_id
     AND lo.country_id = co.country_id
     GROUP BY co.country_name)
WHERE salary = (SELECT MAX(salary)
                FROM (SELECT AVG(em.salary) salary
                      FROM employees em, departments de, locations lo, countries co
                      WHERE em.department_id = de.department_id
                      AND de.location_id = lo.location_id
                      AND lo.country_id = co.country_id
                      GROUP BY co.country_id)
               );

               
/*
2)	평균 연봉(salary)이 가장 높은 지역은?
*/
SELECT region_name "지역이름", salary "평균연봉"
FROM(SELECT re.region_name region_name,
            AVG(em.salary) salary
     FROM employees em, departments de, locations lo, countries co, regions re
     WHERE em.department_id = de.department_id
     AND de.location_id = lo.location_id
     AND lo.country_id = co.country_id
     AND co.region_id = re.region_id
     GROUP BY re.region_name)
WHERE salary = (SELECT MAX(salary)
                FROM (SELECT AVG(em.salary) salary
                      FROM employees em, departments de, locations lo, countries co, regions re
                      WHERE em.department_id = de.department_id
                      AND de.location_id = lo.location_id
                      AND lo.country_id = co.country_id
                      AND co.region_id = re.region_id
                      GROUP BY re.region_id)
               );
              
               
/*
3)	가장 많은 직원이 있는 부서는 어떤 부서인가요?
*/
SELECT department_name "부서이름", cnt "직원수"
FROM (SELECT de.department_name, count(em.employee_id) cnt
      FROM employees em, departments de
      WHERE em.department_id = de.department_id
      GROUP BY de.department_name)
WHERE cnt = (SELECT MAX(cnt)
             FROM (SELECT de.department_name, count(em.employee_id) cnt
            	   FROM employees em, departments de
         	       WHERE em.department_id = de.department_id
             	   GROUP BY de.department_name)
            );
