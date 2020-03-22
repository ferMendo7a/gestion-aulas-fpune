package com.devmp.gestionaulas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.model.Carrera;
import com.devmp.gestionaulas.service.CarreraService;

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

}
