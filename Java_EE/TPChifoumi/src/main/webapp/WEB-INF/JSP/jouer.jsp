<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style/style.css" rel="stylesheet">
<title>Chifoumi - Jeu</title>

</head>
<body>
	<h1>Chifoumi</h1>
	<h2>Que voulez-vous jouer ?</h2>
	
	<form action="Traitement"  method="post">
		 <div>
		    <input type="radio" id="pierre"
		     name="chifumi" value="pierre">
		    <label for="pierre">Pierre</label>
		
		    <input type="radio" id="feuille"
		     name="chifumi" value="feuille">
		    <label for="feuille">Feuille</label>
		
		    <input type="radio" id="ciseaux"
		     name="chifumi" value="ciseaux">
		    <label for="ciseaux">Ciseaux</label>
		  </div>
		  <br>
		  <input type="submit" value="Jouer !">
	</form>
</body>
</html>