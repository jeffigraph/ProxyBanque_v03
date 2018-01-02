package com.proxybanque_KO_JFA.services;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoCompte;
import com.proxybanque_KO_JFA.dao.IDaoVirement;
import com.proxybanque_KO_JFA.entity.Client;
import com.proxybanque_KO_JFA.entity.Compte;
import com.proxybanque_KO_JFA.entity.CompteCourant;
import com.proxybanque_KO_JFA.entity.Virement;

/**
 * Service realisant des Virements d'un Compte a un autre
 * 
 * @author JL JFA
 *
 */
public class ServiceVirement {
	/**
	 * interface de gestion de la base de donnees
	 */
	private IDaoCompte daoCompte;
	private IDaoVirement daoVirement;

	/**
	 * montant maximal pour un virement
	 */
	final static double SEUILMAX = 9999;

	public ServiceVirement(IDaoCompte daoCompte, IDaoVirement daoVirement) {
		super();
		this.daoCompte = daoCompte;
		this.daoVirement = daoVirement;
	}

	/**
	 * Realise un virement ente les deux comptes fournis en parametre
	 * 
	 * @param depart le compte a debiter
	 * @param cible	 le compte a crediter
	 * @param montant   le montant a traiter
	 * @return boolean true si virement reussi
	 * @throws DaoException
	 */
	public boolean faireVirement(Compte depart, Compte cible, double montant) throws DaoPersistanceException {
		if (checkMontantSolde(depart, montant)) {

			// Insertion de virement dans table
			daoVirement.add(new Virement(depart.getNumeroCompte(), cible.getNumeroCompte(), montant));

			depart.setSolde(depart.getSolde() - montant);
			cible.setSolde(cible.getSolde() + montant);

			// modification de table compte
			daoCompte.updateSolde(depart);
			daoCompte.updateSolde(cible);

			return true;
		} else
			return false;
	}
	
	
	public boolean faireVirement(Client debiteur, Compte compteDebite, Client crediteur, Compte compteCredite, double montant) throws DaoPersistanceException {
		if (checkMontantSolde(compteDebite, montant)) {

			// Insertion de virement dans table
			daoVirement.add(new Virement(compteDebite.getNumeroCompte(), compteCredite.getNumeroCompte(), montant));

			compteDebite.setSolde(compteDebite.getSolde() - montant);
			compteCredite.setSolde(compteCredite.getSolde() + montant);

			// modification de table compte
			daoCompte.updateSolde(compteDebite);
			daoCompte.updateSolde(compteCredite);

			return true;
		} else
			return false;
	}
	

	/**
	 * Rend le Compte dont le numero de compte est fourni en paramete, rend null
	 * s'il n'existe pas
	 * 
	 * @param numero  de comtpte du compte retrouver
	 * @return true si trouve
	 * @throws DaoException
	 */
	public Compte getCompte(String numeroCompte) throws DaoPersistanceException {
		return daoCompte.getById(numeroCompte);
	}

	/**
	 * Verifie que le montant ne depasse pas le solde du compte
	 * 
	 * @param depart    le compte a verifier
	 * @param montant	le montant a virer
	 * @return true si le solde est suffisant
	 */
	private boolean checkMontantSolde(Compte depart, double montant) {
		// TODO
		if ((depart.getSolde() >= montant)
			 || (depart instanceof CompteCourant && ((CompteCourant) depart).getDecouvertAutorise() + depart.getSolde() >= montant))
			return true;
		else
			return false;
	}

}