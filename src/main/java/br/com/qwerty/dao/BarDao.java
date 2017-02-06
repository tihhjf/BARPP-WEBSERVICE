package br.com.qwerty.dao;

import br.com.qwerty.entidade.Bar;

public class BarDao extends GenericDao<Bar, Integer>{
	
	public BarDao() {
		super(Bar.class);
	}
}
