package com.devmp.gestionaulas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/todos")
	public ResponseEntity<List<Distribucion>> getAll() {
		List<Distribucion> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Distribucion> save(@RequestBody Distribucion distribucion) {
		Distribucion retorno = service.guardar(distribucion);
		return ResponseEntity.ok().body(retorno);
	}

}
