package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.CheckoutDao;
import br.com.qwerty.entidade.Checkout;

public class CheckoutService {
	
	CheckoutDao checkoutDao = new CheckoutDao();
	
	public void salvar(Checkout checkout){
		checkoutDao.salvar(checkout);
	}
	
	public void atualizar(Checkout checkout){
		checkoutDao.atualizar(checkout);
	}
	
	public Checkout buscar(int id){
		return checkoutDao.buscarPorId(id);
	}
	
	public List<Checkout> buscarTodos(){
		return checkoutDao.buscarTodos();
	}
	
	public void remover(int id){
		checkoutDao.remover(id);
	}

}
