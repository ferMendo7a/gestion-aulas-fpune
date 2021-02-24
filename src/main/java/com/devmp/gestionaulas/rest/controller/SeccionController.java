package com.devmp.gestionaulas.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.domain.model.Seccion;
import com.devmp.gestionaulas.domain.repository.ISeccionRepository;

@RestController
@RequestMapping(path = "/seccion")
public class SeccionController {

	@Autowired
	private ISeccionRepository service;

	@GetMapping
	public ResponseEntity<List<Seccion>> getAll() {
		List<Seccion> retorno = service.findAll();
		return ResponseEntity.ok().body(retorno);
	}

	@PostMapping(path = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Seccion semestre) {
		Seccion res = service.save(semestre);
		if (res != null) {
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.badRequest().body(res);
		}
	}

}
