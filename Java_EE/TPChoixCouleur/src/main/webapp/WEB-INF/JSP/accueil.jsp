<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil TP couleur</title>
<%
String couleurSession =(String)session.getAttribute("couleurSession");
%>
<style>
	*{
	color : "color : <%=couleurSession %>"
	}
</style>
</head>
<body style="color : <%=couleurSession %>">
	<h1>Accueil TP couleur</h1>
	
	<h2>Compteur de d'accès à la session :</h2>

	<form action="traitementCouleur" method="POST">
	<label for="colorChoice">Choisissez une couleur:</label>

	<select name="colorChoice" id="colorChoice">
	    <option value="">--Choissiez une couleur--</option>
	    
	    <%
	    String[] listColors = (String[]) request.getAttribute("colorList");
	    for(String couleur : listColors){
	    	%>
	    	<option value="<%=couleur%>" <%=couleur.equals(couleurSession) ? "selected" : "" %> ><%=couleur%></option>
	    	<% 
	    }
	    %>
	</select>
	
	<input type="submit" value="valider">
	</form>
</body>
</html>