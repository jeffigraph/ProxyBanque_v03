package com.proxybanque_KO_JFA.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * La classe donne des renseignements sur le nom, le prenom, le numero
 * identifiant d'un conseiller qui a la responsabilite d'un groupe de MAX_CLIENT
 * clients
 *
 * @author JL JFA
 *
 */
@Entity
@Table(name = "conseiller")
public class Conseiller {

	public static String TYPECONSEILLER = "conseiller";
	public static String TYPEGERANT = "gerant";

	public static final int MAX_CLIENT = 10;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conseiller")
	private long idConseiller;

	private String nom;

	private String prenom;

	private String typeConseiller;

	private String login;
	private String password;

	@OneToMany(mappedBy = "conseillerClient", cascade = { CascadeType.PERSIST })
	private List<Client> portefeuilleClients;

	/**
	 * 
	 */
	public Conseiller() {
		super();
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param typeConseiller
	 * @param portefeuilleClients
	 */
	public Conseiller(String nom, String prenom, String typeConseiller, List<Client> portefeuilleClients) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.typeConseiller = typeConseiller;
		this.portefeuilleClients = portefeuilleClients;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the typeConseiller
	 */
	public String getTypeConseiller() {
		return typeConseiller;
	}

	/**
	 * @param typeConseiller
	 *            the typeConseiller to set
	 */
	public void setTypeConseiller(String typeConseiller) {
		this.typeConseiller = typeConseiller;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the id
	 */
	public long getIdConseiller() {
		return idConseiller;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setIdConseiller(long id) {
		this.idConseiller = id;
	}

	/**
	 * Methode permet de verifier la taille du groupe de client sous la
	 * responsabilite d'un conseiller Si la taille de la liste est inferieur e 10.
	 * On ajoute le nouveau client e cette liste
	 *
	 * @return true
	 * @param client
	 *            Si non
	 * @return false
	 */
	public boolean addClient(Client client) {
		if (portefeuilleClients.size() < Conseiller.MAX_CLIENT) {
			portefeuilleClients.add(client);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * methode permet de supprimer un client d'un groupe de client
	 *
	 * @param client
	 * @return
	 */
	public boolean removeClient(Client client) {
		return portefeuilleClients.remove(client);
	}

	/**
	 * Recuperer un client de type Client e partir d'une parametre entree
	 *
	 * @param idClient
	 * @return Client
	 */
	public Client getClient(int idClient) {
		return portefeuilleClients.get(idClient);
	}

	/**
	 * Recuperer la liste de clients gere par un conseiller
	 *
	 * @return the portefeuilleClients
	 */
	public List<Client> getPortefeuilleClients() {
		return portefeuilleClients;
	}

	/**
	 * @param portefeuilleClients
	 *            the portefeuilleClients to set
	 */
	public void setPortefeuilleClients(List<Client> portefeuilleClients) {
		this.portefeuilleClients = portefeuilleClients;
	}

}
