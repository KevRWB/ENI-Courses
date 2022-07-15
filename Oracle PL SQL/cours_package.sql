Cours PACKAGE

--Permet de modulariser (empaqueter) le développement que l'on fait.

create or replace package PK1 is 
    cursor c_emp is select * from emp;
    v1 integer;
end;
/