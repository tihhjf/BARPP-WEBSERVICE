package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.PromocaoProdutoDao;
import br.com.qwerty.entidade.PromocaoProduto;

public class PromocaoProdutoService {

	PromocaoProdutoDao promocaoProdutoDao = new PromocaoProdutoDao();
	
	public void salvar(PromocaoProduto promocaoProduto){
		promocaoProdutoDao.salvar(promocaoProduto);
	}
	
	public void atualizar(PromocaoProduto promocaoProduto){
		promocaoProdutoDao.atualizar(promocaoProduto);
	}
	
	public PromocaoProduto buscar(int id){
		return promocaoProdutoDao.buscarPorId(id);
	}
	
	public List<PromocaoProduto> buscarTodos(){
		return promocaoProdutoDao.buscarTodos();
	}
	
	public void remover(int id){
		promocaoProdutoDao.remover(id);
	}
}
