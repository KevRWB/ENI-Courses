<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formatage des dates</title>
</head>
<body>

	<h2>L'heure en France</h2>
	<p>
		Affichage de la date actuelle avec la langue par défaut :
		<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" dateStyle="full"/>
	</p>
	<p>
		Affichage de l'heure actuelle avec la langue par défaut :
		<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" type="time" timeStyle="short"/>
	</p>
	
	<p>
		Affichage de la date atuelle avec la langue anglaise :
		<fmt:setLocale value="en"/>
		<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" dateStyle="full"/>
	</p>
	<p>
		Affichage de l'heure actuelle avec la langue anglaise :
		<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" type="time" timeStyle="short"/>
	</p>
	
	<h2>L'heure à New York</h2>
	<fmt:timeZone value="America/New_York">
		<p>
			<fmt:setLocale value="es"/>
			Affichage de l'heure actuelle avec la langue espagnole dans le fuseau horaire de New York:
			<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" dateStyle="full"/>
		</p>
		<p>
			Affichage de l'heure actuelle avec la langue espagnole dans le fuseau horaire de New York:
			<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" type="time" timeStyle="short"/>
		</p>
	</fmt:timeZone>
	
</body>
</html>