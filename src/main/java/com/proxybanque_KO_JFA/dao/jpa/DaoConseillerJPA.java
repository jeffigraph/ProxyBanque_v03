package com.proxybanque_KO_JFA.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoConseiller;
import com.proxybanque_KO_JFA.entity.Conseiller;

public class DaoConseillerJPA implements IDaoConseiller {
	public DaoConseillerJPA() {

	}

	@Override
	public void add(Conseiller conseiller) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.persist(conseiller);

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

	@Override
	public void update(Conseiller conseiller) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Conseiller conseiller) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Conseiller getById(String idConseiller) throws DaoPersistanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conseiller> getAllByAgenceId(int idAgence) throws DaoPersistanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conseiller> getAll() throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		List<Conseiller> resultList = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<Conseiller> query = em.createQuery("from Conseiller", Conseiller.class);
			resultList = query.getResultList();

			System.out.println("DaoConseillerJPA : getAll() : Size of list result = " + resultList.size());
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
	 * @see com.proxybanque_JFA.dao.IDaoConseiller#getByLogin(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Conseiller getByLogin(String login, String password) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Conseiller cb = null;

		try {
			txn.begin();

			TypedQuery<Conseiller> query = em.createQuery(
					"from Conseiller where login = '" + login + "' and password = '" + password + "'",
					Conseiller.class);
			List<Conseiller> resultList = query.getResultList();

			if (resultList != null) {
				System.out.println("DaoConseillerJPA : getByLogin() : Size of list result = " + resultList.size());
				System.out.println(resultList);
				cb = resultList.get(0);
			}

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			System.out.println("DaoConseillerJPA : getByLogin() : erreur : " + e.getMessage());
			throw new DaoPersistanceException(e.getMessage(), e.getCause());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return cb;
	}

}
