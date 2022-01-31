package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import it.business.RubricaEjb;
import it.data.Contatto;

@WebServlet("/update")
public class AggiornaContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	RubricaEjb rejb;
   
    public AggiornaContatto() {
        super();
        
    }




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
		Integer idCont = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String numero1 = request.getParameter("numero1");
		String numero2 = request.getParameter("numero2");
		
		rejb.aggiornaContatto(idCont, numero1, numero2, nome, cognome, email);
		out.println("<h1>Contatto aggiornato con successo</h1>");
	}

}