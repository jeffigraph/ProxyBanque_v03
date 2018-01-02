package com.proxybanque_KO_JFA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CompteEpargne extends Compte {

	public static final String TYPE_COMPTE = "epargne";

	@OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="taux_id")
	private Taux tauxRemuneration;

	/**
	 * 
	 */
	public CompteEpargne() {
		super();
	}

	/**
	 * @param numeroCompte
	 * @param dateOuverture
	 * @param type
	 */
	public CompteEpargne(String numeroCompte, String dateOuverture, String typeClient, String typeCompte) {
		super(numeroCompte, dateOuverture, typeClient, typeCompte);
	}

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateOuverture
	 * @param type
	 */
	public CompteEpargne(String numeroCompte, Double solde, String dateOuverture, String typeClient, String typeCompte) {
		super(numeroCompte, solde, dateOuverture, typeClient, typeCompte);
	}

	/**
	 * @return the tauxRemuneration
	 */
	public Taux getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * @param tauxRemuneration
	 *            the tauxRemuneration to set
	 */
	public void setTauxRemuneration(Taux tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
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
		return "CompteEpargne [tauxRemuneration=" + tauxRemuneration + "]";
	}

}