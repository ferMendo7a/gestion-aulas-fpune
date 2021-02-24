package com.devmp.gestionaulas.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.domain.service.UsuarioService;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/usuario-conectado")
	public ResponseEntity<?> logged() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return ResponseEntity.ok(service.cargarDatosUsuarioConectado(auth.getName()));
	}

}
