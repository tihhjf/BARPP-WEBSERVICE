package br.com.qwerty.dao;

import br.com.qwerty.entidade.Promocao;

public class PromocaoDao extends GenericDao<Promocao, Integer>{

	public PromocaoDao() {
		super(Promocao.class);
	}
}
