package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.CarreraSeccion;
import com.devmp.gestionaulas.model.pk.CarreraSeccionPK;
import com.devmp.gestionaulas.repository.ICarreraSeccionRepository;

@Service
public class CarreraSeccionService {

	@Autowired
	private ICarreraSeccionRepository repository;

	public List<CarreraSeccion> getAll() {
		return repository.findAll();
	}

	public CarreraSeccion insertOrUpdate(CarreraSeccion carreraSeccion) {
		CarreraSeccionPK pk = new CarreraSeccionPK(carreraSeccion.getCarrera().getId(),
				carreraSeccion.getSeccion().getId());
		carreraSeccion.setPk(pk);
		return repository.save(carreraSeccion);
	}

}
