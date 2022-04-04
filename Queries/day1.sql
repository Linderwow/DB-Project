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

-- Display the Employee FIRST_NAME, LAST_NAME,SALARY
-- for the employee with SALARY 4800 and FIRST_NAME David

-- LOGICAL AND
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME = 'David' AND SALARY = 4800 ;

-- Display the Employee FIRST_NAME, LAST_NAME,SALARY
-- for the employee with SALARY 4800 OR FIRST_NAME David
-- LOGICAL OR
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME = 'David' OR SALARY = 4800 ;

-- Display the employees that make more than 5000 and less than 12000
SELECT * FROM EMPLOYEES
WHERE SALARY>5000 AND SALARY<12000 ; -- 49

-- Display the employees that have JOB_ID of
                                    -- AD_VP
                                    -- AD_ASST
                                    -- FI_ACCOUNT
                                    -- AC_ACCOUNT
SELECT * FROM EMPLOYEES
WHERE JOB_ID = 'AD_VP'
    OR  JOB_ID = 'AD_ASST'
    OR  JOB_ID = 'FI_ACCOUNT'
    OR  JOB_ID = 'AC_ACCOUNT' ;




