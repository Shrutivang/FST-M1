-- Activity 1:  Create a Salesman table
CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar(20), salesman_city varchar(20), commission int);
DESCRIBE salesman;

-- Activity 2: Insert data into salesman table
INSERT ALL
INTO salesman VALUES(5001, 'James Hoog', 'New York', 15)
INTO salesman VALUES(5002, 'Nail Knight', 'Paris', 13)
INTO salesman VALUES(5005, 'Pit Alex', 'Rome', 11)
INTO salesman VALUES(5006, 'Percy Jacson', 'London', 18)
INTO salesman VALUES(5007, 'Matilda Wormwood', 'France', 21)
INTO salesman VALUES(5003, 'Charles Dickson', 'Germany', 09)
SELECT 1  FROM DUAL;

--To display all the rows
SELECT * FROM salesman

--Activity3  Display data from salesman table
--show data from salesman_id and salesman_city columns
SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission from salesman WHERE salesman_name='Nail Knight';

--Activity4 to add new column
ALTER TABLE salesman ADD (grade int);
DESCRIBE salesman;
UPDATE salesman SET grade=100;

--Activity5 to modify values in the salesman table
UPDATE salesman SET grade=300 WHERE salesman_city ='Rome';
UPDATE salesman SET grade=200 WHERE salesman_name ='Charles Dickson';


UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='Matilda Wormwood';