package com.proxybanque_KO_JFA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Decrit le taux de remuneration
 * 
 * @author JL JFA
 *
 */
@Entity
public class Taux {
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO)
	private long idTaux;

	private Double taux;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "id_compte")
	private CompteEpargne compteEpargne;

	/**
	 * 
	 */
	public Taux() {
		super();
	}

	/**
	 * @param taux
	 */
	public Taux(Double taux) {
		super();
		this.taux = taux;
	}

	/**
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * @param taux
	 *            the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}

	/**
	 * @return the idTaux
	 */
	public long getIdTaux() {
		return idTaux;
	}

	/**
	 * @param idTaux
	 *            the idTaux to set
	 */
	public void setIdTaux(long idTaux) {
		this.idTaux = idTaux;
	}

}