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

------ SQL JOIN ------
--- IS USED TO GET DATA FROM 2 OR MORE TABLES THAT RELATED TO EACH OTEHR
-- PRIMARY KEY AND FOREIGN KEY RELATIONSHIP

--- INNER JOIN , LEFT OUTER JOIN , RIGHT OUTER JOIN , FULL OUTER JOIN


SELECT COUNTRIES.COUNTRY_NAME , REGIONS.REGION_NAME
FROM COUNTRIES
INNER JOIN REGIONS ON COUNTRIES.REGION_ID = REGIONS.REGION_ID ;

-- we can use alias for table to make above query slightly more readable
-- nicknames are followed by space and the letter or word
-- you can use nickname to select the columns
-- just like you did in java obj.VariableName
SELECT c.COUNTRY_NAME , r.REGION_NAME
FROM COUNTRIES c
INNER JOIN REGIONS r ON c.REGION_ID = r.REGION_ID ;



