package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.CheckinDao;
import br.com.qwerty.entidade.Checkin;

public class CheckinService {

	CheckinDao checkinDao = new CheckinDao();
	
	public void salvar(Checkin checkin){
		checkinDao.salvar(checkin);
	}
	
	public void atualizar(Checkin checkin){
		checkinDao.atualizar(checkin);
	}
	
	public Checkin buscar(int id){
		return checkinDao.buscarPorId(id);
	}
	
	public List<Checkin> buscarTodos(){
		return checkinDao.buscarTodos();
	}
	
	public List<Checkin> buscarPorCliente(int id){
		return checkinDao.buscarPorCliente(id);
	}
	
	public List<Checkin> buscarPorBar(int id){
		return checkinDao.buscarPorBar(id);
	}
	
	public void remover(int id){
		checkinDao.remover(id);
	}
}
