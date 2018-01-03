package com.proxybanque_KO_JFA.test;

import java.util.ArrayList;
import java.util.List;

import com.proxybanque_KO_JFA.dao.DaoPersistanceException;
import com.proxybanque_KO_JFA.dao.IDaoCarteBancaire;
import com.proxybanque_KO_JFA.dao.IDaoClient;
import com.proxybanque_KO_JFA.dao.IDaoCompte;
import com.proxybanque_KO_JFA.dao.IDaoConseiller;
import com.proxybanque_KO_JFA.dao.jpa.DaoCarteBancaireJPA;
import com.proxybanque_KO_JFA.dao.jpa.DaoClientJPA;
import com.proxybanque_KO_JFA.dao.jpa.DaoCompteJPA;
import com.proxybanque_KO_JFA.dao.jpa.DaoConseillerJPA;
import com.proxybanque_KO_JFA.entity.CarteBancaire;
import com.proxybanque_KO_JFA.entity.Client;
import com.proxybanque_KO_JFA.entity.Compte;
import com.proxybanque_KO_JFA.entity.CompteCourant;
import com.proxybanque_KO_JFA.entity.Conseiller;
import com.proxybanque_KO_JFA.entity.Decouvert;

public class TestMain {

	public static void main(String[] args) {
		CarteBancaire cb1 = new CarteBancaire();
		cb1.setNumeroCarte("5654564165");
		cb1.setTypeCarte(CarteBancaire.VISA_ELECTRON);
		// System.out.println(cb1);

		CompteCourant cc = new CompteCourant();
		cc.setNumeroCompte("5463454sds45445");
		cc.setDateOuverture("2012-09-24");
		cc.setSolde(100.25);
		cc.setTypeClient(Compte.PARTICULIER);
		cc.setTypeCompte(Compte.COURANT);
		cc.setDecouvertAutorise(Decouvert.DECOUVERT_PARTICULIER);

		cc.setCarteBancaire(cb1);
		cb1.setCompteCourant(cc);

		// System.out.println(cc);

		Client clt = new Client("Einstein", "Albert", "23 rue des Canards Sauvages", "Lille", 20001, "+33012598774",
				null, null);
		clt.setCompteCourant(cc);
		cc.setClient(clt);

		// System.out.println(clt);

		Client clt2 = new Client("Marx", "Karl", "12 rue des Anges Rouges", "La Havane", 45201, "+29454541", null,
				null);
		// System.out.println(clt2);

		Conseiller conseiller = new Conseiller("Loiseaux", "Michel", Conseiller.TYPECONSEILLER, null);
		conseiller.setLogin("michel");
		conseiller.setPassword("test");

		clt.setConseillerClient(conseiller);
		clt2.setConseillerClient(conseiller);

		List<Client> lstClients = new ArrayList<>();
		lstClients.add(clt);
		lstClients.add(clt2);

		conseiller.setPortefeuilleClients(lstClients);

		 IDaoCarteBancaire daoCarteB = new DaoCarteBancaireJPA();
		// IDaoCompte daoCompte = new DaoCompteJPA();
		IDaoClient daoClient = new DaoClientJPA();

		IDaoConseiller daoConseiller = new DaoConseillerJPA();
		try {
			// daoCarteB.add(cb1);

			// daoCompte.add(cc);
//			daoClient.add(clt);
//			daoClient.add(clt2);

			daoConseiller.add(conseiller);
			CarteBancaire cb = daoCarteB.getById(cb1.getNumeroCarte());
			System.out.println(cb);
			Conseiller cons = daoConseiller.getByLogin("michel", "test");
			//System.out.println(cons);
			System.out.println(cons.getIdConseiller() + " " + cons.getNom() + " " + cons.getLogin());
			
			// CarteBancaire cb2 = daoCarteB.getById(cb1.getNumeroCarte());
			// System.out.println(cb2);

			// List<Compte> lstCompte = daoCompte.getAll();
			// for (Compte compte : lstCompte) {
			// System.out.println(compte);
			// }

			// List<Conseiller> lstCons = daoConseiller.getAll();
			// for (Conseiller cons : lstCons) {
			// System.out.println(cons);
			// }

		} catch (DaoPersistanceException e) {
			e.printStackTrace();
		}

	}

}
