package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.ProdutoDao;
import br.com.qwerty.entidade.Produto;

public class ProdutoService {
	
	ProdutoDao produtoDao = new ProdutoDao();
	
	public void salvar(Produto produto){
		produtoDao.salvar(produto);
	}
	
	public void atualizar(Produto produto){
		produtoDao.atualizar(produto);
	}
	
	public Produto buscar(int id){
		return produtoDao.buscarPorId(id);
	}
	
	public List<Produto> buscarTodos(){
		return produtoDao.buscarTodos();
	}
	
	public void remover(int id){
		produtoDao.remover(id);
	}
}
