package com.proxybanque_KO_JFA.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoCarteBancaire;
import com.proxybanque_KO_JFA.entity.CarteBancaire;

public class DaoCarteBancaireJPA implements IDaoCarteBancaire {

	public DaoCarteBancaireJPA() {
	}

	@Override
	public void add(CarteBancaire cb) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			em.persist(cb);

			txn.commit();
		} catch (

		Exception e) {
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
	public void update(CarteBancaire cb) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			em.refresh(cb);

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
	public void delete(CarteBancaire cb) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			em.remove(cb);

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
	public CarteBancaire getById(String numeroCB) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		CarteBancaire cb = null;

		try {
			txn.begin();

			TypedQuery<CarteBancaire> query = em.createQuery("from CarteBancaire where numeroCarte = " + numeroCB,
					CarteBancaire.class);
			List<CarteBancaire> resultList = query.getResultList();
			if (resultList != null) {
				System.out.println("DaoCarteBancaireJPA : selectById() : Size of list result = " + resultList.size());
				System.out.println(resultList);
				cb = resultList.get(0);
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
		return cb;
	}

	@Override
	public List<CarteBancaire> getAll() throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		List<CarteBancaire> resultList = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<CarteBancaire> query = em.createQuery("from CarteBancaire", CarteBancaire.class);
			resultList = query.getResultList();

			System.out.println("DaoCarteBancaireJPA : getAll() : Size of list result = " + resultList.size());
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

}
