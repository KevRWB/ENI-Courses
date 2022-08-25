<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>Calculateur d'allure / temps</h1>
	
	<h2>Choix du sport :</h2>
		
	<form action="SetFields" method="GET">
		<input type="hidden" name = "type" value="CAP">
		<input type = "submit" value="Course à pied">
	</form>
	
	
	<h2>Course à pied</h2>
	
	<form action="CalculCAP" method="GET">
		<input type="hidden" name="type"value="CAP">
		<h3>Temps de course :</h3>
		<input type="text" name="tpsHeures" size="5">
		<label for="heures"> h :</label>
		<input type="text" name="tpsMinutes" size="5">
		<label for="minutes"> min :</label>
		<input type="text" name="tpsSecondes" size="5">
		<label for="secondes"> sec</label>
		
		<h3>Allure :</h3>
		<input type="text" name="allMinutes" size="5">
		<label for="allMinutes"> min :</label>
		<input type="text" name="allSecondes" size="5">
		<label for="allSecondes"> sec</label>
		
		<h3>Distance parcourue :</h3>
		<input type="text" name="distance" size="10">
		<label for="distance"> km</label>
		
		<h3>Vitesse :</h3>
		<input type="text" name="vitesse" size="5">
		<label for="vitesse"> km/h</label>
		<br><br>
		<input type="reset" value="Effacer">
		<input type="submit" value="Calculer">
	</form>
</body>
</html>