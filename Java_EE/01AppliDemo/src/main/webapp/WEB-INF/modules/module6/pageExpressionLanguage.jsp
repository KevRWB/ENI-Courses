<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP - test Expression language EL</title>
</head>
<body>
	<h1>Page affichant une voiture (si elle existe)</h1>
	
	<ul>
		<li>Marque : ${voiture.marque}</li>
		<li>Modèle : ${voiture.modele}</li>
		<li>Immatriculation : ${voiture.immatriculation}</li>
		<li>Kilometrage : ${voiture.kilometrage}</li>
	</ul>
	
	<h2>Ma voiture à moi :</h2>
	
	<ul>
		<li>Marque : ${sessionScope.voiture.marque}</li>
		<li>Modèle : ${sessionScope.voiture.modele}</li>
		<li>Immatriculation : ${sessionScope.voiture.immatriculation}</li>
		<li>Kilometrage : ${sessionScope.voiture.kilometrage}</li>
	</ul>
	
	<h2>parametre</h2>
	<p>clé=${param.cle}</p>
	
</body>
</html>