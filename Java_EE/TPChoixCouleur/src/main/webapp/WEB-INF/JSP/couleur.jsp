<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page en couleur</title>
<style>
	*{
	color : "color : <%=session.getAttribute("couleurSession") %>"
	}
</style>
</head>

<body  style="color : <%=session.getAttribute("couleurSession") %>">
	
	<h1>Page de couleur : </h1>
	
	<p><%=session.getAttribute("couleurSession") %></p>
	
	<form action="traitementCouleur" method="GET">
		<input type = "submit" value="retour accueil">
	</form>
</body>
</html>