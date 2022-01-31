package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import it.business.RubricaEjb;
import it.data.Contatto;



@WebServlet("/mostracontatti")
public class MostraContatti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@EJB
	RubricaEjb rejb;
    public MostraContatti() {
        super();
      
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Object[]> listaContatti = rejb.getAllContatti();
		for (Object[] obj : listaContatti) {
			out.println("NOME:" + obj[0]
			+ "<br>" + "COGNOME: " + obj[1]
		    + "<br>" + "E-MAIL: " +obj[2] 
			+"<br>" + "NUMERO TELEFONICO: "+  obj[3]+ "<hr style=\"height:2px\">");
		}
	}
}
