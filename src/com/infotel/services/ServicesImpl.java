package com.infotel.services;

import java.util.List;

import com.infotel.dao.DaoImpl;
import com.infotel.dao.Idao;
import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class ServicesImpl implements Iservices {

	private Idao dao = new DaoImpl();

	@Override
	public int ajouterPersonne(Personne p) {

		return dao.ajouterPersonne(p);
	}

	@Override
	public Personne getPersonneSuppr(int idPersonne) {
		return dao.getPersonneSuppr(idPersonne);
	}
	
	
	@Override
	public Personne getPersonneAff(int idPersonne) {
		return dao.getPersonneAff(idPersonne);
	}

	@Override
	public int supprimerPersonne(Personne p) {
		return dao.supprimerPersonne(p);
	}

	@Override
	public int modifierPersonne(Personne p) {
		return dao.modifierPersonne(p);
	}

	@Override
	public List<Personne> findAllPersonne() {
		return dao.findAllPersonne();
	}

	@Override
	public List<Personne> rechercherParMC(String mc) {
		return dao.rechercherParMC(mc);
	}

	@Override
	public int ajouterAdresse(Adresse a) {
		return dao.ajouterAdresse(a);
	}

	@Override
	public Adresse getAdresseSuppr(int idAdresse) {
		return dao.getAdresseSuppr(idAdresse);
	}

	@Override
	public Adresse getAdresseAff(int idAdresse) {
		return dao.getAdresseAff(idAdresse);
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		return dao.supprimerAdresse(a);
	}

	@Override
	public int modifierAdresse(Adresse a) {
		return dao.modifierAdresse(a);
	}

	@Override
	public List<Adresse> findAllAdresse() {
		return dao.findAllAdresse();
	}

	@Override
	public List<Adresse> rechercherParMCAdresse(String mca) {
		return dao.rechercherParMCAdresse(mca);
	}
	
	

	@Override
	public List<Personne> findAllPersonnesConnexion() {
		return dao.findAllPersonnesConnexion();
	}
	
	

	@Override
	public List<Personne> findAllPersonnesAdresse() {
		return dao.findAllPersonnesAdresse();
	}

	@Override
	public int ajouterConnexion(Connexion c) {
		return dao.ajouterConnexion(c);
	}

	@Override
	public Connexion getConnexionSuppr(int idConnexion) {
		return dao.getConnexionSuppr(idConnexion);
	}

	@Override
	public Connexion getConnexionAff(int idConnexion) {
		return dao.getConnexionAff(idConnexion);
	}

	@Override
	public int supprimerConnexion(Connexion c) {
		return dao.supprimerConnexion(c);
	}

	@Override
	public int modifierConnexion(Connexion c) {
		return dao.modifierConnexion(c);
	}

	@Override
	public List<Connexion> findAllConnexion() {
		return dao.findAllConnexion();
	}

	@Override
	public List<Connexion> rechercherParMCConnexion(String mcc) {
		return dao.rechercherParMCConnexion(mcc);
	}
	
	

	
	
}
