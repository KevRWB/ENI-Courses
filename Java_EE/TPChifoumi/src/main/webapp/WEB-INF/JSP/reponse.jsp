<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style/style.css" rel="stylesheet">
<title>Reponse</title>
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
	
	<h2>Resultat :</h2>
	
	<h3>Votre coup : <%=coupUser %></h3>
	<h3>Coupe de l'IA : <%=coupIa %></h3>
	
	<h2><%=result %></h2>
	
	<img alt="img_result" src= <%=imgResult %> width="300px" >

	<form action="Traitement" method="GET">
   	 	<input type="submit" value="Rejouer" />
	</form>
</body>
</html>