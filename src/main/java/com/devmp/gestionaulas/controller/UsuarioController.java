package com.devmp.gestionaulas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.model.Usuario;
import com.devmp.gestionaulas.service.UsuarioService;

@Secured("ROLE_ADMIN")
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

	@GetMapping("/activos")
	public ResponseEntity<List<Usuario>> getAllActivos() {
		List<Usuario> retorno = service.getUsuariosActivos();
		return ResponseEntity.ok().body(retorno);
	}

	@PostMapping(path = "/guardar")
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
		Usuario u = service.insertOrUpdate(usuario);
		if (u != null) {
			return ResponseEntity.ok(u);
		} else {
			return ResponseEntity.badRequest().body(u);
		}
	}

	@PostMapping(path = "/nuevo")
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
		Usuario u = service.registrarNuevoUsuario(usuario);
		if (u != null) {
			return ResponseEntity.ok(u);
		} else {
			return ResponseEntity.badRequest().body(u);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		try {
			Usuario u = service.findById(id);
			return ResponseEntity.ok(u);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

}
