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
		Profesor profesor = session.get(Profesor.class, 1);
		if(profesor == null)
			System.out.println("No existe el profesor");
		else 
			System.out.println(session.get(Profesor.class, 1));
		session.close();
		
//		session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		profesor = session.get(Profesor.class, 1);
//		if(profesor == null)
//			System.out.println("No existe el profesor");
//		else {
//			profesor.setApellidos(profesor.getApellidos().toUpperCase());
//		}
//		session.getTransaction().commit();
//		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		profesor = session.get(Profesor.class, 1);
		session.getTransaction().commit();
		session.close();
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		if(profesor == null)
			System.out.println("No existe el profesor");
		else {
			System.out.println("Modifico");
			//profesor.setId(33);
			profesor = session.get(Profesor.class, 1);
			profesor.setApellidos(profesor.getApellidos().toUpperCase());
			//session.update(new Profesor(1, "PPPPepito", "Grillo", 99));
			//session.saveOrUpdate(new Profesor(1, "PPPPepito", "Grillo", 99));
		}
		session.getTransaction().commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.createQuery("from Profesor").getResultStream()
			.forEach(item -> System.out.println(item));
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		if(profesor == null)
			System.out.println("No existe el profesor");
		else {
			profesor = session.get(Profesor.class, 1);
			profesor.setApellidos(profesor.getApellidos().toUpperCase());
			session.delete(profesor);
			session.delete(new Profesor(3));
		}
		session.getTransaction().commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.createQuery("from Profesor").getResultStream()
			.forEach(item -> System.out.println(item));
		session.close();
		
	}

}
