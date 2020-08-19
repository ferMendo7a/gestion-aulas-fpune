package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Aula;
import com.devmp.gestionaulas.repository.IAulaRepository;

@Service
public class AulaService {

	@Autowired
	private IAulaRepository repository;

	public List<Aula> getAll() {
		return repository.findAll();
	}

	public Aula insertOrUpdate(Aula aula) {
		return repository.save(aula);
	}

	public Aula findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
