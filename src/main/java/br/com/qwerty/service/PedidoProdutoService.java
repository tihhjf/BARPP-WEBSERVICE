package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.PedidoProdutoDao;
import br.com.qwerty.entidade.PedidoProduto;

public class PedidoProdutoService {
	
	PedidoProdutoDao pedidoProdutoDao = new PedidoProdutoDao();
	
	public void salvar(PedidoProduto pedidoProduto){
		pedidoProdutoDao.salvar(pedidoProduto);
	}
	
	public void atualizar(PedidoProduto pedidoProduto){
		pedidoProdutoDao.atualizar(pedidoProduto);
	}
	
	public PedidoProduto buscar(int id){
		return pedidoProdutoDao.buscarPorId(id);
	}
	
	public List<PedidoProduto> buscarTodos(){
		return pedidoProdutoDao.buscarTodos();
	}
	
	public void remover(int id){
		pedidoProdutoDao.remover(id);
	}
}
