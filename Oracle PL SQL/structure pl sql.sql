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
---------------TEST ECRITURE PLEIN DE DONNEES--------------

CREATE TABLE t10 (code NUMBER, nom VARCHAR(20), prenom VARCHAR(20));

begin
  FOR i in 1..6000000 loop
    insert into t10 values(i,'NOM'||i, 'PRENOM'||i);
  END LOOP;
  
  COMMIT;
  
END;

ALTER SYSTEM FLUSH shared_pool;
ALTER SYSTEM FLUSH buffer_cache;

analyze table t10 comput statistics;
CREATE INDEX i_nom on T10(NOM);
SELECT * FROM t10 WHERE nom = 'NOM3000000';

----------CURSEUR (plus d'une ligne retournée par le SELECT)
----CURSEUR BOUCLE FOR
DECLARE
  cursor c_emp is select ename from emp;
BEGIN

  for i in c_emp loop
    dbms_output.put_line(i.ename);
  end loop;
END;
/
--- CURSEUR BOUBLE LOOP
DECLARE
  cursor c_emp is select ename from emp; -- déclaration du curseur
  v_nom   emp.ename%type;   -- variable dont le type est égal au type de sa colonne
  ---OU -> v_liste emp%rowtype ( Selection multiple)
BEGIN
  open c_emp; -- Ouverture du curseur
  loop        -- début de loop
    fetch c_emp into v_nom; -- cherche la valeur dans le curseur (équivalent SELECT)
    exit when c_emp%notfound;  ---sortie de boucle qd curseur ne trouve plus de données
    dbms_output.put_line(v_nom); -- Affiche v_nom
                  --Ou (v_nom.ename  -- Selection multiple)
  end loop;
  dbms_output.put_line('Nombre employes : ' ||c_emp%rowcount); ---Compte des lignes
 
  close c_emp; -- Fermeture du curseur
END;
/
------
-----Bloc pl/sql nom des emplpyés travaillant à DALLAS

DECLARE
  cursor c_names IS SELECT ename  FROM emp e 
  INNER JOIN dept d ON d.deptno = e.deptno
  WHERE loc = 'DALLAS';
BEGIN
  FOR i IN c_names LOOP
     dbms_output.put_line(i.ename);
  END LOOP;
END;
/

-----Creer nouvelle colonne numEmp dans DEPT
-----compter le nombre d'employés par département -> Insérer dans la colonne numEmp
ALTER TABLE dept ADD
  (nbEmp number(3) default 0);
--------------
DECLARE 
  CURSOR c1 is select deptno, count(*) as nb from emp group by deptno;
BEGIN
  for i in c1 loop
    update dept set nbEmp = i.nb where deptno = i.deptno;
  end loop;
END;
/
---CUSREURS PARAMETRES----
DECLARE
  cursor c1 (v_dep emp.deptno%type) is select ename from emp where deptno=v_dep;
  v_nom emp.ename%type;
BEGIN
  open c1(20)
    loop
      fetch c1 into v_nom;
      dbms_output.put_line(v_nom);
      exit when c1%notfound;
    end loop;
  close c1;
END;
/
---------EXCEPTIONS---------


DECLARE
  v_nom varchar(5);
  v_prenom varchar(5);
BEGIN
  ----BLOC UN
  BEGIN -- Creation de blocs imbriqués permettant d'isoler les exceptions
  v_nom:='Traudeau';
    exception
    when value_error then
        dbms_output.put_line('Nom trop grand'); -- si erreur 'value-error' -> Output 'Nom trop grand'
    when others then    
        dbms_output.put_line(sqlcode||' : '||sqlerrm);
  END;
  --BLOC DEUX
  BEGIN
    v_prenom:= 'Caroline';
        exception
           when value_error then
            dbms_output.put_line('Prenom trop grand');
           when others then    
            dbms_output.put_line(sqlcode||' : '||sqlerrm);
  END;
  --OUTPUT et EXCEPTIONS du programme général
  dbms_output.put_line('OK');
  dbms_output.put_line('Nom : ' || v_nom || ' - Prenom : ' ||v_prenom);
    exception
           when others then    
            dbms_output.put_line(sqlcode||' : '||sqlerrm);
END;
/

----------------EXCEPTIONS NON PREDEFINIEES
CREATE TABLE t20 (nom varchar(5));
--------
DECLARE
  ---declare exception
  trop_grand exception;
  PRAGMA exception_init(trop_grand, -12899);

BEGIN
  insert into t20 values('Delphine');
  EXCEPTION
    when trop_grand then
      dbms_output.put_line('Nom trop grand');
    when others then
      dbms_output.put_line(sqlcode ||' : ' ||sqlerrm);
END;
/

----------------EXCEPTIONS PERSONNALISEES
