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

public class MainDBPopulate {

	public static void main(String[] args) {
		CarteBancaire cb1 = new CarteBancaire();
		cb1.setNumeroCarte("5654564165");
		cb1.setTypeCarte(CarteBancaire.VISA_ELECTRON);

		CarteBancaire cb2 = new CarteBancaire();
		cb2.setNumeroCarte("567842122525");
		cb2.setTypeCarte(CarteBancaire.VISA_PREMIER);

		CompteCourant cc = new CompteCourant();
		cc.setNumeroCompte("5463454sds45445");
		cc.setDateOuverture("2012-09-24");
		cc.setSolde(100.25);
		cc.setTypeClient(Compte.PARTICULIER);
		cc.setTypeCompte(Compte.COURANT);
		cc.setDecouvertAutorise(Decouvert.DECOUVERT_PARTICULIER);

		cc.setCarteBancaire(cb1);
		cb1.setCompteCourant(cc);

		CompteCourant cc2 = new CompteCourant();
		cc2.setNumeroCompte("32467952154");
		cc2.setDateOuverture("2017-05-26");
		cc2.setSolde(4500.25);
		cc2.setTypeClient(Compte.PARTICULIER);
		cc2.setTypeCompte(Compte.COURANT);
		cc2.setDecouvertAutorise(Decouvert.DECOUVERT_PARTICULIER);

		cc2.setCarteBancaire(cb2);
		cb2.setCompteCourant(cc2);

		Client clt = new Client("Einstein", "Albert", "23 rue des Canards Sauvages", "Lille", 20001, "+33012598774",
				null, null);
		clt.setCompteCourant(cc);
		cc.setClient(clt);

		Client clt2 = new Client("Marx", "Karl", "12 rue des Anges Rouges", "La Havane", 45201, "+29454541", null,
				null);
		clt2.setCompteCourant(cc2);
		cc2.setClient(clt2);

		Conseiller conseiller = new Conseiller("Loiseaux", "Michel", Conseiller.TYPECONSEILLER, null);
		conseiller.setLogin("michel");
		conseiller.setPassword("test");

		clt.setConseillerClient(conseiller);
		clt2.setConseillerClient(conseiller);

		List<Client> lstClients = new ArrayList<>();
		lstClients.add(clt);
		lstClients.add(clt2);

		conseiller.setPortefeuilleClients(lstClients);
		
		Conseiller conseiller2 = new Conseiller("Albin", "Michel", Conseiller.TYPEGERANT, null);
		conseiller2.setLogin("albin");
		conseiller2.setPassword("test");

		// IDaoCarteBancaire daoCarteB = new DaoCarteBancaireJPA();
		// IDaoCompte daoCompte = new DaoCompteJPA();
		// IDaoClient daoClient = new DaoClientJPA();
		IDaoConseiller daoConseiller = new DaoConseillerJPA();
		
		try {
			daoConseiller.add(conseiller);
			daoConseiller.add(conseiller2);

		} catch (DaoPersistanceException e) {
			e.printStackTrace();
		}
	}

}
