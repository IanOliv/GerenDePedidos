package br.com.IanOliv.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
	public EntityManager getEntiyManager() {

		return Persistence.createEntityManagerFactory("Gerenciador").createEntityManager();
	}

}
