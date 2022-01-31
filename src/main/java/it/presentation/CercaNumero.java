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

@WebServlet("/cercanumero")
public class CercaNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@EJB
	RubricaEjb rejb;
    public CercaNumero() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String numero = request.getParameter("numero");
		List<Contatto> lista = rejb.getContattoByNumero(numero);
		for (Contatto c : lista) {
			out.print("<h2>"+"Dati Contatto : "+"</h2>");
			out.println("<h2>Nome : " + c.getNome()+ "<br>" + "Cognome :" + c.getCognome() + "<br>" + "</h2>");
			ArrayList<NumTelefono> numTelefoni = c.getNumTelefoni();
			for(NumTelefono n : numTelefoni) {
				out.println("<h2>Numero  : "+n.getNumTelefono()+"</h2>");
			}
			}
		 	 ;
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
