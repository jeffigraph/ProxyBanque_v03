package com.proxybanque_KO_JFA.dao;

import java.util.List;

import com.proxybanque_KO_JFA.entity.Agence;

public interface IDaoAgence {
	void add(Agence agence) throws DaoPersistanceException;

	void update(Agence agence) throws DaoPersistanceException;

	void delete(Agence agence) throws DaoPersistanceException;

	Agence getById(long idAgence) throws DaoPersistanceException;

	List<Agence> getAll() throws DaoPersistanceException;

}
