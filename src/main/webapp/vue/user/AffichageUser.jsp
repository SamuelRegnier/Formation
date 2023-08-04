<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Utilisateurs</title>
</head>
<body>
	<h1>Affichage des utilisateurs</h1>
	<table>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Date de naissance</th>
			<th>Adresse</th>
			<th>Mail</th>
			<th>Téléphone</th>
			<th>Statut</th>
			<th>Afficher</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.nom}</td>
				<td>${user.prenom}</td>
				<td>${user.dateNaissance}</td>
				<td>${user.adresse}</td>
				<td>${user.mail}</td>
				<td>${user.telephone}</td>
				<td>${user.statut}</td>
				<td><a href="/ProjetFilRouge/user?id=${user.id}">Afficher</a></td>
				<td><a href="/ProjetFilRouge/user/modification?id=${user.id}">Modifier</a></td>
				<td><a href="/ProjetFilRouge/user/suppression?id=${user.id}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/ProjetFilRouge/user/creation">Creation d'un utilisateur</a>
</body>
</html>