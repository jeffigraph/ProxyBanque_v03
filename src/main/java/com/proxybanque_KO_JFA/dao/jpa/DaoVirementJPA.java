package com.proxybanque_KO_JFA.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoVirement;
import com.proxybanque_KO_JFA.entity.Virement;

public class DaoVirementJPA implements IDaoVirement {

	public DaoVirementJPA() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proxybanque_JFA.dao.IDaoVirement#add(com.proxybanque_JFA.entity.Virement)
	 */
	@Override
	public void add(Virement virement) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.persist(virement);

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
	 * @see com.proxybanque_JFA.dao.IDaoVirement#update(com.proxybanque_JFA.entity.
	 * Virement)
	 */
	@Override
	public void update(Virement virement) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxybanque_JFA.dao.IDaoVirement#delete(com.proxybanque_JFA.entity.
	 * Virement)
	 */
	@Override
	public void delete(Virement virement) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxybanque_JFA.dao.IDaoVirement#getById(long)
	 */
	@Override
	public Virement getById(long idVirement) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Virement virement = null;

		try {
			txn.begin();

			TypedQuery<Virement> query = em
					.createQuery("select v from Virement v where v.idVirement = '" + idVirement + "'", Virement.class);
			virement = query.getResultList().get(0);

			System.out.println("DaoVirementJPA : getById() : Size of list result = " + query.getResultList().size());

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
		return virement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxybanque_JFA.dao.IDaoVirement#getAll()
	 */
	@Override
	public List<Virement> getAll() throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		List<Virement> lstVirements = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<Virement> query = em.createQuery("select v from Virement v", Virement.class);
			lstVirements = query.getResultList();

			System.out.println("DaoVirementJPA : getAll() : Size of list result = " + lstVirements.size());

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
		return lstVirements;
	}
}
