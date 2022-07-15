--Dans un bloc pl/sql -> afficher le nom de l'employé qui gagne le plus
declare
   v_nom emp.ename%type;

begin
  select max(sal) into v_sal from emp;
  select ename into v_nom from emp where(select max(sal) from emp;);
  dbms_output.put_line(v_nom);
end;
/

-- Augmenter le salaire de FORD de 10%
declare
  v_nom emp.ename%type;
  v_sal emp.sal%type;
  
begin
  update emp set sal = sal * 1.1 where ename = 'FORD';
  select ename, sal into v_nom, v_sal from emp where ename = 'FORD';
  dbms_output.put_line(v_nom || ' ' || v_sal);
end;

--Afficher le nom, salaire de tous les MANAGER.
--Obtenir la moyenne des salaires des manager
--si leur moyenne est inférieur à la moyenne de tous les employèes --> + 10%
DECLARE
  cursor c_manager is select ename, sal from emp where JOB = 'MANAGER';
  v_avg number(6,2);
BEGIN
  select avg(sal) into v_avg from emp where JOB = 'MANAGER';
  dbms_output.put_line('Moyenne des salaire MANAGER: '||v_avg);
  
  for i in c_manager loop
    if
      i.sal < v_avg then
      i.sal := i.sal * 1.05;
    end if;
      dbms_output.put_line(i.ename || ' - salaire : ' || i.sal);
  end loop;    
END;
/

---------------------------------------
/*
deptno
nom emp
nomemp
deptno
nom emp
nom emp
*/
DECLARE
  cursor v_dept is select deptno from dept;
  cursor v_emp (v_dept emp.deptno%type) is select ename from emp where deptno = v_dept;
BEGIN
  for i in v_dept loop
    dbms_output.put_line(i.deptno);
    for j in v_emp(i.deptno) loop
       dbms_output.put_line(j.ename);
    end loop;
  end loop;
END;
/
--------------------------------