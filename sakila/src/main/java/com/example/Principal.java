package com.example;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;

import com.example.entities.Actor;
import com.example.entities.Film;
import com.example.entities.Language;
import com.example.entities.Staff;
import com.example.types.ParentalGuidance;

public class Principal {

	public static void main(String[] args) {
//		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
////		em.createQuery("from Actor").getResultStream()
////			.forEach(item -> System.out.println(item));
////		var actor = em.find(Actor.class, 1);
//		em.getTransaction().begin();
////		actor.setFirstName(actor.getFirstName().toUpperCase());
//		var idioma = em.getReference(Language.class, 8);
//		System.out.println(idioma.getClass().getName());
//		System.out.println(idioma.getLanguageId());
//		System.out.println(idioma.getName());
//		em.refresh(idioma);
////		em.remove(idioma);
////		idioma = null;
//		System.out.println(idioma.getLastUpdate());

//		var idioma = em.find(Language.class, 8);
//		var idioma = new Language(8, null, Timestamp.valueOf("2020-01-01 00:00:00"));
//		System.out.println(idioma.getName());
//		idioma.setName(null);
//		System.out.println(idioma.getName());
//		em.merge(idioma);
//		em.getTransaction().commit();
//		em.close();
//		em = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		actor = em.find(Actor.class, 1);
//		System.out.println(actor);
//		System.out.println(actor.getLastUpdate());
//		System.out.println(actor.getClass().getName());
//		em.close();
//		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		var peli = em.find(Film.class, 1);
//		em.getTransaction().begin();
//		System.out.println(peli.getRating());
//		peli.setRating(ParentalGuidance.ParentalGuidanceSuggested);
//		System.out.println(peli.getRating());
//		em.getTransaction().commit();
//		em.close();
//		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		var peli = em.find(Film.class, 1);
//		System.out.println(peli.getFilmId());
//		System.out.println(peli.getTitle());
//		System.out.println(peli.getDescription());
//		em.close();
//		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		var emp = em.find(Staff.class, 1);
//		System.out.println(emp.getUsuario().getUsername());
//		System.out.println(emp.getFirstName());
//		em.close();

		EntityManager em1 = HibernateUtil.getEntityManagerFactory().createEntityManager();
		EntityManager em2 = HibernateUtil.getEntityManagerFactory().createEntityManager();
		em1.getTransaction().begin();
		em2.getTransaction().begin();
		var idioma1 = em1.find(Language.class, 8, LockModeType.PESSIMISTIC_READ);
		var idioma2 = em2.find(Language.class, 8);
		idioma1.setName("Hungaro");
		em1.getTransaction().commit();
		System.out.println("OK1");
		em1.close();
		try {
			idioma2.setName(idioma2.getName() + "X");
			em2.getTransaction().commit();
			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println("ERROR: " + e.toString());
			em2.getTransaction().rollback();
		} finally {
			em2.close();
		}
		System.out.println("FIN");
	}

}
