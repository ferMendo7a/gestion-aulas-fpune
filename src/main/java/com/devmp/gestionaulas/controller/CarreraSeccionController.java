package com.devmp.gestionaulas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.model.CarreraSeccion;
import com.devmp.gestionaulas.service.CarreraSeccionService;

@Secured("ROLE_ADMIN")
@RestController
@RequestMapping(path = "/carrera-seccion")
public class CarreraSeccionController {

	@Autowired
	private CarreraSeccionService service;

	@GetMapping
	public ResponseEntity<List<CarreraSeccion>> getAll() {
		List<CarreraSeccion> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

	@PostMapping(path = "/guardar", consumes = { "application/json" })
	public ResponseEntity<?> guardar(@RequestBody CarreraSeccion carreraSeccion) {
		CarreraSeccion res = service.insertOrUpdate(carreraSeccion);
		if (res != null) {
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.badRequest().body(res);
		}
	}

}
