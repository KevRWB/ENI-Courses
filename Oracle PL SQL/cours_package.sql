Cours PACKAGE

--Permet de modulariser (empaqueter) le développement que l'on fait.

create or replace package PK1 is 
    cursor c_emp is select * from emp;
    v1 integer;
    procedure p1;
    function f1(x int) return int;
end;
/
-----BODY package
create or replace package body PK1 is -- doit avoir le même nom que le package global (PK1)
    procedure p1 is begin end;

    function f1(x int) return int is begin return end;
end;
/


-----Utiliser contenu du package

begin 
    for i in pk1.c_emp loop -- faire précéder le curseur du nom du package
      
    end loop;
end;
/
----SQL DYNAMIQUE

declare 
    v_req varchar(500);
    v_nom emp.ename%type;
begin
    v_req:= 'update emp set sal=800 where ename=
            '' || '&v_nom' || ''';

    execute immediate v_req;

end;