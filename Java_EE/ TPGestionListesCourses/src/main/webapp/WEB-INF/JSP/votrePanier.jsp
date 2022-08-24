<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Votre panier</title>
</head>
<body>
	<h1>Courses</h1>
	<h2>Votre panier</h2>
	<h2>Nom de la liste : ${nomList}</h2>
	
	<ul>
		<c:forEach var="article" items="${listeArticles}">
				<li>${article.nom}</li>	
		</c:forEach>	
	</ul>
	
	<form action="ListesPredefinies" method="POST">
		<input type="submit" value="Retour liste prédéfinies">
	</form>
</body>
</html>