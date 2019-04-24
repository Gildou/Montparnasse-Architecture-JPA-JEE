<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<title>Drop DOWNS BDD</title>
</head>
<body>


	<div class="container">
		<h2>Rentrez vos informations</h2>
		<form action="ServletPersonne">
			<div class="form-group">
				<input type="hidden" name="id" value="${id}" /> <label for="email">Nom:</label>
				<input type="text" class="form-control" id="lastname"
					placeholder="Entrer votre nom" name="nom" value="${nom}">
			</div>
			<div class="form-group">
				<label for="pwd">Prenom:</label> <input type="text"
					class="form-control" id="firstname"
					placeholder="Entrer votre prenom" name="prenom" value="${prenom}">
			</div>

			<div class="form-group">
				<label for="pwd">Age:</label> <input type="text"
					class="form-control" id="age" placeholder="Entrer votre age"
					name="age" value="${age}">
			</div>
			
			<div class="form-group">
				<label for="pwd">Login:</label> <input type="text"
					class="form-control" id="login" placeholder="Entrer votre login"
					name="login" value="${login}" required>
			</div>
			
			<div class="form-group">
				<label for="pwd">Mot de passe:</label> <input type="password"
					class="form-control" id="mdp" placeholder="Entrer votre mdp"
					name="mdp" value="${mdp}" required>
			</div>

			<span class="btn">Adresse</span> 
				<select name="idAdresses">
					<optgroup>
						<option value="0">---</option>
						<c:if test="${! empty adresses}">
							<c:forEach items="${adresses}" var="a">
								<option value="${a.idAdresse}"><c:out
										value="${a.numRue},${a.nomRue},${a.ville}"></c:out></option>
							</c:forEach>
						</c:if>
					</optgroup>
				</select>
				<br>
				<br>
				
			<button type="submit" class="btn btn-primary" name="ajouter"
				value="Ajouter">Envoyez</button>
			<button type="submit" class="btn btn-primary" name="modifier"
				value="Modifier">Modifier</button>

				<br>
				<br>

		</form>
	</div>






	<div class="container">
		<h2>Personnes Inscris</h2>
		<p>Ici sont réuni les noms des personnes en BDD</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>PRENOM</th>
					<th>NOM</th>
					<th>AGE</th>
					<th>ADRESSE</th>

				</tr>
			</thead>
			<tbody>

				<c:if test="${! empty personnes }">
					<c:forEach items="${ personnes }" var="x">
						<tr>
							<td><c:out value="${ x.id }" /></td>

							<td><c:out value="${ x.nom }" /></td>

							<td><c:out value="${ x.prenom }" /></td>

							<td><c:out value="${ x.age }" /></td>
							
							<td><c:out value="${x.adresse.numRue} ${x.adresse.nomRue} ${x.adresse.ville}" /></td>

							<td><a href="ModifierPersonne?id=${x.id}" />Modifier</td>

							<td><a href="SupprimerPersonne?id=${x.id}" />Supprimer</td>


						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</body>
</html>