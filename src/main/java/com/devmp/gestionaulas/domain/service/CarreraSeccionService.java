package com.devmp.gestionaulas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.domain.model.CarreraSeccion;
import com.devmp.gestionaulas.domain.model.pk.CarreraSeccionPK;
import com.devmp.gestionaulas.domain.repository.ICarreraSeccionRepository;

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
