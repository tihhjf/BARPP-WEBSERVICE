package br.com.qwerty.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JPAHelper {

	private static EntityManagerFactory emf;
	
	private static EntityManagerFactory getEntityManagerFactory(){
		if(emf==null){
			emf = Persistence.createEntityManagerFactory("Barpp-WebService");
		}
		return emf;
	}
	
	public static EntityManager getEntityManager(){
		return getEntityManagerFactory().createEntityManager();
	}
}
