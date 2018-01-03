package com.proxybanque_KO_JFA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Descrit un compte courant
 *
 * @author JL JFA
 * @version 0.1
 *
 */
@Entity
public class CompteCourant extends Compte {
	/**
	 * le type d'un compte courant
	 */
	public static final String TYPE_COMPTE = "courant";

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "id_client")
	private Client client;

	/**
	 * la carte Bancaire associee au compte, defini seuelment si le client en
	 * possede une, sinon null.
	 */
	@OneToOne(mappedBy = "compteCourant", cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "id_carte")
	private CarteBancaire carteBancaire;

	/**
	 * le montant du decouvert autorise
	 */
	private double decouvertAutorise;

	/**
	 * 
	 */
	public CompteCourant() {
		super();
	}

	public CompteCourant(String numeroCompte, Double solde, String dateOuverture, String typeClient, String typeCompte,
			CarteBancaire carteBancaire, int decouvertAutorise) {
		super(numeroCompte, solde, dateOuverture, typeClient, typeCompte);
		this.carteBancaire = carteBancaire;
		this.decouvertAutorise = decouvertAutorise;
	}

	public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
