package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.ClienteDao;
import br.com.qwerty.entidade.Cliente;

public class ClienteService {

	ClienteDao clienteDao = new ClienteDao();
	
	public void salvar(Cliente cliente){
		clienteDao.salvar(cliente);
	}
	
	public void atualizar(Cliente cliente){
		clienteDao.atualizar(cliente);
	}
	
	public Cliente buscar(int id){
		return clienteDao.buscarPorId(id);
	}

	public List<Cliente> buscarTodos(){
		return clienteDao.buscarTodos();
	}
	
	public void remover(int id){
		clienteDao.remover(id);
	}
	
	public Cliente buscarComCheckin(int id){
		return clienteDao.buscarComCheckin(id);
	}
}
