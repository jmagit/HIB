package com.example;

import org.hibernate.Session;

import com.example.entities.Profesor;

public class Principal {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new Profesor(1, "Pepito", "Grillo", 99));
		session.save(new Profesor(2, "Carmelo", "Cotos", 25));
		session.save(new Profesor(0, "Pedro", "Pica Priedra", 41));
		session.getTransaction().commit();
		session.close();
		session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(session.get(Profesor.class, 1));
		session.close();
	}

}
