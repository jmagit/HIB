package com.example;

import javax.persistence.EntityManager;

public class Principal {

	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		em.createQuery("from Actor").getResultStream()
			.forEach(item -> System.out.println(item));
		em.close();
	}

}
