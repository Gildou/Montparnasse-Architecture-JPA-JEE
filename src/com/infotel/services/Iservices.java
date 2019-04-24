package com.infotel.services;

import java.util.List;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public interface Iservices {
	
	public int ajouterPersonne(Personne p);
	public Personne getPersonneSuppr(int idPersonne);
	public Personne getPersonneAff(int idPersonne);
	public int supprimerPersonne(Personne p);
	public int modifierPersonne(Personne p);
	public List<Personne> findAllPersonne();
	public List<Personne> rechercherParMC(String mc);
	public List<Personne> findAllPersonnesConnexion();
	public List<Personne> findAllPersonnesAdresse();
	
	public int ajouterAdresse(Adresse a);
	public Adresse getAdresseSuppr(int idAdresse);
	public Adresse getAdresseAff(int idAdresse);
	public int supprimerAdresse(Adresse a);
	public int modifierAdresse(Adresse a);
	public List<Adresse> findAllAdresse();
	public List<Adresse> rechercherParMCAdresse(String mca);
	
	public int ajouterConnexion(Connexion c);
	public Connexion getConnexionSuppr(int idConnexion);
	public Connexion getConnexionAff(int idConnexion);
	public int supprimerConnexion(Connexion c);
	public int modifierConnexion(Connexion c);
	public List<Connexion> findAllConnexion();
	public List<Connexion> rechercherParMCConnexion(String mcc);

}
