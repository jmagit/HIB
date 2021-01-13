package com.example;

import javax.persistence.EntityManager;

import com.example.entities.Actor;
import com.example.entities.Film;
import com.example.entities.Language;
import com.example.entities.Staff;
import com.example.types.ParentalGuidance;

public class Principal {

	public static void main(String[] args) {
//		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		em.createQuery("from Actor").getResultStream()
//			.forEach(item -> System.out.println(item));
//		var actor = em.find(Actor.class, 1);
//		em.getTransaction().begin();
//		actor.setFirstName(actor.getFirstName().toUpperCase());
//		var idioma = em.find(Language.class, 8);
//		idioma.setName("Español");
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
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		var peli = em.find(Film.class, 1);
		System.out.println(peli.getFilmId());
		System.out.println(peli.getTitle());
		System.out.println(peli.getDescription());
		em.close();
//		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		var emp = em.find(Staff.class, 1);
//		System.out.println(emp.getUsuario().getUsername());
//		System.out.println(emp.getFirstName());
//		em.close();

	}

}
