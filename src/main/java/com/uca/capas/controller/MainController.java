package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteServiceImpl estudianteService;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		Estudiante estudiante = new Estudiante();
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/guardarEstudiante")
	public ModelAndView insertar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				estudianteService.insert(estudiante);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteService.findeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping(value = "/ModificarEstudiante", method = RequestMethod.POST)
	public ModelAndView modify(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteService.buscarId(id);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante", estudiante);
		mav.setViewName("modificar");
		return mav;
	}
	
	@RequestMapping(value = "/borrarEstudiante", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudianteService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			estudiantes = estudianteService.findeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping(value = "/filtrar", method = RequestMethod.POST)
	public ModelAndView filtro(@RequestParam(value="nombre") String nombre) { 
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteService.filtrarPor(nombre);
			//estudiantes = estudianteService.empiezaCon(nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping("/modify")
	public ModelAndView modify(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				estudianteService.insert(estudiante);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Estudiante> estudiantes = null;
			try {
				estudiantes = estudianteService.findeAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("estudiantes", estudiantes);
		}
		mav.setViewName("listado");
		return mav;
	}
}
