package com.proxybanque_KO_JFA.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoCompte;
import com.proxybanque_KO_JFA.entity.Client;
import com.proxybanque_KO_JFA.entity.Compte;
import com.proxybanque_KO_JFA.entity.CompteCourant;
import com.proxybanque_KO_JFA.entity.CompteEpargne;

public class DaoCompteJPA implements IDaoCompte {

	public DaoCompteJPA() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proxybanque_JFA.dao.IDaoCompte#add(com.proxybanque_JFA.entity.Compte)
	 */
	@Override
	public void add(Compte compte) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			if (CompteCourant.class.isAssignableFrom(compte.getClass())) {
				CompteCourant cc = (CompteCourant) compte;
				em.persist(cc);
			}
			if (CompteEpargne.class.isAssignableFrom(compte.getClass())) {
				CompteEpargne ce = (CompteEpargne) compte;
				em.persist(ce);
			}

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			throw new DaoPersistanceException(e.getMessage(), e.getCause());
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proxybanque_JFA.dao.IDaoCompte#update(com.proxybanque_JFA.entity.Compte)
	 */
	@Override
	public void update(Compte compte) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proxybanque_JFA.dao.IDaoCompte#delete(com.proxybanque_JFA.entity.Compte)
	 */
	@Override
	public void delete(Compte compte) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxybanque_JFA.dao.IDaoCompte#getById(java.lang.String)
	 */
	@Override
	public Compte getById(String numeroCompte) throws DaoPersistanceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxybanque_JFA.dao.IDaoCompte#getAll()
	 */
	@Override
	public List<Compte> getAll() throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		List<Compte> resultList = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<Compte> query = em.createQuery("from Compte c", Compte.class);
			resultList = query.getResultList();
			

			System.out.println("DaoCompteJPA : getAll() : Size of list result = " + resultList.size());
			System.out.println(resultList);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			throw new DaoPersistanceException(e.getMessage(), e.getCause());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return resultList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxybanque_JFA.dao.IDaoCompte#getCCByIdClient(int)
	 */
	@Override
	public CompteCourant getCCByIdClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxybanque_JFA.dao.IDaoCompte#getCEByIdClient(int)
	 */
	@Override
	public CompteEpargne getCEByIdClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proxybanque_JFA.dao.IDaoCompte#updateCCClient(com.proxybanque_JFA.entity.
	 * Client)
	 */
	@Override
	public void updateCCClient(Client c) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proxybanque_JFA.dao.IDaoCompte#updateCErClient(com.proxybanque_JFA.entity
	 * .Client)
	 */
	@Override
	public void updateCEClient(Client c) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proxybanque_JFA.dao.IDaoCompte#updateCompteSolde(com.proxybanque_JFA.
	 * entity.Compte)
	 */
	@Override
	public void updateSolde(Compte c) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

}
