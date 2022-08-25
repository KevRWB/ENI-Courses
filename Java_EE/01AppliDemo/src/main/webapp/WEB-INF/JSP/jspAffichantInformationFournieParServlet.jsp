<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp recevant informations</title>
</head>
<body>
	<h1>Attributs :</h1>
	<%
		String text = (String)request.getAttribute("chaine");
	%>
	<%= text %>
	
	<h2>Date du jour :</h2>
	<%
		Date today = (Date)request.getAttribute("Today");
	%>
	<p></p><%=today %>


</body>
</html>