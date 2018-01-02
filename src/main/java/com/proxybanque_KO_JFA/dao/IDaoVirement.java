package com.proxybanque_KO_JFA.dao;

import java.util.List;

import com.proxybanque_KO_JFA.entity.Virement;

public interface IDaoVirement {
	void add(Virement virement) throws DaoPersistanceException;

	void update(Virement virement) throws DaoPersistanceException;

	void delete(Virement virement) throws DaoPersistanceException;

	Virement getById(long idVirement) throws DaoPersistanceException;

	List<Virement> getAll() throws DaoPersistanceException;
}
