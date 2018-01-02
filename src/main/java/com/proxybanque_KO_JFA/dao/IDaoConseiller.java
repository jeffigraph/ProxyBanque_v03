package com.proxybanque_KO_JFA.dao;

import java.util.List;

import com.proxybanque_KO_JFA.entity.Conseiller;

public interface IDaoConseiller {
	void add(Conseiller conseiller) throws DaoPersistanceException;

	void update(Conseiller conseiller) throws DaoPersistanceException;

	void delete(Conseiller conseiller) throws DaoPersistanceException;

	Conseiller getById(String idConseiller) throws DaoPersistanceException;
	
	Conseiller getByLogin(String login, String mdp) throws DaoPersistanceException;

	/**
	 * Renvoie la liste des conseillers de  l'agence dont l'identifiant est fourni en
	 * parametre
	 * 
	 * @param idAgence
	 * @return List<Conseiller>
	 */
	List<Conseiller> getAllByAgenceId(int idAgence) throws DaoPersistanceException;

	List<Conseiller> getAll() throws DaoPersistanceException;
}
