package com.devmp.gestionaulas.domain.service;

import java.util.List;
import java.util.StringJoiner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.domain.model.Aula;
import com.devmp.gestionaulas.domain.repository.IAulaRepository;
import com.devmp.gestionaulas.rest.controller.vo.IntervaloInicioFin;

@Service
public class AulaService {

	@Autowired
	private IAulaRepository repository;

	@Autowired
	private EntityManager em;

	public List<Aula> getAll() {
		return repository.findAll();
	}

	public Aula insertOrUpdate(Aula aula) {
		return repository.save(aula);
	}

	public Aula findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Aula> getAulasDisponibles(IntervaloInicioFin intervalo) throws Exception {
		StringJoiner sql = new StringJoiner("\n");
		sql.add("select a.* from aula a");
		sql.add("where a.id not in");
		sql.add("(select a.id from distribucion d");
		sql.add("where d.id_aula = a.id");
		sql.add("and date_trunc('day', d.fecha) <= :fechaInicio");
		sql.add("and date_trunc('day', d.fecha  + INTERVAL '1 day') > :fechaFin");
		sql.add("and ((d.horario_inicio >= cast(:fechaInicio as time) and d.horario_inicio <= cast(:fechaFin as time))");
		sql.add("or (d.horario_fin >= cast(:fechaInicio as time) and d.horario_fin <= cast(:fechaFin as time))))");

		Query query = em.createNativeQuery(sql.toString(), Aula.class);
		query.setParameter("fechaInicio", intervalo.getFechaHoraInicio());
		query.setParameter("fechaFin", intervalo.getFechaHoraFin());

		List<Aula> aulas = query.getResultList();
		if (aulas.isEmpty()) {
			throw new Exception("No existen aulas disponibles en el horario seleccionado");
		}

		return aulas;
	}

}
