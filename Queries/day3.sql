-- Display all FIRST_NAME that has letter a in second character
--- '_a%'
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '_a%' ;

--FROM Departments Table
-- 1.13 Display Unique LOCATION_ID
SELECT DISTINCT LOCATION_ID
FROM DEPARTMENTS ;


--- FROM Locations Table
--- Count how many LOCATIONS we have
SELECT COUNT(*) FROM LOCATIONS ;


-- 2.4 Display All Departments with DEPARTMENT_NAME Contains IT
--  exclude the exact match department name IT
SELECT * FROM DEPARTMENTS
WHERE DEPARTMENT_NAME LIKE '%IT %'  ;

--3.4 Display the Employee Count for EACH FIRST_NAME (yeah and observe what you got)
--Filter the grouped result to only display if the count is more than 1

SELECT FIRST_NAME, COUNT(*)
FROM EMPLOYEES
GROUP BY FIRST_NAME
HAVING COUNT(*) > 1
;







