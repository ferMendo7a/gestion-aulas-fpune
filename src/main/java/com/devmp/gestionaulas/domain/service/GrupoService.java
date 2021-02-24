package com.devmp.gestionaulas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.domain.model.Grupo;
import com.devmp.gestionaulas.domain.repository.IGrupoRepository;

@Service
public class GrupoService {

	private static final String GRUPO_PAGINA = "GRUPOS";

	@Autowired
	private IGrupoRepository repository;

	public List<Grupo> getAll() throws Exception {
		return repository.findAll();
	}

	public Grupo insertOrUpdate(Grupo grupo) {
		return repository.save(grupo);
	}

	public Grupo findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
