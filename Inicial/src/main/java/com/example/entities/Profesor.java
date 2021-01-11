package com.example.entities;

public class Profesor {
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	
	public Profesor() { }
	public Profesor(int id) {
		this.id = id;
	}
	public Profesor(int id, String nombre, String apellidos, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Profesor))
			return false;
		return id == ((Profesor) obj).id;
	}
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + " " + apellidos + "]";
	}
	
	// Validación
	
	// Reglas de negocio
		
}
