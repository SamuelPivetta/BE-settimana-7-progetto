package it.business;



import java.util.List;

import org.apache.openjpa.jdbc.kernel.exps.ToUpperCase;

import it.data.Contatto;
import it.data.NumTelefono;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
@LocalBean
public class RubricaEjb {

	@PersistenceContext(unitName="rubricaPS")
	EntityManager em;
    public RubricaEjb() {
       
    }
    
    
    public Contatto insertContatto(Contatto c) {
    	em.persist(c);
    	return c;
    }
    
    
    public Contatto getIdContatto(int id) {
    	return em.find(Contatto.class, id);
    	
    }
    public void elimina(Contatto c) {
    	em.remove(getIdContatto(c.getId()));
    }
    public List<Object[]> getAllContatti(){
		String sql ="SELECT c.nome, c.cognome, c.email, n.numTelefono FROM Contatto c JOIN NumTelefono n ON "
    			+ " c.contatto = n.contatto"
    			+ "  WHERE NOT n.numTelefono =''";
		Query q = em.createQuery(sql);
		List<Object[]> listaContatti = q.getResultList();
    	return listaContatti;
}
    
    public List<Contatto> getContattoByCognome(String cognome) {
    
    	
    	String sql ="SELECT distinct c from Contatto c join c.numTelefoni n where c.cognome like :cognome";
    	Query q = em.createQuery(sql);
    	q.setParameter("cognome", "%" + cognome + "%");
    	
    	List<Contatto> contatti = q.getResultList();
    	for(Contatto i : contatti) {
    		System.out.println(i.getNome()+" " + i.getCognome());
    	}
    	return contatti;
    }
    public List<Contatto> getContattoByNumero(String numero) {
    	String sql ="SELECT c from Contatto c join c.numTelefoni n where n.numTelefono like :numTelefono";
    	Query q = em.createQuery(sql);
    	q.setParameter("numTelefono", "%" + numero + "%");
    	List<Contatto> contatti = q.getResultList();
    	for(Contatto i : contatti) {
    		System.out.println(i.getNome() +" " + i.getCognome());
    	}
    	return contatti;
    }
    public void aggiornaContatto(int id, String n1, String n2, String nome, String cognome, String email) {
    	Contatto c = em.find(Contatto.class, id);
    	if(c== null) {
    		c = new Contatto();
    		c.setId(id);
    	}
    	c.setNome(nome);
    	c.setCognome(cognome);
    	c.setEmail(email);
    
    	if(!n1.isEmpty()) {
    		NumTelefono numero1= new NumTelefono();
    		numero1.setContatto(c);
    		numero1.setNumTelefono(n1);
    		c.getNumTelefoni().add(numero1);
    	}
    	if(!n2.isEmpty()) {
    		NumTelefono numero2= new NumTelefono();
    		numero2.setContatto(c);
    		numero2.setNumTelefono(n2);
    		c.getNumTelefoni().add(numero2);
    	}
    	em.merge(c);
    }
}