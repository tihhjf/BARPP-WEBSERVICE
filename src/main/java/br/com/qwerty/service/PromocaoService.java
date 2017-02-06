package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.PromocaoDao;
import br.com.qwerty.entidade.Promocao;

public class PromocaoService {

	PromocaoDao promocaoDao = new PromocaoDao();
	
	public void salvar(Promocao promocao){
		promocaoDao.salvar(promocao);
	}
	
	public void atualizar(Promocao promocao){
		promocaoDao.atualizar(promocao);
	}
	
	public Promocao buscar(int id){
		return promocaoDao.buscarPorId(id);
	}
	
	public List<Promocao> buscarTodos(){
		return promocaoDao.buscarTodos();
	}
	
	public void remover(int id){
		promocaoDao.remover(id);
	}
}
