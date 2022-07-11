BLOC PL/SQL

  [DECLARE]
    variables ou constantes
    cursors
    exceptions
    procedures ou fonctions
  BEGIN
    instructions SQL
    structures de contrôle
    
    [EXCEPTION]
    Gestion des erreurs
  
  END;

  [/]

commentaires
    --uncommentaire
    /*
    commentaire multi lignes
    */

-- VARIABLES
DECLARE 
  v_nom varchar(5);
  v_num int(3);
 
BEGIN
  v_nom:='Aline';
  v_num:= 45;

  dbms_output.put_line('Le nom de la personne est ' ||v_nom);
  dbms_output.put_line(v_num);
END;
/

SELECT ename as "Nom des employés" from emp;
/

------------------

DECLARE   
    v_president   emp.ename%type;
    v_hiredate    emp.hiredate%type;
    v_sal         emp.sal%type;
BEGIN
   SELECT ename INTO v_president FROM emp WHERE job = 'PRESIDENT';
   dbms_output.put_line('Nom employé: ' || v_president);
   
   SELECT hiredate INTO v_hiredate FROM emp WHERE job = 'PRESIDENT';
    dbms_output.put_line('Date emchauche: '|| v_hiredate);
    
    SELECT sal INTO v_sal FROM emp WHERE job = 'PRESIDENT';
    dbms_output.put_line('Salaire: '|| v_sal || '€');
END;
/

----------------
DECLARE   
  v_sal emp.sal%type;
BEGIN
  UPDATE emp SET sal = sal*1.1 WHERE ename='SMITH'
  RETURNING sal INTO v_sal;
  dbms_output.put_line(v_sal);
END;
/

----------------
--Extraire le salaire d'un employé (exJONES)
--SI salaire indéfreur à 1000 -> 'bas salaire'
--si entre 1000 et 3000 ' salaire moyen'
--sinon 'salaire correct'

DECLARE   
  v_sal emp.sal%type;
BEGIN
  SELECT sal INTO v_sal FROM emp WHERE ename = 'JONES';
    IF v_sal < 1000 THEN
      dbms_output.put_line('Bas salaire');
    ELSIF v_sal < 3000 THEN
       dbms_output.put_line('Salaire moyen');
    ELSE 
       dbms_output.put_line('Salaire correct');
    END IF;
END;
/

----V2 regrouper l'affichage dans une variable
DECLARE   
  v_sal emp.sal%type;
  v_resultat varchar(30);
BEGIN
  SELECT sal INTO v_sal FROM emp WHERE ename = 'JONES';
    IF v_sal < 1000 THEN
      v_resultat:= 'Bas salaire';
    ELSIF v_sal < 3000 THEN
        v_resultat:= 'Salaire moyen';
    ELSE 
        v_resultat:= 'Salaire correct';
    END IF;
    
    dbms_output.put_line(v_resultat);
END;
/
----CASE----
DECLARE   
v_salaire emp.sal%type;
v_resultat varchar2(30);
BEGIN
  CASE 
  WHEN v_salaire < 1000 THEN v_resultat:='bas salaire';
  WHEN v_salaire < 3000 THEN v_resultat:='Salaire moyen';
  ELSE 
    v_resultat:='Bon salaire';
  END CASE;
  
  dbms_output.put(v_resultat);
END;
/
-----FOR LOOP--------
CREATE TABLE test (code NUMBER, nom VARCHAR(20));
----------------------
BEGIN
  FOR i IN 1..3 LOOP
    INSERT INTO test VALUES (i, 'NOM'||i);
  END LOOP;
END;
/
----WHILE LOOP-----
DECLARE
  v_count integer:=1;
BEGIN
  WHILE v_count <= 3 LOOP
    INSERT INTO test VALUES (v_count, 'NOM'||v_count);
    v_count := v_count +1;
  END LOOP;
END;
---LOOP LOOP (DO WHILE LOOP)--------------
DECLARE
  v1 integer :=0;
BEGIN
  
  LOOP
    v1:= v1+1;
    INSERT INTO test VALUES(v1, 'NOM' || v1);
    EXIT WHEN v1=3;
  END LOOP;
END;