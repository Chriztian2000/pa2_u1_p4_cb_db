package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
@Component 

public class Profesor {

	
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimienti;
	private String cedula;
		
	
	
	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimienti=" + fechaNacimienti
				+ ", cedula=" + cedula + "]";
	}
	
	//Metodos set y get
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDateTime getFechaNacimienti() {
		return fechaNacimienti;
	}
	public void setFechaNacimienti(LocalDateTime fechaNacimienti) {
		this.fechaNacimienti = fechaNacimienti;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
