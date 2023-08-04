<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Utilisateur</title>
</head>
<body>
	<h1>Informations utilisateur</h1>
		<h3>Nom : ${user.nom}</h3>
		<h3>Prénom : ${user.prenom}</h3>
		<h3>Date de naissance : ${user.dateNaissance}</h3>
		<h3>adresse : ${user.adresse}</h3>
		<h3>mail : ${user.mail}</h3>
		<h3>telephone : ${user.telephone}</h3>
		<h3>statut : ${user.statut}</h3>
	<a href="/ProjetFilRouge/users">Retour</a>
</body>
</html>