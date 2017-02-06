package br.com.qwerty.dao;

import br.com.qwerty.entidade.Produto;

public class ProdutoDao extends GenericDao<Produto, Integer>{

	public ProdutoDao() {
		super(Produto.class);
	}
}
