<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Premiere JSP</title>
</head>

<body>
	<h1>Ceci est ma premiere JSP</h1>
	<h2>Calcul</h2>
	
	<%
	int val1 = 2;
	int val2 = 17;
	int result = val1 * val2;
	%>
	
	<h2>Resultat</h2>
	<p><%=val1%> x <%=val2%> = <%= result %></p>
	<br>
	<a href="demonstration1.html">Retour</a>
	
</body>
</html>