package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante> findeAll() throws DataAccessException;
	
	public void insert(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer codigo) throws DataAccessException;

	public List<Estudiante> filtrarPor(String nombre) throws DataAccessException;

	List<Estudiante> empiezaCon(String apellido) throws DataAccessException;

	Estudiante buscarId(Integer codigo) throws DataAccessException;
	
}
