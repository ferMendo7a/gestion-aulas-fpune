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

import com.devmp.gestionaulas.domain.model.Aula;
import com.devmp.gestionaulas.domain.service.AulaService;
import com.devmp.gestionaulas.rest.controller.vo.IntervaloInicioFin;

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

	@PostMapping(path = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Aula aula) {
		Aula res = service.insertOrUpdate(aula);
		if (res != null) {
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.badRequest().body(res);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		try {
			Aula res = service.findById(id);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	@PostMapping("/consulta-disponibles")
	public ResponseEntity<?> getDisponibles(@RequestBody IntervaloInicioFin intervalo) {
		try {
			List<Aula> retorno = service.getAulasDisponibles(intervalo);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

}
