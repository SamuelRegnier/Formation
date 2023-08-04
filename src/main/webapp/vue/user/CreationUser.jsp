<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creation User</title>
</head>
<body>
	<h1>Formulaire de création utilisateur</h1>
	<form method="post" action="creation">
		<div>
			<label for="name">Nom :</label>
			<input type="text" id="name" name="name" placeholder="Votre nom">
		</div>
		<div>
			<label for="firstname">Prénom :</label>
			<input type="text" id="firstname" name="firstname" placeholder="Votre prénom">
		</div>
		<div>
			<label for="birthday">Date de naissance :</label>
			<input type="date" id="birthday" name="birthday" placeholder="Votre date de naissance">
		</div>
		<div>
			<label for="adress">Adresse :</label>
			<input type="text" id="adress" name="adress" placeholder="Votre adresse">
		</div>
		<div>
			<label for="mail">Mail :</label>
			<input type="text" id="mail" name="mail" placeholder="Votre mail">
		</div>
		<div>
			<label for="phone">Téléphone :</label>
			<input type="text" id="phone" name="phone" placeholder="Votre numéro de téléphone">
		</div>
		<div>
			<label for="statut">Statut :</label>
			<input type="text" id="statut" name="statut" placeholder="Votre statut">
		</div>
		<div>
			<button type="submit">Créer</button>
		</div>
	</form>
</body>
</html>