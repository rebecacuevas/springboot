package com.generetion.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// inyección de dependencias, entra Spring en acción
@RestController
public class Saludo {

	@GetMapping("/")
	public String saludo() {
		return "Fuga";
	}

	// datos no sensibles
	@GetMapping("/saludo")
	public String hello(@RequestParam(value = "nombre", defaultValue = "Java") String nombre,
		@RequestParam(value = "apellidos", defaultValue = "Script") String apellidos) {
		return "Hola " + nombre + " " + apellidos;
	}
	
	// datos sensibles
	@PostMapping("/login")
	public String login(@RequestParam(value = "correo") String correo,
		@RequestParam(value = "password") String password) {
		return correo + " " + password;
	}

}
