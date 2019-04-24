package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.services.Iservices;
import com.infotel.services.ServicesImpl;

/**
 * Servlet implementation class ModifierServlet
 */
@WebServlet("/ModifierPersonne")
public class ModifierPersonne extends HttpServlet {
	private Iservices services = new ServicesImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Personne p = services.getPersonneAff(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("id", p.getId());
		request.setAttribute("nom", p.getNom());
		request.setAttribute("prenom", p.getPrenom());
		request.setAttribute("age", p.getAge());
		
		request.setAttribute("personnes", services.findAllPersonne());
		request.setAttribute("adresses", services.findAllAdresse());
		
		request.getRequestDispatcher("personnes.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
