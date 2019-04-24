package com.infotel.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

@Entity

public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdresse;

	private String nomRue;
	private int numRue;
	private String Ville;
	// private String Cp;

	@OneToMany(mappedBy = "adresse") // On met l'attribut adresse de la classe Personne
	private List<Personne> personnes = new ArrayList<Personne>(); // parce que c'est une relation Many(classe Personne)
																	// to One (classe Adresse)

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", nomRue=" + nomRue + ", numRue=" + numRue + ", Ville=" + Ville
				+ "]";
	}

	@PreRemove
	public void deleteNull() {
		for (Personne p : personnes) {
			p.setAdresse(null);
		}
	}

}
