package com.devmp.gestionaulas.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.domain.model.Carrera;
import com.devmp.gestionaulas.domain.service.CarreraService;

@RestController
@RequestMapping(path = "/carrera")
public class CarreraController {

	@Autowired
	private CarreraService service;

	@GetMapping
	public ResponseEntity<List<Carrera>> getAll() {
		List<Carrera> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

	@PostMapping(path = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Carrera carrera) {
		Carrera res = service.insertOrUpdate(carrera);
		if (res != null) {
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.badRequest().body(res);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		try {
			Carrera res = service.findById(id);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

}
