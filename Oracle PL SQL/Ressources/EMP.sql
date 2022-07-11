drop table emp;
drop table dept;

CREATE TABLE DEPT
(DEPTNO NUMBER(4) Constraint PK_DEPT PRIMARY KEY,
 DNAME Varchar2(30) Constraint NN_NAME NOT NULL,
 LOC Varchar2(30)
);

CREATE TABLE EMP
(EMPNO Number(4)	Constraint PK_EMP	PRIMARY KEY,
 ENAME Varchar2(30)	Constraint NN_NOM_EMP	NOT NULL,
 JOB Varchar2(30),
 MGR Number(4),
 HIREDATE	DATE,
 SAL		Number(7,2),
 COMM		Number(7,2),
 DEPTNO		Number(4),
 Constraint FK_DEPT FOREIGN KEY(deptno) References DEPT(DEPTNO)
);

Insert into DEPT values (10,'ACCOUNTING','NEW YORK');
Insert into DEPT values (20,'RESEARCH','DALLAS');
Insert into DEPT values (30,'SALES','CHICAGO');
Insert into DEPT values (40,'OPERATIONS','BOSTON');

Insert into EMP values (7369,'SMITH','CLERK',7902,'17/12/80',800,null,20);
Insert into EMP values (7499,'ALLEN','SALESMAN',7698,'20/02/81',1600,300,30);
Insert into EMP values (7521,'WARD','SALESMAN',7698,'22/02/81',1250,500,30);
Insert into EMP values (7566,'JONES','MANAGER',7839,'02/04/81',2975,null,20);
Insert into EMP values (7654,'MARTIN','SALESMAN',7698,'28/09/81',1250,1400,30);
Insert into EMP values (7698,'BLAKE','MANAGER',7839,'01/05/81',2850,null,30);
Insert into EMP values (7782,'CLARK','MANAGER',7839,'09/06/81',2450,null,10);
Insert into EMP values (7788,'SCOTT','ANALYST',7566,'09/12/82',3000,null,20);
Insert into EMP values (7839,'KING','PRESIDENT',NULL,'17/11/81',5000,null,10);
Insert into EMP values (7844,'TURNER','SALESMAN',7698,'08/09/81',1500,0,30);
Insert into EMP values (7876,'ADAMS','CLERK',7788,'12/01/83',1100,null,20);
Insert into EMP values (7900,'JAMES','CLERK',7698,'03/12/81',950,null,30);
Insert into EMP values (7902,'FORD','ANALYST',7566,'03/12/81',3000,null,20);
Insert into EMP values (7934,'MILLER','CLERK',7782,'23/01/82',1300,null,10);

COMMIT;
