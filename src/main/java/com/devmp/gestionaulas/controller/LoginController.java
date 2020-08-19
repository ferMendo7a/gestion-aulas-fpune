package com.devmp.gestionaulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.service.UsuarioService;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	private UsuarioService service;

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@GetMapping("/usuario-conectado")
	public ResponseEntity<?> logged() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return ResponseEntity.ok(service.cargarDatosUsuarioConectado(auth.getName()));
	}

}
