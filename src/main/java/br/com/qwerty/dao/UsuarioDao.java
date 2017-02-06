package br.com.qwerty.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.qwerty.entidade.Usuario;
import br.com.qwerty.helper.JPAHelper;

public class UsuarioDao extends GenericDao<Usuario, Integer>{

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	public Usuario login(String email, String senha){
		Usuario usuario = null;
		String query = "SELECT u FROM Usuario u WHERE u.email = :email and u.senha = :senha";
		
		EntityManager manager = JPAHelper.getEntityManager();
		
		Query q = manager.createQuery(query);
		q.setParameter("email", email);
		q.setParameter("senha", senha);

		manager.getTransaction().begin();
		usuario = (Usuario) q.getSingleResult();
		manager.close();
		
		return usuario;
	}
	
	public Usuario buscarPorEmail(String email){
		Usuario usuario = null;
		String query = "SELECT u FROM Usuario u WHERE u.email = :email";
		
		EntityManager manager = JPAHelper.getEntityManager();
		
		Query q = manager.createQuery(query);
		q.setParameter("email", email);

		manager.getTransaction().begin();
		usuario = (Usuario) q.getSingleResult();
		manager.close();
		
		return usuario;
	}
}
