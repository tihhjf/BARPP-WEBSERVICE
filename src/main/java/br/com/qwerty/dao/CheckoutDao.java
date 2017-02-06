package br.com.qwerty.dao;

import br.com.qwerty.entidade.Checkout;

public class CheckoutDao extends GenericDao<Checkout, Integer>{
	
	public CheckoutDao() {
		super(Checkout.class);
	}
}
