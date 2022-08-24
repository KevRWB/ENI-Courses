<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listes Predefinies</title>
</head>
<body>
	<h1>Courses</h1>
	<h2>Listes prédefinies</h2>
	
	<ul>
		<c:forEach var="liste" items = "${listeListes}">
			<li>${liste.nom}       
				<form action="Panier" method="get">
					<input type="hidden" name="idListe" value="${liste.idListe}">
					<input type="submit" value="Panier">
				</form>
				<form action="DeleteListe" method="get">
					<input type="hidden" name="idListe" value="${liste.idListe}">
					<input type="submit" value="Supprimer liste">
				</form>
			</li>
		</c:forEach>
	</ul>
	
	
</body>
</html>