package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.PedidoDao;
import br.com.qwerty.entidade.Pedido;

public class PedidoService {

	PedidoDao pedidoDao = new PedidoDao();
	
	public void salvar(Pedido pedido){
		pedidoDao.salvar(pedido);
	}
	
	public void atualizar(Pedido pedido){
		pedidoDao.atualizar(pedido);
	}
	
	public Pedido buscar(int id){
		return pedidoDao.buscarPorId(id);
	}
	
	public List<Pedido> buscarTodos(){
		return pedidoDao.buscarTodos();
	}
	
	public void remover(int id){
		pedidoDao.remover(id);
	}
}
