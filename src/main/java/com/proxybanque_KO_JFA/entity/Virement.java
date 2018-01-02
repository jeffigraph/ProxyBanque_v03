package com.proxybanque_KO_JFA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author JL JFA
 *
 */
@Entity
@Table(
		name = "virement")
public class Virement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idVirement;
	private String date;
	private String idCompteDepart;
	private String idCompteCible;
	
	private Double montant;

	/**
	 * 
	 */
	public Virement() {
		super();
	}

	/**
	 * @param date
	 * @param idCompteDepart
	 * @param idCompteCible
	 */
	public Virement(String idCompteDepart, String idCompteCible, double montant) {
		super();
		this.idCompteDepart = idCompteDepart;
		this.idCompteCible = idCompteCible;
		this.montant = montant;
	}

	/**
	 * methode pour recuperer la date a laquelle a ete effectuee la transaction
	 * 
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * methode recupere l'identifiant du compte depart
	 * 
	 * @return the idCompteDepart
	 */
	public String getIdCompteDepart() {
		return idCompteDepart;
	}

	/**
	 * methode pour recuperer l'identifiant du compte cible
	 * 
	 * @return the idCompteCible
	 */
	public String getIdCompteCible() {
		return idCompteCible;
	}

	/**
	 * methode pour recuperer le montant de transaction
	 * 
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @return the idVirement
	 */
	public long getIdVirement() {
		return idVirement;
	}

	/**
	 * @param idVirement
	 *            the idVirement to set
	 */
	public void setIdVirement(long idVirement) {
		this.idVirement = idVirement;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @param idCompteDepart
	 *            the idCompteDepart to set
	 */
	public void setIdCompteDepart(String idCompteDepart) {
		this.idCompteDepart = idCompteDepart;
	}

	/**
	 * @param idCompteCible
	 *            the idCompteCible to set
	 */
	public void setIdCompteCible(String idCompteCible) {
		this.idCompteCible = idCompteCible;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Virement [date=" + date + ", idCompteDepart=" + idCompteDepart + ", idCompteCible=" + idCompteCible
				+ ", montant=" + montant + "]";
	}

}
