/*
SELECT RESTRICTIONS
*/

SELECT * FROM Employes
	WHERE DateNaissance is null AND CodeChef is not null;

SELECT CodeEmp,
		UPPER(Nom) + ' ' + Prenom AS 'Identite', --ALIAS with "AS"
		-- If null 'ISNULL' -> Print 'non renseigné' - converti en CHAR
		 ISNULL(CONVERT (char, DateNaissance, 103), '<non renseigné>') [Date de naissance], -- ALIAS with the name at the end of the line
		 ISNULL(CONVERT (char, DateEmbauche, 103), '<non renseigné>') [Embauche le],
		 -- Create new selection with name 'Salaire augmente' with a calcul
		 SalaireAugmente = Salaire *2
		FROM Employes
		
		WHERE Salaire * 1.1 > 3000;

SELECT CodeEmp,
		UPPER(Nom) + ' ' + Prenom AS 'Identite', --ALIAS with "AS"
		-- If null 'ISNULL' -> Print 'non renseigné' - converti en CHAR
		 ISNULL(CONVERT (char, DateNaissance, 103), '<non renseigné>') [Date de naissance], -- ALIAS with the name at the end of the line
		 ISNULL(CONVERT (char, DateEmbauche, 103), '<non renseigné>') [Embauche le],
		 -- Create new selection with name 'Salaire augmente' with a calcul
		 SalaireAugmente = Salaire *2,
		 CodeService AS [Code Service]
		FROM Employes
		
		WHERE UPPER(RTRIM( CodeService)) = 'RESHU';

SELECT CodeEmp,
		UPPER(Nom) + ' ' + Prenom AS 'Identite', --ALIAS with "AS"
		-- If null 'ISNULL' -> Print 'non renseigné' - converti en CHAR
		 ISNULL(CONVERT (char, DateNaissance, 103), '<non renseigné>') [Date de naissance], -- ALIAS with the name at the end of the line
		 ISNULL(CONVERT (char, DateEmbauche, 103), '<non renseigné>') [Embauche le],
		 -- Create new selection with name 'Salaire augmente' with a calcul
		 SalaireAugmente = Salaire *2,
		 CodeService AS [Code Service]
		FROM Employes
		
		WHERE DATEDIFF(YEAR, DateEmbauche, GETDATE()) > 10;
		
		