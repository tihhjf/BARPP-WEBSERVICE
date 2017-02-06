package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.ColaboradorDao;
import br.com.qwerty.entidade.Colaborador;

public class ColaboradorService {

	ColaboradorDao colaboradorDao = new ColaboradorDao();
	
	public void salvar(Colaborador colaborador){
		colaboradorDao.salvar(colaborador);
	}
	
	public void atualizar(Colaborador colaborador){
		colaboradorDao.atualizar(colaborador);
	}
	
	public Colaborador buscar(int id){
		return colaboradorDao.buscarPorId(id);
	}
	
	public List<Colaborador> buscarTodos(){
		return colaboradorDao.buscarTodos();
	}
	
	public void remover(int id){
		colaboradorDao.remover(id);
	}
}
