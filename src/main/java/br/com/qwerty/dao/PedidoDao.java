package br.com.qwerty.dao;

import br.com.qwerty.entidade.Pedido;

public class PedidoDao extends GenericDao<Pedido, Integer>{

	public PedidoDao() {
		super(Pedido.class);
	}
}
