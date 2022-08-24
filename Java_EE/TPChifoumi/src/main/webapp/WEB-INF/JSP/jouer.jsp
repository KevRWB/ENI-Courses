<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="style/style.css" rel="stylesheet" type="text/css">
	<title>Chifoumi - Jeu</title>
</head>
<body>

	<%
		String coupIa = (String)request.getAttribute("valIa");
		String coupUser = (String)request.getAttribute("valUser");
		String result = (String)request.getAttribute("result");
		int coupGagnantIa = (int)request.getAttribute("coupGagnantIa");
		int coupGagnantUser = (int)request.getAttribute("coupGagnantUser");
		int victoiresUser = (int)request.getAttribute("victoiresUser");
		int victoiresIa = (int)request.getAttribute("victoiresIa");
		int nbParties = (int)request.getAttribute("nbParties");
		String imgResult = (String)request.getAttribute("urlImgResult");
	%>
	
	<header>
		<h1>Chifoumi</h1>
	</header>
	
	<div class="ligneStats">
		<div>
			<h2 id = "nbParties">Partie numero <%=nbParties %></h2>	
		</div>
		<div class="stats">
		<h3>Coups gagnants joueur : <%=coupGagnantUser %></h3>
		<h3>Coups gagnants IA : <%=coupGagnantIa %></h3>
		<h3>Victoires joueur : <%=victoiresUser %></h3>
		<h3>Victoires IA : <%=victoiresIa %></h3>
		</div>
	</div>
	
	<h2>Que voulez-vous jouer ?</h2>
	
	<form action="Traitement"  method="post">
		 <div>
		    <input type="radio" id="pierre"
		     name="chifumi" value="pierre" checked="checked">
		    <label id="pierre" for="pierre"></label>
		
		    <input type="radio" id="feuille"
		     name="chifumi" value="feuille">
		    <label id="feuille" for="feuille"></label>
		
		    <input type="radio" id="ciseaux"
		     name="chifumi" value="ciseaux">
		    <label id="ciseaux" for="ciseaux"></label>
		  </div>
		  <br>
		  <input type="submit" value="Jouer !">
	</form>
</body>
</html>