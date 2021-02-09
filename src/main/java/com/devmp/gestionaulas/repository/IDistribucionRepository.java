package com.devmp.gestionaulas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.Aula;
import com.devmp.gestionaulas.model.Curso;
import com.devmp.gestionaulas.model.Distribucion;

@Repository
public interface IDistribucionRepository extends JpaRepository<Distribucion, Integer> {

	List<Distribucion> findByAulaAndFechaAndHorarioInicioLessThanEqualAndHorarioFinGreaterThanEqual(Aula aula,
			Date fecha, Date inicio, Date fin);

	List<Distribucion> findByCursoAndFechaAndHorarioInicioLessThanEqualAndHorarioFinGreaterThanEqual(Curso curso,
			Date fecha, Date inicio, Date fin);

}
