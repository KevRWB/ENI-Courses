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