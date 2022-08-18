<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/style/style.css" rel="stylesheet">
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
	%>
	
	<h1>Chifoumi</h1>
	
	<h2>Partie numero <%=nbParties %></h2>

	<h2>Resultat :</h2>
	
	<h3>Votre coup : <%=coupUser %></h3>
	<h3>Coupe de l'IA : <%=coupIa %></h3>
	
	<h2><%=result %></h2>
	
	<h3>Coups gagnants joueur : <%=coupGagnantUser %></h3>
	<h3>Coups gagnants IA : <%=coupGagnantIa %></h3>
	
	<h3>Victoires joueur : <%=victoiresUser %></h3>
	<h3>Victoires IA : <%=victoiresIa %></h3>
	
	
	<form action="Traitement" method="GET">
   	 <input type="submit" value="Rejouer" />
	</form>
</body>
</html>