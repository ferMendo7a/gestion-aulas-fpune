package com.devmp.gestionaulas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.model.Aula;
import com.devmp.gestionaulas.service.AulaService;

@RestController
@RequestMapping(path = "/aula")
public class AulaController {

	@Autowired
	private AulaService service;

	@GetMapping
	public ResponseEntity<List<Aula>> getAll() {
		List<Aula> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

}
