package it.data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="numero")
@Entity
public class NumTelefono implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	private String numTelefono;
	private Contatto contatto;

	@Id
	@Column(name="numero_telefono")
	public String getNumTelefono() {
		return numTelefono;
	}



	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}


	@ManyToOne
	@JoinColumn(name="id")
	public Contatto getContatto() {
		return contatto;
	}



	public void setContatto(Contatto contatto) {
		this.contatto = contatto;
	}

}
