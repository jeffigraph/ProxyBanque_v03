package com.proxybanque_KO_JFA.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.entity.Conseiller;
import com.proxybanque_KO_JFA.services.ServiceEngine;

/**
 * Gere l'autentification d'un conseiller avec creation d'une session assurant
 * la permanence de la connection
 * 
 * Servlet implementation class AutentificationServlet
 */
@WebServlet("/Autentification")
public class AutentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// attention a remlpacer par le ServiceEngine correspondant
	// private ServiceLogin srvLogin = new ServiceLogin(new DaoAgenceMySQL(), new
	// DaoClientMySQL());
	private ServiceEngine srvcEng = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutentificationServlet() {
		super();
		try {
			srvcEng = new ServiceEngine();
		} catch (DaoPersistanceException ex) {
			System.out.println("AutentificationServlet : " + ex.getMessage());
		}
	}

	/**
	 * Permet la deconnexion de la session sur la demande de l'utilisateur ou
	 * demande de se reconnecter s'il s'est produit une erreur
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String log_msg = request.getParameter("log");

		HttpSession session = request.getSession(false);
		if (session != null) {
			if ("logout".equals(log_msg)) {
				session.invalidate();
				response.sendRedirect("./");
			} else if ("login".equals(log_msg)) {
				request.setAttribute("displayOK", true);
				request.setAttribute("msg", "Veuillez entrer vos identifiants conseiller");
				request.getRequestDispatcher("Autentification.jsp").forward(request, response);
			} else {
				session.invalidate();
				request.setAttribute("displayOK", false);
				request.setAttribute("msg", "une erreur c'est produite veuillez vous reconnecter");
				request.getRequestDispatcher("Autentification.jsp").forward(request, response);
			}
		}
		if (session == null) {
			request.setAttribute("displayOK", true);
			request.setAttribute("msg", "Veuillez entrer vos identifiants conseiller");
			request.getRequestDispatcher("Autentification.jsp").forward(request, response);
		}
	}

	/**
	 * Gerer le damande d'identification d'un utilisateur recupere les identifiants
	 * de connexion envoyes avec une methode POST s'il n'y a pas de Conseiller
	 * correspondant dans la base, renvoie a la page de saisie des identifiants avec
	 * un message d'erreur
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (login != null && password != null) {
			try {
				Conseiller cons = srvcEng.getServiceLogin().login(login, password);
				if (cons != null) {

					HttpSession session = request.getSession();

					session.setAttribute("user", cons.getPrenom() + " " + cons.getNom());
					// session.setAttribute("idConseiller", cons.getIdConseiller());
					session.setAttribute("idCons", cons.getIdConseiller());
					request.setAttribute("typeConse", cons.getTypeConseiller());

					request.setAttribute("displayOK", true);
					request.setAttribute("msg", "Vous etes bien connectes");
					
					//System.out.println("Authtification : doPost "+cons.getTypeConseiller() + " "+ cons.getNom());
					if (cons.getTypeConseiller().equals(Conseiller.TYPECONSEILLER)) {
						request.getRequestDispatcher("./ViewClients").forward(request, response);
					} else {
						request.getRequestDispatcher("./ViewConseillers").forward(request, response);
					}
				}
			} catch (DaoPersistanceException ex) {
				request.setAttribute("displayOK", false);
				request.setAttribute("msg", "Echec de l'identification");
				request.getRequestDispatcher("Autentification.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("displayOK", false);
			request.setAttribute("msg", "Vous devez entrer des identifiants");
			request.getRequestDispatcher("Autentification.jsp").forward(request, response);
		}
	}

}
