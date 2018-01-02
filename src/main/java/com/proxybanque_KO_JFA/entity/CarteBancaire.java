package com.proxybanque_KO_JFA.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JL JFA
 *
 */
@Entity
@Table(
		name = "cartebancaire")
public class CarteBancaire {
	public static final String VISA_ELECTRON = "visa electron";
	public static final String VISA_PREMIER = "visa premier";

	@Id
	private String numeroCarte;

	private String typeCarte;

	/**
	 * 
	 */
	public CarteBancaire() {
		super();
	}

	/**
	 * @param numeroCarte
	 * @param tYPE_CARTE
	 */
	public CarteBancaire(String numeroCarte, String TYPE_CARTE) {
		super();
		this.numeroCarte = numeroCarte;
		this.typeCarte = TYPE_CARTE;
	}

	/**
	 * @return the visaElectron
	 */
	public static String getVisaElectron() {
		return VISA_ELECTRON;
	}

	/**
	 * @return the visaPremier
	 */
	public static String getVisaPremier() {
		return VISA_PREMIER;
	}

	/**
	 * @return the nUMERO_CARTE
	 */
	public String getNumeroCarte() {
		return numeroCarte;
	}

	/**
	 * @return the tYPE_CARTE
	 */
	public String getTypeCarte() {
		return typeCarte;
	}

	/**
	 * @param nUMERO_CARTE
	 *            the nUMERO_CARTE to set
	 */
	public void setNumeroCarte(String nUMERO_CARTE) {
		numeroCarte = nUMERO_CARTE;
	}

	/**
	 * @param tYPE_CARTE
	 *            the tYPE_CARTE to set
	 */
	public void setTypeCarte(String tYPE_CARTE) {
		typeCarte = tYPE_CARTE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!CarteBancaire.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		final CarteBancaire cb = (CarteBancaire) obj;

		return this.numeroCarte.equals(cb.getNumeroCarte());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarteBancaire [NUMERO_CARTE=" + numeroCarte + ", TYPE_CARTE=" + typeCarte + "]";
	}

}