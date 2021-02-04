package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Curso;
import com.devmp.gestionaulas.repository.ICursoRepository;

@Service
public class CursoService {

	@Autowired
	private ICursoRepository repository;

	public List<Curso> getAll() {
		return repository.findAll();
	}

	public Curso insertOrUpdate(Curso curso) {
		return repository.save(curso);
	}

	public Curso findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Curso insertIfNotExists(Curso curso) {
		List<Curso> cursoList = repository.findByCarreraAndSeccionAndSemestre(curso.getCarrera(), curso.getSeccion(),
				curso.getSemestre());
		if (cursoList.isEmpty()) {
			curso = insertNewCurso(curso);
		} else {
			curso = cursoList.get(0);
		}
		return curso;
	}

	private Curso insertNewCurso(Curso curso) {
		Curso newCurso = new Curso();
		newCurso.setCarrera(curso.getCarrera());
		newCurso.setSeccion(curso.getSeccion());
		newCurso.setSemestre(curso.getSemestre());
		return insertOrUpdate(newCurso);
	}

}
