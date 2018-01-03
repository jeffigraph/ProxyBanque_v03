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
			emf.close();
		}
	}

	@Override
	public void update(Client client) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			System.out.println("client recu : "+client);
			System.out.println("id du client recu : " + client.getIdClient());
			Client dbClient = em.find(Client.class, client.getIdClient());
			
			System.out.println("contenu du client DB :" + dbClient.getNom()+ " " +dbClient.getIdClient());
			
			dbClient.setNom(client.getNom());
			dbClient.setPrenom(client.getPrenom());
			dbClient.setAdresse(client.getAdresse());
			dbClient.setCodePostal(client.getCodePostal());
			dbClient.setCompteCourant(client.getCompteCourant());

			em.merge(dbClient);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			System.out.println(e.getMessage());
			throw new DaoPersistanceException(e.getMessage(), e.getCause());
		} finally {
			if (em != null) {
				em.close();
			}
			emf.close();
		}
	}

	@Override
	public void delete(Client client) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.remove(client);

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
			emf.close();
		}

	}

	@Override
	public Client getById(long idClient) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Client client = null;

		try {
			txn.begin();

			TypedQuery<Client> query = em.createQuery("select c from Client c where c.idClient = '" + idClient + "'",
					Client.class);
			client = query.getResultList().get(0);

			System.out.println("DaoClientJPA : getById() : Size of list result = " + query.getResultList().size());

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
			emf.close();
		}
		return client;
	}

	@Override
	public List<Client> getAllByConseillerId(long idConseiller) throws DaoPersistanceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		List<Client> resultList = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<Client> query = em.createQuery(
					"select c from Client c where c.conseillerClient.idConseiller = '" + idConseiller + "'",
					Client.class);
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
			emf.close();
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
			emf.close();
		}
		return resultList;
	}
}
