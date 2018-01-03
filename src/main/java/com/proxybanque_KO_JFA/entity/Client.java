package com.proxybanque_KO_JFA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Definit les informations d'un client avec ses comptes.
 *
 * @author JL JFA
 * @version 0.1
 *
 */
@Entity
@Table(name = "client")
public class Client {

	public static final int PARTICULIER = 1;
	public static final int ENTREPRISE = 2;

	@Id
	@Column(name = "id_client")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClient;

	private String nom;

	private String prenom;

	private String adresse;

	private String ville;

	private int codePostal;

	private String telephone;

	@OneToOne(mappedBy = "client", cascade = { CascadeType.PERSIST })
	private CompteCourant compteCourant;

	@OneToOne(mappedBy = "client", cascade = { CascadeType.PERSIST })
	private CompteEpargne compteEpargne;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "id_conseiller")
	private Conseiller conseillerClient;

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param idClient
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param ville
	 * @param codePostal
	 * @param telephone
	 * @param compteCourant
	 * @param compteEpargne
	 */
	public Client(String nom, String prenom, String adresse, String ville, int codePostal, String telephone,
			CompteCourant compteCourant, CompteEpargne compteEpargne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public Conseiller getConseillerClient() {
		return conseillerClient;
	}

	public void setConseillerClient(Conseiller conseillerClient) {
		this.conseillerClient = conseillerClient;
	}

	public Compte getCompteByNum(String numCompte) {
		if (null != compteCourant && numCompte.equals(compteCourant.getNumeroCompte()))
			return compteCourant;
		else if (null != compteEpargne && numCompte.equals(compteEpargne.getNumeroCompte()))
			return compteEpargne;
		else
			return null;
	}
	
}
