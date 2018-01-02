package com.proxybanque_KO_JFA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	 * 
	 */
	public CompteCourant() {
		super();
	}

	/**
	 * le type d'un compte courant
	 */
	public static final String TYPE_COMPTE = "courant";

	/**
	 * la carte Bancaire associee au compte, defini seuelment si le client en
	 * possede une, sinon null.
	 */
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="numero_carte")
	private CarteBancaire carteBancaire;

	/**
	 * le montant du decouvert autorise
	 */
	// private Decouvert autorisationDecouvert;
	private double decouvertAutorise;
	/*
	 * public CompteCourant(CarteBancaire carteBancaire, int decouvertAutorise, int
	 * numeroCompte, Date dateOuverture, String type) { super(numeroCompte,
	 * dateOuverture, type); this.carteBancaire = carteBancaire;
	 * this.decouvertAutorise = decouvertAutorise; }
	 */

	public CompteCourant(String numeroCompte, Double solde, String dateOuverture, String typeClient, String typeCompte,
			CarteBancaire carteBancaire, int decouvertAutorise) {
		super(numeroCompte, solde, dateOuverture, typeClient, typeCompte);
		this.carteBancaire = carteBancaire;
		this.decouvertAutorise = decouvertAutorise;
	}

	/**
	 * @return the carteBancaire
	 */
	public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	/**
	 * @param carteBancaire
	 *            the carteBancaire to set
	 */
	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proxibanquev1.model.Compte#getTypeCompte()
	 */
	@Override
	public String getTypeCompte() {
		return TYPE_COMPTE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteCourant [carteBancaire=" + carteBancaire + ", autorisationDecouvert=" + decouvertAutorise
				+ ", solde=" + super.getSolde() + "]";
	}

	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

}
