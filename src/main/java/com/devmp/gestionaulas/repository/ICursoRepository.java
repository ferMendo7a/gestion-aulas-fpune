package com.devmp.gestionaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.Carrera;
import com.devmp.gestionaulas.model.Curso;
import com.devmp.gestionaulas.model.Seccion;
import com.devmp.gestionaulas.model.Semestre;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {

	public List<Curso> findByCarreraAndSeccionAndSemestre(Carrera carrera, Seccion seccion, Semestre semestre);

}
