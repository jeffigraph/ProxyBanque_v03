package com.proxybanque_KO_JFA.dao;

import java.util.List;

import com.proxybanque_KO_JFA.entity.Client;
import com.proxybanque_KO_JFA.entity.Compte;
import com.proxybanque_KO_JFA.entity.CompteCourant;
import com.proxybanque_KO_JFA.entity.CompteEpargne;

public interface IDaoCompte {
	public void add(Compte compte) throws DaoPersistanceException;

	public void update(Compte compte) throws DaoPersistanceException;

	public void delete(Compte compte) throws DaoPersistanceException;

	public Compte getById(String numeroCompte) throws DaoPersistanceException;

	public List<Compte> getAll() throws DaoPersistanceException;
	
	

	public CompteCourant getCCByIdClient(int idClient);

	public CompteEpargne getCEByIdClient(int idClient);

	public void updateCCClient(Client c) throws DaoPersistanceException;

	public void updateCEClient(Client c) throws DaoPersistanceException;

//	public Compte getIfExist(String noCompte) throws DaoPersistanceException;

	public void updateSolde(Compte c) throws DaoPersistanceException;
}
