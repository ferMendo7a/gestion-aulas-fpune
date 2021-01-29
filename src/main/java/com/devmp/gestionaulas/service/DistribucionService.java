package com.devmp.gestionaulas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Distribucion;
import com.devmp.gestionaulas.repository.IDistribucionRepository;

@Service
public class DistribucionService {

	@Autowired
	private IDistribucionRepository repository;

	@Autowired
	private EntityManager em;

	public List<Distribucion> getAll() {
		return repository.findAll();
	}

	public Distribucion insertOrUpdate(Distribucion distribucion) {
		return repository.save(distribucion);
	}

	public List<Distribucion> getAll(Distribucion filtroDistribucion) {
		StringBuilder sql = new StringBuilder();
		sql.append("select d.* from distribucion d");
		sql.append("\n");
		sql.append("join carrera c on d.id_carrera = c.id");
		sql.append("\n");
		sql.append("join materia m on d.id_materia = m.id");
		sql.append("\n");
		sql.append("join aula a on d.id_aula = a.id");

		if (considerarFiltros(filtroDistribucion)) {
			sql.append("\n");
			sql.append("where 1 = 1");
			if (agregarFiltroCarrera(filtroDistribucion)) {
				sql.append("\n");
				sql.append("and c.id = :id_carrera");
			}
		}

		Query query = em.createNativeQuery(sql.toString(), Distribucion.class);
		if (agregarFiltroCarrera(filtroDistribucion)) {
			query.setParameter("id_carrera", filtroDistribucion.getCarrera().getId());
		}

		return query.getResultList();
	}

	private boolean considerarFiltros(Distribucion filtroDistribucion) {
		return filtroDistribucion != null;
	}

	private boolean agregarFiltroCarrera(Distribucion filtroDistribucion) {
		return filtroDistribucion.getCarrera() != null && filtroDistribucion.getCarrera().getId() != null;
	}

}
