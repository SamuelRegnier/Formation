<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle salle</title>
</head>
<body>
 <h1 class="copy">Rentrer les informations concernant la salle :</h1>
    <form action="/ProjetFilRouge/InsertedClassroom?id=${param.id }" method=post>
        <!-- Input field for name -->
        <label for="nom">Nom : </label>
        <input id="nom" name="nom" pattern=".{2,}" value=${classroom.nom}  required>
        
        
        <label for="nbPlaces">Capacité : </label>
        <input type="number" id="nbPlaces" name="nbPlaces" value=${classroom.nbPlaces} required>
        
        
        <label for="statut">Statut : </label>
        <input id="statut" name="statut" pattern=".{2,}" value=${classroom.statut} required>
        
        <input type="submit" value="Valider"><input type="reset" value="Réinitialiser">
		<a href="GetAllClassroom"><input type="button" value = "Retour"></a>
	</form>
</body>
