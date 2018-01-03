package com.proxybanque_KO_JFA.entity;

import java.util.List;

/**
 * Decrit un gerant qui est aussi un conseiller
 * @author JL JFA
 *
 */
public class Gerant extends Conseiller {

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param typeConseiller
	 * @param portefeuilleClients
	 */
	public Gerant(String nom, String prenom, String typeConseiller, List<Client> portefeuilleClients) {
		super(nom, prenom, typeConseiller, portefeuilleClients);
		// TODO Auto-generated constructor stub
	}


}