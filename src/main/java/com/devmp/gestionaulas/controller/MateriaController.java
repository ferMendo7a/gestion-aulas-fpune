package com.devmp.gestionaulas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.model.Materia;
import com.devmp.gestionaulas.service.MateriaService;

@RestController
@RequestMapping(path = "/materia")
public class MateriaController {

	@Autowired
	private MateriaService service;

	@GetMapping
	public ResponseEntity<List<Materia>> getAll() {
		List<Materia> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

}
