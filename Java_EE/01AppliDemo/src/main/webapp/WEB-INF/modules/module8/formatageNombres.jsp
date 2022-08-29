<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formatage des nombres</title>
</head>
<body>
		
	

	<h2>Résultat de la division 125/35</h2>
	<p>
		Avec 2 chiffres exactement après la virgule :
		<fmt:formatNumber
			type="number"
			value="${125/35}"
			maxFractionDigits="2"
			minFractionDigits="2">
		</fmt:formatNumber>
	</p>
	
	<fmt:setLocale value="en_GB"/>
	
	<h2>Résultat de la division 125/35 en currency locale</h2>
	<p>
		Avec 2 chiffres exactement après la virgule :
		<fmt:formatNumber
			type="currency"
			value="${125/35}"
			maxFractionDigits="2"
			minFractionDigits="2">
		</fmt:formatNumber>
	</p>
	
	<h2>Résultat de la division 125/35 en %</h2>
	<p>
		Avec 2 chiffres exactement après la virgule :
		<fmt:formatNumber
			type="percent"
			value="${125/35}"
			maxFractionDigits="2"
			minFractionDigits="2">
		</fmt:formatNumber>
	</p>
</body>
</html>