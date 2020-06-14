package com.uca.capas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	EstudianteRepo estudianteRepo;

	@Override
	public List<Estudiante> findeAll() throws DataAccessException {
		//return estudianteRepo.findAll();
		return estudianteRepo.mostrarTodos();
	}

	@Override
	public void insert(Estudiante estudiante) throws DataAccessException {
		estudianteRepo.save(estudiante);		
	}

	@Override
	public void delete(Integer codigo) throws DataAccessException {
		estudianteRepo.deleteById(codigo); 
	}
	
	@Override
	public Estudiante buscarId(Integer codigo) throws DataAccessException {
		return estudianteRepo.getOne(codigo);   
	}
	
	@Override
	public List<Estudiante> filtrarPor(String nombre) throws DataAccessException {
		//return estudianteRepo.findByNombre(nombre);
		return estudianteRepo.mostrarPorNombre(nombre);
	}
	
	@Override
	public List<Estudiante> empiezaCon(String apellido) throws DataAccessException {
		return estudianteRepo.findByApellidoStartingWith(apellido);  
	}
	
}
