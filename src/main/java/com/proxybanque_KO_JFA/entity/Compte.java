package com.proxybanque_KO_JFA.entity;

import java.util.jar.Attributes.Name;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Description d'un Compte bancaire classe abstraite devant etre etendue
 *
 * @author JL JFA
 *
 */
@Entity
@Inheritance(
		strategy = InheritanceType.JOINED)
public abstract class Compte {

	// Attributs DB aide a preparation des requetes
	// public static final String TABLENAME = "compte";
	// public static final String KEYNAME = "numerocompte";
	// public static final String TABLECOLUMNS = "numerocompte, dateouverture,
	// solde, idtypeclient";
	// public static final String ALLCOLUMNPARAMS = "?,?,?,?";
	//

	@Id
	@Column(name="id_compte")
	private String numeroCompte;

	private Double solde;

	private String dateOuverture;

	/**
	 * le type du client detenteur de compte : particulier ou entreprise
	 */
	private String typeClient;

	/**
	 * le type du compte : Courant ou Epargne
	 */
	private String typeCompte;

	/**
	 * les types que peut prendre un compte
	 */
	public static final String PARTICULIER = "particulier";
	public static final String ENTREPRISE = "entreprise";
	public static final String COURANT = "courant";
	public static final String EPARGNE = "epargne";

	/**
	 * 
	 */
	public Compte() {
		super();
	}

	/**
	 * @param numeroCompte
	 * @param dateOuverture
	 *            du compte
	 * @param type
	 *            le type du compte : Courant ou Epargne
	 */
	Compte(String numeroCompte, String dateOuverture, String typeClient, String typeCompte) {
		this(numeroCompte, 0.0, dateOuverture, typeClient, typeCompte);
	}

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateOuverture
	 * @param type
	 *            le type du compte : Courant ou Epargne
	 */
	Compte(String numeroCompte, Double solde, String dateOuverture, String typeClient, String typeCompte) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.typeClient = typeClient;
		this.typeCompte = typeCompte;
	}

	/**
	 * @return the numeroCompte
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * @return the typeCompte
	 */
	public String getTypeCompte() {
		return typeCompte;
	}

	/**
	 * @return the typeClient
	 */
	public String getTypeClient() {
		return typeClient;
	}

	/**
	 * @param typeClient
	 *            the typeClient to set
	 */
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	/**
	 * @param typeCompte
	 *            the typeCompte to set
	 */
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	/**
	 * @return the dateOuverture
	 */
	public String getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * @param numeroCompte
	 *            the numeroCompte to set
	 */
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * @param dateOuverture
	 *            the dateOuverture to set
	 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	/**
	 * Credite le compte du montant
	 *
	 * @param montant
	 */
	public void addToSolde(int montant) {
		this.solde += montant;
	}

	/**
	 * Debite le compte du montant
	 *
	 * @param montant
	 */
	public void removeFromSolde(int montant) {
		this.solde -= montant;
	}

	/**
	 * @return the particulier
	 */
	public static String getParticulier() {
		return PARTICULIER;
	}

	/**
	 * @return the entreprise
	 */
	public static String getEntreprise() {
		return ENTREPRISE;
	}

}
