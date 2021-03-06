package com.devmp.gestionaulas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.domain.model.Semestre;
import com.devmp.gestionaulas.domain.repository.ISemestreRepository;

@Service
public class SemestreService {

	@Autowired
	private ISemestreRepository repository;

	public List<Semestre> getAll() {
		return repository.findAll();
	}

	public Semestre insertOrUpdate(Semestre aula) {
		return repository.save(aula);
	}

	public Semestre findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
