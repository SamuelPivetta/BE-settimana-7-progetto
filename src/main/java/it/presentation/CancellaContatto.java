package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.business.RubricaEjb;
import it.data.Contatto;

@WebServlet("/delete")
public class CancellaContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	RubricaEjb rejb;
   
    public CancellaContatto() {
        super();
        
    }




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id")) ;		
		Contatto c = new Contatto();
		c.setId(id);
		
		rejb.elimina(c);
	}

}
