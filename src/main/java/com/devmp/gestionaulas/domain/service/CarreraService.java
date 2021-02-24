package com.devmp.gestionaulas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.domain.model.Carrera;
import com.devmp.gestionaulas.domain.repository.ICarreraRepository;

@Service
public class CarreraService {

	@Autowired
	private ICarreraRepository repository;

	public List<Carrera> getAll() {
		return repository.findAll();
	}

	public Carrera insertOrUpdate(Carrera carrera) {
		return repository.save(carrera);
	}

	public Carrera findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
