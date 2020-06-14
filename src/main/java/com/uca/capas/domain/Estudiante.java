package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_usuario;
	
	@Column(name="nombre")
	@NotEmpty(message = "No puede quedar el campo vacio!")
	@Size(max = 25, min = 5, message = "El nombre debe ser de maximo 25 y minimo de 5!")
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty(message = "No puede quedar el campo vacio!")
	@Size(max = 25, min = 5, message = "El apellido debe ser de maximo 25 y minimo de 5!")
	private String apellido;
	
	@Column(name="carne")
	@NotEmpty(message = "No puede quedar el campo vacio!")
	@Size(max = 8, min = 8, message = "El carnet debe ser de 8 caracteres!")
	private String carne;
	
	@Column(name="carrera")
	@NotEmpty(message = "No puede quedar el campo vacio!")
	@Size(max = 25, min = 5, message = "El nombre debe ser de maximo 50 y minimo de 5!")
	private String carrera;
	
	public Integer getC_usuario() {
		return c_usuario;
	}
	public void setC_usuario(Integer c_usuario) {
		this.c_usuario = c_usuario;
	}
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
	public String getCarne() {
		return carne;
	}
	public void setCarne(String carne) {
		this.carne = carne;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public Estudiante() {
		
	}
	
	public Estudiante(String nombre, String apellido, String carne, String carrera) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.carne = carne;
		this.carrera = carrera;
	}
	
}
