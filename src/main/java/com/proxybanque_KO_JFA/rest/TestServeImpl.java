package com.proxybanque_KO_JFA.rest;

import java.util.ArrayList;
import java.util.List;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.entity.Client;
import com.proxybanque_KO_JFA.entity.Conseiller;
import com.proxybanque_KO_JFA.services.ServiceEngine;

public class TestServeImpl implements ITestServe {

	private ServiceEngine srvcEng;

	public Client getClientById(Long idCli) {
		Client c1 = null;
		try {
			c1 = srvcEng.getServiceGestionClient().getClient(idCli);
		} catch (DaoPersistanceException e) {
			e.printStackTrace();
		}
		return c1;
	}

	public List<Client> listClient() {
		List<Client> resultList = new ArrayList<>();
		try {
			resultList = srvcEng.getServiceGestionClient().getAllClients();
		} catch (DaoPersistanceException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Conseiller login(String login, String psw) {
		Conseiller Cons = null;
		try {
			Cons = srvcEng.getServiceLogin().login(login, psw);
		} catch (DaoPersistanceException e) {
			e.printStackTrace();
		}
		return Cons;
	}

}
