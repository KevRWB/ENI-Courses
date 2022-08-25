<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>TP GESTION DES REPAS</h1>
	<h2>ACCUEIL</h2>
	
	<form action="AddMeal" method="GET">
		<input type="submit" value="Ajouter nouveau repas">
	</form>
	
	<form action="PrintMeals" method="GET">
		<input type="submit" value="Visualiser les repas">
	</form>
	
</body>
</html>