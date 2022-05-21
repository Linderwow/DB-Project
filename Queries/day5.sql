Select * FROM EMPLOYEES;

-- Case When Statement to conditionally display values

-- Display Employees FIRST_NAME, SALARY, SALARY_GRADE

--SALARY_GRADE Column should be below VALUES
--when SALARY > 8000 "ABOVE AVERAGE"
--else "Below Average"

Select FIRST_NAME, SALARY,
CASE
When Salary > 8000 Then 'Above Average'
Else 'Below Average'
End as Salary_Grade
FROM EMPLOYEES;


SELECT FIRST_NAME,SALARY,
       Case
    WHEN SALARY> 2000 Then 'A'
    WHEN SALARY between 10000 and 20000 Then 'B'
    WHEN SALARY between 5000 and 10000 Then 'C'
    else 'D'
END as Salary_Grade2
From EMPLOYEES
ORDER BY SALARY DESC ;

SELECT FIRST_NAME,HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN TO_DATE('2002-08-16','YYYY-MM-DD') and TO_DATE('2004-08-19','YYYY-MM-DD');