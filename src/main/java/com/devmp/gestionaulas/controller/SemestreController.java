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

import com.devmp.gestionaulas.model.Semestre;
import com.devmp.gestionaulas.service.SemestreService;

@Secured("ROLE_ADMIN")
@RestController
@RequestMapping(path = "/semestre")
public class SemestreController {

	@Autowired
	private SemestreService service;

	@GetMapping
	public ResponseEntity<List<Semestre>> getAll() {
		List<Semestre> retorno = service.getAll();
		return ResponseEntity.ok().body(retorno);
	}

	@PostMapping(path = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Semestre aula) {
		Semestre res = service.insertOrUpdate(aula);
		if (res != null) {
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.badRequest().body(res);
		}
	}

}
