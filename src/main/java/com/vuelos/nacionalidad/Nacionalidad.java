package com.vuelos.nacionalidad;

public class Nacionalidad {
	private int id;
	private String nombre;
	
	//Constructor
	public Nacionalidad(int id, String nombre) {
	this.setId(id);
	this.setNombre(nombre);	
	}
	
	//Getters y setters

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
	
	//to string para mostrar el ComboBox
	@Override
	public String toString() {
		return nombre;
	}	

}
