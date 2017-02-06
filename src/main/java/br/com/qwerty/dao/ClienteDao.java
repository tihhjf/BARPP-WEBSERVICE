package br.com.qwerty.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.qwerty.entidade.Cliente;
import br.com.qwerty.helper.JPAHelper;

public class ClienteDao extends GenericDao<Cliente, Integer>{

	public ClienteDao() {
		super(Cliente.class);
	}
	
	public Cliente buscarComCheckin(int id){
		Cliente cliente = null;
		String query = "SELECT c FROM Cliente c "
				+ " JOIN FETCH c.checkinList "
				+ " WHERE c.id = :id";
		
		EntityManager manager = JPAHelper.getEntityManager();
		
		Query q = manager.createQuery(query);
		q.setParameter("id", id);

		manager.getTransaction().begin();
		cliente = (Cliente) q.getSingleResult();
		manager.close();
		
		return cliente;
	}
}
