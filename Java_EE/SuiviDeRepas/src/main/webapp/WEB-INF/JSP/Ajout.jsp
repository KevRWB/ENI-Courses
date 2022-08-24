<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter repas</title>
</head>
<body>
	<h1>Ajout de repas</h1>
	
	<form action="AddMeal" method="POST">
		<label for="date">Date</label>
		<input type="date" id="date" name="date">
		<label for="heure">Heure</label>
		<input type="time" id="heure" name="heure">
		<label for="repas">Date</label>	
		<input type="text" id="repas" name="repas">
		<input type="submit" value="Valider">
		<a href="Accueil.jsp"><input type="button" value="Annuler"></a>
	</form>
	<a href="Accueil.jsp"><input type="button" value="Annuler"></a>

</body>
</html>