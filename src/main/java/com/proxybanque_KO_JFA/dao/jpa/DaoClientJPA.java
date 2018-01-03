package com.proxybanque_KO_JFA.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoClient;
import com.proxybanque_KO_JFA.entity.Client;

public class DaoClientJPA implements IDaoClient {

	public DaoClientJPA() {
	}

	@Override
	public void add(Client client) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
				em.persist(client);

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
	public void update(Client client) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Client client) throws DaoPersistanceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Client getById(long idClient) throws DaoPersistanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAllByConseillerId(long idConseiller) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		List<Client> resultList = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<Client> query = em.createQuery("select c from Client c where c.conseillerClient.idConseiller = '"+idConseiller+"'", Client.class);
			resultList = query.getResultList();

			System.out.println("DaoClientJPA : getAllByConseillerId() : Size of list result = " + resultList.size());
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

	@Override
	public List<Client> getAll() throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		List<Client> resultList = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<Client> query = em.createQuery("from Client", Client.class);
			resultList = query.getResultList();

			System.out.println("DaoClientJPA : getAll() : Size of list result = " + resultList.size());
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
