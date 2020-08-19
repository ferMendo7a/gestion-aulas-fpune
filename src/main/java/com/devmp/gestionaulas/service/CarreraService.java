package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Carrera;
import com.devmp.gestionaulas.repository.ICarreraRepository;

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
