package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.BarDao;
import br.com.qwerty.entidade.Bar;

public class BarService {
	
	BarDao barDao = new BarDao();
	
	public void salvar(Bar bar){
		barDao.salvar(bar);
	}
	
	public void atualizar(Bar bar){
		barDao.atualizar(bar);
	}
	
	public Bar buscar(int id){
		return barDao.buscarPorId(id);
	}
	
	public List<Bar> buscarTodos(){
		return barDao.buscarTodos();
	}
	
	public void remover(int id){
		barDao.remover(id);
	}

}
