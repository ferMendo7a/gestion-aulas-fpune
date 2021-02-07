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

import com.devmp.gestionaulas.model.Periodo;
import com.devmp.gestionaulas.service.PeriodoService;

@Secured("ROLE_ADMIN")
@RestController
@RequestMapping(path = "/periodo")
public class PeriodoController {

	@Autowired
	private PeriodoService service;

	@GetMapping
	public ResponseEntity<List<Periodo>> getAll() {
		List<Periodo> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

	@PostMapping(path = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Periodo periodo) {
		Periodo res = service.insertOrUpdate(periodo);
		if (res != null) {
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.badRequest().body(res);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		try {
			Periodo res = service.findById(id);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

}
