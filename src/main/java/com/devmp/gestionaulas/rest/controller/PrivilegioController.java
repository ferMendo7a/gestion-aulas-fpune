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

import com.devmp.gestionaulas.domain.model.Privilegio;
import com.devmp.gestionaulas.domain.service.PrivilegioService;

@RestController
@RequestMapping(path = "/privilegio")
public class PrivilegioController {

	@Autowired
	private PrivilegioService service;

	@GetMapping
	public ResponseEntity<?> getAll() {
		try {
			List<Privilegio> retorno;
			retorno = service.getAll();
			return ResponseEntity.ok().body(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	@PostMapping(path = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Privilegio privilegio) {
		Privilegio res = service.insertOrUpdate(privilegio);
		if (res != null) {
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.badRequest().body(res);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		try {
			Privilegio res = service.findById(id);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

}
