package br.com.qwerty.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.qwerty.helper.JPAHelper;

public abstract class GenericDao<T, I extends Serializable> {
	
	private EntityManager manager = JPAHelper.getEntityManager();
	
	private Class<T> persistedClass;
	
	protected GenericDao(){
	}
	
	protected GenericDao(Class<T> persistedClass){
		this();
		this.persistedClass = persistedClass;
	}
	
	public void salvar(T entity) {
		   EntityTransaction t = manager.getTransaction();
		   t.begin();
		   manager.persist(entity);
		   manager.flush();
		   t.commit();
	   }

	   public T atualizar(T entity) {
		   EntityTransaction t = manager.getTransaction();
		   t.begin();
		   manager.merge(entity);
		   manager.flush();
	       t.commit();
	       return entity;
	   }

	   public void remover(I id) {
	       T entity = buscarPorId(id);
	       EntityTransaction t = manager.getTransaction();
		   t.begin();
	       T mergedEntity = manager.merge(entity);
	       manager.remove(mergedEntity);
	       manager.flush();
	       t.commit();
	   }

	   public List<T> buscarTodos() {
	       CriteriaBuilder builder = manager.getCriteriaBuilder();
	       CriteriaQuery<T> query = builder.createQuery(persistedClass);
	       query.from(persistedClass);
	       return manager.createQuery(query).getResultList();
	   }

	   public T buscarPorId(I id) {
	       return manager.find(persistedClass, id);
	   }
}
