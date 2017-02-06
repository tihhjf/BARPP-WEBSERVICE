package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.EnderecoDao;
import br.com.qwerty.entidade.Endereco;

public class EnderecoService {

	EnderecoDao enderecoDao = new EnderecoDao();
	
	public void salvar(Endereco endereco){
		enderecoDao.salvar(endereco);
	}
	
	public void atualizar(Endereco endereco){
		enderecoDao.atualizar(endereco);
	}
	
	public Endereco buscar(int id){
		return enderecoDao.buscarPorId(id);
	}
	
	public List<Endereco> buscarTodos(){
		return enderecoDao.buscarTodos();
	}
	
	public void remover(int id){
		enderecoDao.remover(id);
	}
}
