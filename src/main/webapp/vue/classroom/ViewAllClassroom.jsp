<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des salles</title>
</head>
<body>
	<h1>Liste des salles</h1>
	<div>
		Actions : 
		<p><a href="CreationClassroom"><input type="button" value = "Insérer une salle"></a></p>
	</div>
	<div><table border="0">
		<tr>
			<th colspan="3">Identité</th>
			<th colspan="2" rowspan="2">Intéractions</th>
		</tr>
		<tr>
			<th>Nom</th>
			<th>Capacité</th>
			<th>Statut</th>
		</tr>
		<c:forEach items = "${listClassroom}" var = "classroom">
		 <tr>	
		    <td>${classroom.nom }</td>
		    <td>${classroom.nbPlaces }</td>
		    <td>${classroom.statut }</td>
		    <td><a href = "DeleteClassroom?id=${classroom.id }"><input type="button" value = "Supprimer"></td>
		    <td><a href = "UpdateClassroom?id=${classroom.id }"><input type="button" value = "Modifier"></a></td>
		  </tr>
		 </c:forEach>
	</table></div>
</body>
</html>