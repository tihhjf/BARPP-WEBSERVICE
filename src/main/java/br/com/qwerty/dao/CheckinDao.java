package br.com.qwerty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.qwerty.entidade.Checkin;
import br.com.qwerty.helper.JPAHelper;

public class CheckinDao extends GenericDao<Checkin, Integer>{
	
	public CheckinDao() {
		super(Checkin.class);
	}
	
	public List<Checkin> buscarPorCliente(int id){
		List<Checkin> chekins = null;
		String query = "SELECT c FROM Checkin c WHERE c.cliente.id = :id";
		
		EntityManager manager = JPAHelper.getEntityManager();
		
		Query q = manager.createQuery(query);
		q.setParameter("id", id);

		manager.getTransaction().begin();
		chekins = (List<Checkin>) q.getResultList();
		manager.close();
		
		return chekins;
	}
	
	public List<Checkin> buscarPorBar(int id){
		List<Checkin> chekins = null;
		String query = "SELECT c FROM Checkin c WHERE c.bar.id = :id";
		
		EntityManager manager = JPAHelper.getEntityManager();
		
		Query q = manager.createQuery(query);
		q.setParameter("id", id);

		manager.getTransaction().begin();
		chekins = (List<Checkin>) q.getResultList();
		manager.close();
		
		return chekins;
	}
}
