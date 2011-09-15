CREATE TABLE IF NOT EXISTS batch1 (
  EMPNO NUMERIC(4),
  ENAME VARCHAR(10),
  JOB VARCHAR(9),
  MGR NUMERIC(4),
  HIREDATE DATE,
  SAL NUMERIC(7,2),
  COMM NUMERIC(7,2),
  DEPTNO NUMERIC(2),
  PRIMARY KEY (EMPNO) 
)|
INSERT INTO batch1 VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20)|
INSERT INTO batch1 VALUES (7499,'ALLEN','SALESMAN',7698,'1981-2-20',1600,300,30)|
INSERT INTO batch1 VALUES (7521,'WARD','SALESMAN',7698,'1981-2-22',1250,500,30)|
INSERT INTO batch1 VALUES (7566,'JONES','MANAGER',7839,'1981-4-2',2975,NULL,20)|
INSERT INTO batch1 VALUES (7654,'MARTIN','SALESMAN',7698,'1981-9-28',1250,1400,30)|
INSERT INTO batch1 VALUES (7698,'BLAKE','MANAGER',7839,'1981-5-1',2850,NULL,30)|
INSERT INTO batch1 VALUES (7782,'CLARK','MANAGER',7839,'1981-6-9',2450,NULL,10)|
INSERT INTO batch1 VALUES (7788,'SCOTT','ANALYST',7566,'1981-06-09',3000,NULL,20)|
INSERT INTO batch1 VALUES (7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10)|
INSERT INTO batch1 VALUES (7844,'TURNER','SALESMAN',7698,'1981-9-8',1500,0,30)|
INSERT INTO batch1 VALUES (7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20)|
INSERT INTO batch1 VALUES (7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30)|
INSERT INTO batch1 VALUES (7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20)|
INSERT INTO batch1 VALUES (7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10)|
CREATE TABLE IF NOT EXISTS batch2 (
  JOB VARCHAR(9),
  AVGSAL NUMERIC(7,2),
  PRIMARY KEY (JOB) 
)|
INSERT INTO batch2 VALUES ('CLERK',0)|
INSERT INTO batch2 VALUES ('SALESMAN',0)|
INSERT INTO batch2 VALUES ('MANAGER',0)|
INSERT INTO batch2 VALUES ('ANALYST',0)|
INSERT INTO batch2 VALUES ('PRESIDENT',0)|