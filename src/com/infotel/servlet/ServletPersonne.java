package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;
import com.infotel.services.Iservices;
import com.infotel.services.ServicesImpl;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private Iservices services = new ServicesImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletPersonne() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom;
		String prenom;
		int age;
		int id;
		int idAdresses;
		String login,mdp;

		if (request.getParameter("nom") != null) {

			age = Integer.parseInt(request.getParameter("age"));
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			
			/* La méthode suivante fonctionne mais elle n'est plus nécessaire car j'ai ajouté à 
			 * la balise 'option' de la valeur par défaut '---' la valeur "0"
			 * Le try catch fait plus fonctionner la JVM donc la méthode avec value="0" est plus propre
			try {
				idAdresses = Integer.parseInt(request.getParameter("idAdresses"));
			} catch (Exception e) {
				idAdresses = 0;
			}
			*/
			
			idAdresses = Integer.parseInt(request.getParameter("idAdresses"));
			
			login = request.getParameter("login");
			mdp = request.getParameter("mdp");
			
			// 2- envoyer à la couche service
			Personne p = new Personne();
			p.setAge(age);
			p.setNom(nom);
			p.setPrenom(prenom);
			
			Connexion c = new Connexion();
			c.setLogin(login);
			c.setMdp(mdp);
			p.setConnexion(c);

			if (idAdresses != 0) {
				p.setAdresse(services.getAdresseSuppr(idAdresses));
			}
			
			

			if (request.getParameter("ajouter") != null) {
				services.ajouterPersonne(p);
			} else if (request.getParameter("modifier") != null) {
				id = Integer.parseInt(request.getParameter("id"));
				p.setId(id);
				if (idAdresses != 0) {
					p.setAdresse(services.getAdresseSuppr(idAdresses));
				}
				services.modifierPersonne(p);
			}

		}

		// 3 - Preparation a l'envoi à JSP
		request.setAttribute("personnes", services.findAllPersonne());
		request.setAttribute("adresses", services.findAllAdresse());

		// 4 - Envoi a la JSP
		request.getRequestDispatcher("personnes.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
