package com.generation.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.demo.models.SalonModel;
import com.generation.demo.services.SalonService;

// con esta anotaci�n se convierte esta clase en un controlador
@RestController
public class EscuelaController {
	
	private final SalonService salonService;
	
	// hacer inyecci�n de dependencias usando un constructor p�blico
	public EscuelaController(@Autowired SalonService salonService) {
		this.salonService = salonService;
	}
	
	// mostrar datos de sal�n
	@GetMapping("/salon")
	public ArrayList<SalonModel> obtenerDatos() {
		return salonService.obtenerDatos();
	}
	
	// guardar datos en la tabla sal�n
	@PostMapping("/salon")
	public SalonModel guardarDatos(@RequestBody SalonModel salonModel) {
		return salonService.guardarDatos(salonModel);
	}
	
	// eliminar dato
	@DeleteMapping(path = "salon/{id}") //localhost:8080/salon/1
	public boolean eliminarDato(@PathVariable("id") Integer id) {
		return salonService.eliminarDatos(id);
	}
	
}
