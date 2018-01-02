package com.proxybanque_KO_JFA.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
			em.merge(virement);

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
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxybanque_JFA.dao.IDaoVirement#getAll()
	 */
	@Override
	public List<Virement> getAll() throws DaoPersistanceException {
		// TODO Auto-generated method stub
		return null;
	}

}
