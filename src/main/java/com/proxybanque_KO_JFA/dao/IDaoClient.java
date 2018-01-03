package com.proxybanque_KO_JFA.dao;

import java.util.List;

import com.proxybanque_KO_JFA.entity.Client;

public interface IDaoClient {

	void add(Client client) throws DaoPersistanceException;

	void update(Client client) throws DaoPersistanceException;

	void delete(Client client) throws DaoPersistanceException;

	Client getById(long idClient) throws DaoPersistanceException;
	
	Client getByNumCompte(String numCompte) throws DaoPersistanceException;

	/**
	 * Renvoie la liste des clients du conseiller dont l'identifiant est fourni en
	 * parametre
	 * 
	 * @param idConseiller
	 * @return List<Client>
	 */
	List<Client> getAllByConseillerId(long idConseiller) throws DaoPersistanceException;

	List<Client> getAll() throws DaoPersistanceException;

}
