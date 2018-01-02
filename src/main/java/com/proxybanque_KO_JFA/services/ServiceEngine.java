package com.proxybanque_KO_JFA.services;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoClient;
import com.proxybanque_KO_JFA.dao.IDaoCompte;
import com.proxybanque_KO_JFA.dao.IDaoConseiller;
import com.proxybanque_KO_JFA.dao.IDaoVirement;
import com.proxybanque_KO_JFA.dao.jpa.DaoClientJPA;
import com.proxybanque_KO_JFA.dao.jpa.DaoCompteJPA;
import com.proxybanque_KO_JFA.dao.jpa.DaoConseillerJPA;
import com.proxybanque_KO_JFA.dao.jpa.DaoVirementJPA;

/**
 * Classe de service, elle regroupe les differents services fournis par
 * l'Application. C'est ici que les objets implementant une interface DAO sont
 * instanties. Le type de DAO peut etre configure par Config - actuellement en
 * Memoire
 * 
 * A faire : rentre ce Engine en Singleton
 * 
 * @author JL JFA
 *
 */
public class ServiceEngine {


	// private IDaoAgence mDaoAgence;
	private IDaoClient mDaoClient;
	private IDaoConseiller mDaoConseiller;
	private IDaoCompte mDaoCompte;
	private IDaoVirement mDaoVirement;

	private ServiceAgence serviceAgence;
	private ServiceLogin serviceLogin;
	private ServiceGestionClient serviceGestionClient;
	private ServiceVirement serviceVirement;

	/**
	 * Instancie l'ensemble des services accedants a la base de donnees
	 * 
	 * @throws JdbcDaoException
	 */
	public ServiceEngine() throws DaoPersistanceException {

//		BDD.addDatabase(URL, USER, PASSWORD);

		// this.mDaoAgence = new DaoAgenceMySQL();
		this.mDaoClient = new DaoClientJPA();
		this.mDaoConseiller = new DaoConseillerJPA();
		this.mDaoCompte = new DaoCompteJPA();
		this.mDaoVirement = new DaoVirementJPA();

		// serviceAgence = new ServiceAgence(mDaoAgence);
		serviceLogin = new ServiceLogin(mDaoConseiller);
		serviceGestionClient = new ServiceGestionClient(mDaoClient);
		serviceVirement = new ServiceVirement(mDaoCompte, mDaoVirement);
	}

	public ServiceLogin getServiceLogin() {
		return serviceLogin;
	}

	public ServiceAgence getServiceAgence() {
		return serviceAgence;
	}

	public ServiceGestionClient getServiceGestionClient() {
		return serviceGestionClient;
	}

	public ServiceVirement getServiceVirement() {
		return serviceVirement;
	}

}
