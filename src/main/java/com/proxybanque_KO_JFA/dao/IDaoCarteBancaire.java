/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proxybanque_KO_JFA.dao;

import java.util.List;

import com.proxybanque_KO_JFA.entity.CarteBancaire;

/**
 * Gestion d'une CarteBanquaire
 *
 * @author JL JFA
 */
public interface IDaoCarteBancaire {
	public void add(CarteBancaire cb) throws DaoPersistanceException;

	public void update(CarteBancaire cb) throws DaoPersistanceException;

	public void delete(CarteBancaire cb) throws DaoPersistanceException;

	/**
	 * Renvois la CarteBancaire dont le numero correspond a celui fournie en
	 * parametre
	 * 
	 * @param numeroCB
	 * @return CarteBancaire ou null
	 */
	public CarteBancaire getById(String numeroCB) throws DaoPersistanceException;

	public List<CarteBancaire> getAll() throws DaoPersistanceException;

}
