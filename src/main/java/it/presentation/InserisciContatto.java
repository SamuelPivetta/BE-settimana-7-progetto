package it.presentation;

import jakarta.ejb.EJB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


import it.business.RubricaEjb;
import it.data.Contatto;
import it.data.NumTelefono;



@WebServlet("/insert")
public class InserisciContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	RubricaEjb rejb;
	
    public InserisciContatto() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto contatto = new Contatto();	
		NumTelefono n1 = new NumTelefono();
		NumTelefono n2 = new NumTelefono();
		ArrayList<NumTelefono> numeri = new ArrayList<NumTelefono>();
		numeri.add(n1);
		numeri.add(n2);
		contatto.setNome(request.getParameter("nome"));
		contatto.setCognome(request.getParameter("cognome"));
		contatto.setEmail(request.getParameter("email"));
		n1.setNumTelefono(request.getParameter("numero1"));
		n2.setNumTelefono(request.getParameter("numero2"));
		contatto.setNumTelefoni(numeri);
		
		n1.setContatto(contatto);
		n2.setContatto(contatto);
		rejb.insertContatto(contatto);
		
	}

}
