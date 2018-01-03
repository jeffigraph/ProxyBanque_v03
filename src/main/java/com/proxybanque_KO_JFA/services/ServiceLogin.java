package com.proxybanque_KO_JFA.services;

import java.util.List;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoConseiller;
import com.proxybanque_KO_JFA.entity.Conseiller;

/**
 * Gestion de l'authentification utilisateur
 * 
 * Cherche l'information par DAO - si on trouve un Conseiller par son ID
 * employee et ID agence, login l'autentification est reussie, et la session est
 * ouverte
 * 
 * @author JL JFA
 *
 */
public class ServiceLogin {

	private IDaoConseiller mDaoConseiller;

	private Conseiller mConseiller;

	public ServiceLogin(IDaoConseiller mDaoConseiller) {
		super();
		this.mDaoConseiller = mDaoConseiller;

		mConseiller = null;
	}

	public Conseiller getMyConseiller() {
		return mConseiller;
	}

	/**
	 * Retourne le premier conseiller de la base de donnee correspondant au login et
	 * au psw fournis en parametre renvoie null si aucun conseiller ne correspond
	 * 
	 * @param login
	 *            du conseiller
	 * @param psw
	 *            du conseiller
	 * @return Conseiller le conseiller trouve ou null
	 * @throws DaoException
	 *             la requete a achouee
	 */
	public Conseiller login(String login, String psw) throws DaoPersistanceException {
		mConseiller = mDaoConseiller.getByLogin(login, psw);

		return mConseiller;
	}
	 public List<Conseiller> getAllConseillers() throws DaoPersistanceException{
		 return mDaoConseiller.getAll();
	 }
}
