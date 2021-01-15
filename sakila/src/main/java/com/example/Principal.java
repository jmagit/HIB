package com.example;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;

import com.example.entities.Actor;
import com.example.entities.City;
import com.example.entities.Country;
import com.example.entities.Film;
import com.example.entities.Language;
import com.example.entities.Staff;
import com.example.entities.dtos.ActorDTO;
import com.example.entities.dtos.FilmEditDTO;
import com.example.types.ParentalGuidance;

import jakarta.validation.Valid;

public class Principal {

	public static void main(String[] args) {
		//relacionesOneToOne();
		// relacionesManyToMany();
		// recuperacion();
		consultas();
	}
	public static void consultas() {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		em.createQuery("from Actor a, Language l").getResultStream()
//			.map(a -> (Object[])a)
//			.forEach(a -> System.out.println(((Object[])a)[0].toString() + "-" + ((Object[])a)[1].toString()));
//		em.createQuery("select distinct a from Actor a left join fetch a.filmActors f left join fetch f.film p" /*where f.film.filmId = 1"*/, Actor.class).getResultStream()
////		.forEach(a -> System.out.println(((Object[])a)[0].toString() + "-" + ((Object[])a)[1].toString()));
//		.forEach(a -> a.getFilmActors().forEach(System.out::println));

//		em.createQuery("select new com.example.entities.dtos.ActorDTO(a) from Actor a", ActorDTO.class)
//			.getResultStream().forEach(a -> System.out.println(a.getId() + " -> " + a.getNombre()));
		em.createQuery("from Actor a", Actor.class)
			.getResultStream()
			.map(a-> new ActorDTO(a))
			.forEach(a -> System.out.println(a.getId() + " -> " + a.getNombre()));
		em.close();
	}
	public void post(@Valid FilmEditDTO send) {
//		if(FilmEditDTO.from(send).isNotValid()) {
//			
//		}
//		Film p = em.find();
//		send.update(p);
		
	}
	public static void consultas1() {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		int np = 7, rows = 20;
		boolean paginado = true;
		em.getTransaction().begin();
		System.out.println("Creo");
		TypedQuery<Actor> q = em.createNamedQuery("Actor.findAll", Actor.class);
		System.out.println("Configuro");
//		q.setHint( "org.hibernate.readOnly", true );
		if(paginado) {
			q.setMaxResults(rows);
			q.setFirstResult(np * rows);
		}
		System.out.println("solicito");
		List<Actor> lst = q.getResultList();
		System.out.println("proceso");
		lst.forEach(System.out::println);
		System.out.println("termino");
		Actor actor = lst.get(1);
		actor.setFirstName("kkkkkk");
		em.getTransaction().commit();
		em.close();
	}
	public static void consultas2() {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		int np = 7, rows = 20;
		boolean paginado = true;
		em.getTransaction().begin();
		System.out.println("Creo");
		TypedQuery<Actor> q = em.createQuery("select a from Actor a", Actor.class);
		System.out.println("Configuro");
		q.setHint( "org.hibernate.readOnly", true );
		if(paginado) {
			q.setMaxResults(rows);
			q.setFirstResult(np * rows);
		}
		System.out.println("solicito");
		List<Actor> lst = q.getResultList();
		System.out.println("proceso");
		lst.forEach(System.out::println);
		System.out.println("termino");
		Actor actor = lst.get(1);
		actor.setFirstName("kkkkkk");
		em.getTransaction().commit();
		em.close();
	}
	public static void recuperacion() {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		var f = em.find(Film.class, 3);
		System.out.println("---------");
//		f.getFilmActors().stream().map(item -> item.getActor()).forEach(item -> System.out.println(item));
//		em.createQuery("from Film f where f.filmId < 10", Film.class).getResultStream()
//			.forEach(f -> f.getFilmActors().stream().map(item -> item.getActor()).forEach(item -> System.out.println(item)));
		em.close();
		f.getFilmActors().stream().map(item -> item.getActor()).forEach(item -> System.out.println(item));
	}
	public static void relacionesManyToMany() {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

		// var c = new City(7791, "Barcelona", em.getReference(Country.class, 113));
		
		em.getTransaction().begin();
		City c = em.find(City.class, 7791);
		// var kk = c.getPeliculas();
		em.getTransaction().commit();
		em.close();
		em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();

//		c.getPeliculas().add(em.find(Film.class, 3));
//		c.setCity("BARCELONA");
		//c.setCity("Barcelona");
//		c.getPeliculas().add(em.find(Film.class, 33));
//		var c = em.find(City.class, 7791);
		
		em.merge(c);
		c.getPeliculas().add(em.find(Film.class, 44));
//		var c = em.find(City.class, 7791);
//		c.setCity("BARCELONA");
//		var p = em.find(Film.class, 11);
//		//c.getPeliculas().remove(0);
//		c.getPeliculas().add(p);
//		// p.getCiudades().add(c);
//		c.getPeliculas().add(em.find(Film.class, 3));
		em.getTransaction().commit();
		em.close();
		System.out.println("FIN");
	}
	public static void relacionesOneToOne() {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
//		var p = new Country(0, "Cataluña");
//		var c = new City(0, "Barcelona");
////		p.getCities().add(c);
////		c.setCountry(em.find(Country.class, 1));
//		p.addCity(c);
//		p.addCity(new City(0, "Lleida", em.find(Country.class, 1)));
//		em.persist(p);

//		var p = em.find(Country.class, 113);
//		p.getCities().add(new City(0, "Tarragona", em.find(Country.class, 1)));
//		System.out.println(p.getCities().getClass().getName());
//		var p = em.find(Country.class, 113);
//		p.getCities().get(0).setCity("dddd");
		var c = new City(0, "Girona", new Country(0, "Cataluñaaaa"));
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		System.out.println("FIN");
	}
	public static void ejemplos() {
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

//		EntityManager em1 = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		EntityManager em2 = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		em1.getTransaction().begin();
//		em2.getTransaction().begin();
//		var idioma1 = em1.find(Language.class, 8, LockModeType.PESSIMISTIC_READ);
//		var idioma2 = em2.find(Language.class, 8);
//		idioma1.setName("Hungaro");
//		em1.getTransaction().commit();
//		System.out.println("OK1");
//		em1.close();
//		try {
//			idioma2.setName(idioma2.getName() + "X");
//			em2.getTransaction().commit();
//			System.out.println("OK2");
//		} catch (Exception e) {
//			System.out.println("ERROR: " + e.toString());
//			em2.getTransaction().rollback();
//		} finally {
//			em2.close();
//		}
		var i = new Language(0, null, null);
		System.err.println(i.isValid() ? "valido" : "invalido");
		i.getErrors().stream().forEach(item -> System.out.println(item.getMessage()));
		i.setName("");
		System.err.println(i.isValid() ? "valido" : "invalido");
		i.getErrors().stream().forEach(item -> System.out.println(item.getMessage()));
		i.setName("   ");
		System.err.println(i.isValid() ? "valido" : "invalido");
		i.getErrors().stream().forEach(item -> System.out.println(item.getMessage()));
		i.setName("algo");
		System.err.println(i.isValid() ? "valido" : "invalido");
		i.getErrors().stream().forEach(item -> System.out.println(item.getMessage()));
		i.setName("ALGO");
		System.err.println(i.isValid() ? "valido" : "invalido");
		i.getErrors().stream().forEach(item -> System.out.println(item.getMessage()));
		
		System.out.println("FIN");
	}

}
