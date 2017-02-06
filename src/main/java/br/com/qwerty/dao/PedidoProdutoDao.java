package br.com.qwerty.dao;

import br.com.qwerty.entidade.PedidoProduto;

public class PedidoProdutoDao extends GenericDao<PedidoProduto, Integer>{

	public PedidoProdutoDao() {
		super(PedidoProduto.class);
	}
}
