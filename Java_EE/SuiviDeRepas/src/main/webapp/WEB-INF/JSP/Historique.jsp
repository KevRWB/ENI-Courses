<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historique</title>
</head>
<body>
	<h1>Historique</h1>
	
	<form action="AddMeal" method="GET">
		<table>
			<tr>
				<td>Date</td>
				<td>Heure</td>
				<td>Actions</td>
			</tr>
			
			<tr>
				<td>11/02/21</td>
				<td>12h30</td>
				<td><input type="button" value="Détail"></td>
			</tr>
		</table>
		
		
		<input type="submit" value="Ajouter nouveau repas">
		<a href="/WEB-INF/Accueil.jsp"><input type="button" value="Annuler"></a>
	</form>
	
</body>
</html>