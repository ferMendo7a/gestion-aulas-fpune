package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Distribucion;
import com.devmp.gestionaulas.repository.IDistribucionRepository;

@Service
public class DistribucionService {

	@Autowired
	private IDistribucionRepository repository;

	public List<Distribucion> getAll() {
		return repository.findAll();
	}

}
