<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue sur ProxyBanque</title>
<link rel="stylesheet" href="./style/style.css" />
</head>
<body>
	<div id="header">
		<h1 id="titre">Votre Agence Proxy Banque</h1>
	</div>
	<div id="content">
		<div class="col" id="c_menu">
			<ul>
				<li><a href="./" class="menu">Accueil</a></li>
				<li><a href="" class="menu">Auditer</a></li>
				<li><a href="Autentification?log=logout" class="menu">D&eacute;connection</a></li>
			</ul>
		</div>
		<div class="col" id="c_center">
			<c:choose>
				<c:when test="${displayOK}">
					<h3 class="message Ok">${msg}</h3>
					<table>
						<tr>
							<th>Conseiller</th>
							<th>type</th>
							<th>d&eacute;tails</th>
						</tr>
						<c:forEach items="${conseillersList}" var="conseillers">
							<tr>
								<td>${conseillers.prenom}&nbsp;${conseillers.nom}</td>

								<td>${conseillers.typeConseiller}</td>

								<td>
									<div class="button">
										<a class="tables button"
											href="ViewConseillerServlet?idCons=${conseillers.idConseiller}">
											Listes des Clients</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h3 class="message Erreur">${msg}</h3>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col" id="c_aside">
			<h3>${user},</h3>
			<p>Liste des conseillers présents dans votre portefeuille.
				Cliquer sur "Listes Clients" pour voir la liste des clients d'un
				conseiller</p>
		</div>
	</div>
	<div id="footer">&copy;Proxy Banque</div>
</body>
</html>