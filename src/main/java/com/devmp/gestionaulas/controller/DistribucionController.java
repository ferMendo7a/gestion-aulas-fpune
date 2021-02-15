package com.devmp.gestionaulas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.model.Distribucion;
import com.devmp.gestionaulas.service.DistribucionService;

@RestController
@RequestMapping(path = "/distribucion")
public class DistribucionController {

	@Autowired
	private DistribucionService service;

	@Secured({ "ROLE_ADMIN" })
	@GetMapping
	public ResponseEntity<List<Distribucion>> getAll() {
		List<Distribucion> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

	@Secured({ "ROLE_ADMIN" })
	@PutMapping
	public ResponseEntity<List<Distribucion>> getAll(@RequestBody Distribucion filtroDistribucion) {
		List<Distribucion> retorno = service.getAll(filtroDistribucion);
		return ResponseEntity.ok().body(retorno);
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/guardar")
	public ResponseEntity<Object> save(@RequestBody Distribucion distribucion) {
		Distribucion retorno;
		try {
			retorno = service.insertOrUpdate(distribucion);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

}
