<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test JSTL</title>
</head>
<body>
	
	<h1>TEST JSTL</h1>
	
	<c:if test="${voiture != null }">
		<ul>
			<li>Marque : ${voiture.marque}</li>
			<li>Modele : ${voiture.modele}</li>
			<li>Immatriculation : ${voiture.immatriculation}</li>
			<li>kilometrage : ${voiture.kilometrage}</li>
		</ul>
	</c:if>
	
	<c:if test="${voiture == null}">
		<p>Aucune voiture n'est disponible...</p>
	</c:if>
	
	<h2>Ma collection de voitures</h2>
	<p>Il y a ${voitures.size()} voiture${voitures.size()<2 ? "" : "s"}</p>
	
	<p>Il y a ${voitures.size()} <c:if test="${voitures.size()>1 }">voitures</c:if>
								<c:if test="${voitures.size()<=1 }">voiture</c:if>
	</p>
	
	<ul>
		<c:forEach var="v" items = "${voitures}">
			<li>${v.marque} ${v.modele} ${v.immatriculation} ${v.kilometrage}</li>
		</c:forEach>	
	</ul>
	
	
	
</body>
</html>