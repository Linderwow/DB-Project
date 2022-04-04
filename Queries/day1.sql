-- This is how you write comment in sql
-- single line comment look like this
/*
  This is how you write multi
  line comment
 */
-- each query you write known as sql SELECT statement
-- * means all , here it means all columns
-- from TableName that exist in the database
-- Just like Java ,
-- SQL Statements end in semi-colon ; and it's mandatory
SELECT * FROM REGIONS ;
-- If you want to run second statement
-- you just need to click the query to focus the cursor and click run
SELECT * FROM COUNTRIES ;

SELECT * FROM LOCATIONS ;

SELECT * FROM DEPARTMENTS ;

SELECT * FROM JOBS ;

SELECT * FROM JOB_HISTORY ;

SELECT * FROM EMPLOYEES ;


-- RESTRICTING COLUMNS IN THE RESULT
-- SQL IS SPACE INSENSITIVE
SELECT FIRST_NAME
FROM EMPLOYEES ;

-- More than one columns can be specified separated by comma ,
SELECT FIRST_NAME, LAST_NAME , EMAIL
FROM EMPLOYEES ;

/*
TASK : SELECT SPECIFIC COLUMNS FROM OTHER TABLES
TO GET YOURSELF FAMILIAR WITH HR DATABASE
*/

/**
  Only Getting Unique value from the result
  for example, only get unique first name from employees table
 */

SELECT DISTINCT FIRST_NAME
FROM EMPLOYEES ;  -- 91 ROWS

-- Get only unique last names
SELECT DISTINCT LAST_NAME
FROM EMPLOYEES ;  -- 102 ROWS

-- This is looking for people with unique first name lastname , full name
SELECT DISTINCT FIRST_NAME, LAST_NAME
FROM EMPLOYEES ;


--RESTRICTING ROWS IN THE RESULT USING WHERE CLAUSE
-- COMPARISON OPERATORS :  = , > >= , < , <= , != , <>
-- LOGICAL OPERATORS :  AND OR

-- Display the Employee information for the employee with first_name Ellen
-- IN SQL We use single quote for String.
SELECT * FROM EMPLOYEES
WHERE FIRST_NAME = 'Ellen' ;  -- Ellen != ellen != ELLEN , values are case sensitive

-- Display the Employee FIRST_NAME, LAST_NAME,SALARY
-- for the employee with SALARY 11000
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY = 11000 ;




