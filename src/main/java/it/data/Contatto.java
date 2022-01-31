 package it.data;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Table(name="contatto")
@Entity
 public class Contatto implements Serializable{
	
 private static final long serialVersionUID = 1L;
 
	 private int id;
	 private String nome;
	 private String cognome;
	 private String email;
	 private ArrayList<NumTelefono> numTelefoni;
	 
	 
 
 
	public Contatto() {
	}
	public Contatto(int id, String nome, String cognome, String email,ArrayList<NumTelefono> numTelefoni) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.numTelefoni = numTelefoni;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="cognome")
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(mappedBy="contatto",cascade = CascadeType.ALL)
	@JoinColumn(name="numero_telefono")
	public ArrayList<NumTelefono> getNumTelefoni() {
		return numTelefoni;
	}
	public void setNumTelefoni(ArrayList<NumTelefono> numTelefoni) {
		this.numTelefoni = numTelefoni;
	}
	

	
	
	
	

}
