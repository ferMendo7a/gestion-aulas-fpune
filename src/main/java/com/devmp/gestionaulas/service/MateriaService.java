package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Materia;
import com.devmp.gestionaulas.repository.IMateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private IMateriaRepository repository;

	public List<Materia> getAll() {
		return repository.findAll();
	}

	public Materia insertOrUpdate(Materia materia) {
		return repository.save(materia);
	}

	public Materia findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
