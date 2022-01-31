package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import it.business.RubricaEjb;
import it.data.Contatto;
import it.data.NumTelefono;


@WebServlet("/cercacognome")
public class CercaCognome extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	@EJB
	RubricaEjb rejb;
  
    public CercaCognome() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cognome = request.getParameter("cognome");
		
		List<Contatto> lista = rejb.getContattoByCognome(cognome);
		
		
		
		for (Contatto c : lista) {
			ArrayList<NumTelefono> numTelefoni = c.getNumTelefoni();
			out.print("<h3>"+"Dati Contatto : "+"</h3>");
			out.println("<h4>"+"Nome : " + c.getNome()+ "<br>" + "Cognome :" + c.getCognome() + "<br>"+"</h4>");
			 out.print("<h3>"+"Contatti telefonici : "+"</h3>");
			for(NumTelefono n : numTelefoni) {
				out.print("<h4>"+n.getNumTelefono()+" " +"</h4>");
				
				}

			}
		}
	
}
	
