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
				<li><a href="GestionVirement" class="menu">Virements</a></li>
				<li><a href="Autentification?log=logout" class="menu">D&eacute;connection</a></li>
			</ul>
		</div>
		<div class="col" id="c_center">
			<c:choose>
				<c:when test="${displayOK}">
					<h3 class="message Ok">${msg}</h3>
					<table>
						<tr>
							<th>Nom</th>
							<th>Num&eacute;ro de Compte</th>
							<th>Solde</th>
						</tr>
						<c:forEach items="${clientList}" var="client">
							<%-- 							<c:if --%>
							<%-- 								test="${client.compteCourant ne Empty || client.compteEpargne ne Empty}"> --%>
							<tr>
								<td rowspan="2">${client.prenom}&nbsp;${client.nom}</td>

								<td>Compte courant: ${client.compteCourant.numeroCompte} <c:if
										test="${client.compteCourant eq Empty }">
										<strong>aucun</strong>
									</c:if></td>
								<td>${client.compteCourant.solde}<c:if
										test="${client.compteCourant eq Empty }">
										<strong>néant</strong>
									</c:if></td>

								<td rowspan="2"><div class="button">
										<a class="tables button"
											href="ViewDetailsClient?idClient=${client.idClient}">D&eacute;tails</a>
									</div></td>
							</tr>
							<tr>
								<%-- 								<c:if test="${client.compteEpargne ne Empty }"> --%>
								<td>Compte &eacute;pargne:
									${client.compteEpargne.numeroCompte}<c:if
										test="${client.compteEpargne eq Empty }">
										<strong>aucun</strong>
									</c:if>
								</td>
								<td>${client.compteEpargne.solde}<c:if
										test="${client.compteEpargne eq Empty }">
										<strong>néant</strong>
									</c:if>
								</td>
								<%-- 								</c:if> --%>
							</tr>
							<%-- 							</c:if> --%>
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
			<p>Liste des clients présents dans votre portefeuille. Cliquer
				sur "D&eacute;tails" pour voir la liste des comptes du client</p>
			<p>Les clients qui n'ont pas encore de comptes sont
				affich&eacute;s avec des lignes vides.</p>
		</div>
	</div>
	<div id="footer">&copy;Proxy Banque</div>
</body>
</html>