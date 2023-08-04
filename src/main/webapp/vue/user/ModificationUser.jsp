<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Utilisateur</title>
</head>
<body>
<h1>Modification d'un utilisateur</h1>
	<form method="post" action="modification">
		<div>
			<input type="hidden" id="id" name="id" value="${user.id}">
		</div>
		<div>
			<label for="name">Nom :</label>
			<input type="text" id="name" name="name" value="${user.nom}">
		</div>
		<div>
			<label for="firstname">Prénom :</label>
			<input type="text" id="firstname" name="firstname" value="${user.prenom}">
		</div>
		<div>
			<label for="birthday">Date de naissance :</label>
			<input type="date" id="birthday" name="birthday" value="${user.dateNaissance}">
		</div>
		<div>
			<label for="adress">Adresse :</label>
			<input type="text" id="adress" name="adress" value="${user.adresse}">
		</div>
		<div>
			<label for="mail">Mail :</label>
			<input type="text" id="mail" name="mail" value="${user.mail}">
		</div>
		<div>
			<label for="phone">Téléphone :</label>
			<input type="text" id="phone" name="phone" value="${user.telephone}">
		</div>
		<div>
			<label for="statut">Statut :</label>
			<input type="text" id="statut" name="statut" value="${user.statut}">
		</div>
		<div>
			<button type="submit">Modifier</button>
		</div>
	</form>
	<a href="/ProjetFilRouge/users">Retour</a>
</body>
</html>