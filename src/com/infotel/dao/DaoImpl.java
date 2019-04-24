package com.infotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class DaoImpl implements Idao {

	// Unité de persitence - Pour Créer l'autoroute (mais c'est juste une
	// déclaration là)
	EntityManagerFactory emf;

	// Porteur de reqûete à travers l'autoroute
	EntityManager em;

	@Override
	public int ajouterPersonne(Personne p) {
		// 0- Ouverture unité de persistence et transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction(); // la transaction c'est quand je créer une voie dans mon autoroute

		try {
			// 1- Débuter la transaction
			tx.begin();
			// 2- Effectuer la requête
			em.persist(p);
			// 3- Valider la transaction
			tx.commit();
			// 4- Fermer l'unité de persitence
			em.close();
			emf.close();
		} catch (Exception e) {
			// S'il y a une erreur dans le try, on annule la transaction
			tx.rollback();
		}

		return 0;
	}

	public Personne getPersonneSuppr(int idPersonne) {
		// 0- Ouverture unité de persistence et transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Personne p = null;

		try {
			// p = em.find(Personne.class, idPersonne); autre méthode pour get une personne.
			// Celle ci récupère mais détache de la BDD
			p = em.getReference(Personne.class, idPersonne);
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	public Personne getPersonneAff(int idPersonne) {
		// 0- Ouverture unité de persistence et transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Personne p = null;

		try {
			p = em.find(Personne.class, idPersonne);
			// p = em.getReference(Personne.class, idPersonne);
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	@Override
	public int supprimerPersonne(Personne p) {
		// 0- Ouverture unité de persistence et transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// 1- Débuter la transaction
			tx.begin();
			// 2- Effectuer la requête
			em.remove(p);
			// 3- Valider la transaction
			tx.commit();
			// 4- Fermer l'unité de persitence
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return 0;
	}

	@Override
	public int modifierPersonne(Personne p) {
		// 0- Ouverture unité de persistence et transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// 1- Débuter la transaction
			tx.begin();
			// 2- Effectuer la requête
			em.merge(p);
			// 3- Valider la transaction
			tx.commit();
			// 4- Fermer l'unité de persitence
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<Personne> findAllPersonne() {
		// 0- Ouverture unité de persistence
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q = em.createQuery("SELECT p FROM Personne AS p"); // le "AS" est pas obligatoire
			l = q.getResultList();
			em.close();
			emf.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}

	@Override
	public List<Personne> rechercherParMC(String mc) {
		// 0- Ouverture unité de persistence
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q = em.createQuery("SELECT p FROM Personne AS p WHERE nom like :lenom"); // le ":lenom" est à prendre comme
																						// le "?"
			q.setParameter("lenom", "%" + mc + "%");
			l = q.getResultList();
			em.close();
			emf.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}

	@Override
	public List<Personne> findAllPersonnesConnexion() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q = em.createQuery("SELECT p FROM Personne p join p.connexion"); 
			l = q.getResultList();
			em.close();
			emf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	

	@Override
	public List<Personne> findAllPersonnesAdresse() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q = em.createQuery("SELECT p FROM Personne p right join p.adresse"); 
			l = q.getResultList();
			em.close();
			emf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public int ajouterAdresse(Adresse a) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction(); // la transaction c'est quand je créer une voie dans mon autoroute

		try {
			tx.begin();
			em.persist(a);
			tx.commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			tx.rollback();
		}

		return 0;
	}

	@Override
	public Adresse getAdresseSuppr(int idAdresse) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Adresse a = null;
		try {
			a = em.getReference(Adresse.class, idAdresse);
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return a;
	}

	@Override
	public Adresse getAdresseAff(int idAdresse) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Adresse a = new Adresse();

		try {
			a = em.find(Adresse.class, idAdresse);
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(a);
			tx.commit();
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int modifierAdresse(Adresse a) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(a);
			tx.commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Adresse> findAllAdresse() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Adresse> l = new ArrayList<Adresse>();
		try {
			q = em.createQuery("SELECT a FROM Adresse AS a");
			l = q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return l;
	}

	@Override
	public List<Adresse> rechercherParMCAdresse(String mca) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Adresse> l = new ArrayList<Adresse>();
		try {
			q = em.createQuery("SELECT a FROM Adresse AS a WHERE nomRue like :lenom");
			q.setParameter("lenom", "%" + mca + "%");
			l = q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return l;
	}

	@Override
	public int ajouterConnexion(Connexion c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction(); // la transaction c'est quand je créer une voie dans mon autoroute

		try {
			tx.begin();
			em.persist(c);
			tx.commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			tx.rollback();
		}

		return 0;
	}

	@Override
	public Connexion getConnexionSuppr(int idConnexion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Connexion c = null;
		try {
			c = em.getReference(Connexion.class, idConnexion);
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return c;
	}

	@Override
	public Connexion getConnexionAff(int idConnexion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Connexion c = null;

		try {
			c = em.find(Connexion.class, idConnexion);
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return c;
	}

	@Override
	public int supprimerConnexion(Connexion c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(c);
			tx.commit();
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int modifierConnexion(Connexion c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(c);
			tx.commit();
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public List<Connexion> findAllConnexion() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Connexion> l = new ArrayList<Connexion>();
		try {
			q = em.createQuery("SELECT c FROM Connexion AS c");
			l = q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return l;
	}

	@Override
	public List<Connexion> rechercherParMCConnexion(String mcc) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Connexion> l = new ArrayList<Connexion>();
		try {
			q = em.createQuery("SELECT c FROM Connexion AS c WHERE login like :lenom");
			q.setParameter("lenom", "%" + mcc + "%");
			l = q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {

		}
		return l;
	}

}
