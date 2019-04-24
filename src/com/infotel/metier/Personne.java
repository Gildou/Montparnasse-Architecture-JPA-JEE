package com.infotel.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;

@Entity

/*
 * 1- La m�thode suivante permet de r�unir la classe m�re et ses filles dans une
 * seule table
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // on r�uni la classe m�re et les classes filles dans une m�me
														// temple
@DiscriminatorColumn(name = "TYPE_PERS") // on nomme la colonne de discrimination (la colonne qui trie les personnes
											// dans les 3 cat�gorie (personne, client, employ�))
@DiscriminatorValue("PERS") // on donne le nom de la valeur de discrimination

/* 2- La m�thode d'apr�s, cr�e une table par classe */
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

/* 3- La m�thode utilise une jointure entre les classes */
//@Inheritance(strategy = InheritanceType.JOINED)

public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // dans la m�thode 2 il nous faut �viter de g�n�rer ces valeurs
	private int id;

	private int age;

	@Column(length = 32)
	private String nom;
	private String prenom;

	@ManyToOne //(cascade = { CascadeType.PERSIST })
	private Adresse adresse; // adresse est l'attribut utilis� par le "mappedby" de la classe Adresse

	@OneToOne(cascade = { CascadeType.PERSIST })
	private Connexion connexion;

	@ManyToMany
	private List<Club> clubs = new ArrayList<Club>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Connexion getConnexion() {
		return connexion;
	}

	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

	@Override
	public String toString() {
		return "Personne :[id=" + id + ", age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ "]\n";
	}

}
