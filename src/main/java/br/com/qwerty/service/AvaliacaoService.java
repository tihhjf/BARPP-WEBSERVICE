package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.AvaliacaoDao;
import br.com.qwerty.entidade.Avaliacao;

public class AvaliacaoService {

	AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
	
	public void salvar(Avaliacao avaliacao){
		avaliacaoDao.salvar(avaliacao);
	}
	
	public void atualizar(Avaliacao avaliacao){
		avaliacaoDao.atualizar(avaliacao);
	}
	
	public Avaliacao buscar(int id){
		return avaliacaoDao.buscarPorId(id);
	}
	
	public List<Avaliacao> buscarTodos(){
		return avaliacaoDao.buscarTodos();
	}
	
	public void remover(int id){
		avaliacaoDao.remover(id);
	}
}
