package com.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static final EntityManagerFactory emf = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("JPA_PU");
		}
		catch (Exception ex) {
			System.err.println("Initial EntityManagerFactory creation failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
