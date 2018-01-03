package com.proxybanque_KO_JFA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CompteEpargne extends Compte {

	public static final String TYPE_COMPTE = "epargne";

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "taux_id")
	private Taux tauxRemuneration;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "id_client")
	private Client client;
	
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
	public CompteEpargne(String numeroCompte, Double solde, String dateOuverture, String typeClient,
			String typeCompte) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}