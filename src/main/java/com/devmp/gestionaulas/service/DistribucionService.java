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
	private CursoService cursoService;

	@Autowired
	private EntityManager em;

	public List<Distribucion> getAll() {
		return repository.findAll();
	}

	public Distribucion insertOrUpdate(Distribucion distribucion) {
		// validar datos
		// validar aula disponible, curso con horario ya registrado
		// consultar curso, si no existe guardar
		distribucion.setCurso(cursoService.insertIfNotExists(distribucion.getCurso()));
		return repository.save(distribucion);
	}

	public List<Distribucion> getAll(Distribucion filtroDistribucion) {
		StringBuilder sql = new StringBuilder();
		sql.append("select d.* from distribucion d");
		sql.append("\n");
		sql.append("join materia m on d.id_materia = m.id");
		sql.append("\n");
		sql.append("join aula a on d.id_aula = a.id");
		sql.append("\n");
		sql.append("join curso c on d.id_curso = c.id");
		sql.append("\n");
		sql.append("join carrera ca on c.id_carrera = ca.id");
		sql.append("\n");
		sql.append("join seccion sc on c.id_seccion = sc.id");
		sql.append("\n");
		sql.append("join semestre se on c.id_semestre = se.id");

		if (considerarFiltros(filtroDistribucion)) {
			sql.append("\n");
			sql.append("where 1 = 1");
			if (agregarFiltroCarrera(filtroDistribucion)) {
				sql.append("\n");
				sql.append("and ca.id = :id_carrera");
			}
			if (agregarFiltroSeccion(filtroDistribucion)) {
				sql.append("\n");
				sql.append("and sc.id = :id_seccion");
			}
			if (agregarFiltroSemestre(filtroDistribucion)) {
				sql.append("\n");
				sql.append("and se.id = :id_semestre");
			}
		}

		Query query = em.createNativeQuery(sql.toString(), Distribucion.class);
		if (agregarFiltroCarrera(filtroDistribucion)) {
			query.setParameter("id_carrera", filtroDistribucion.getCurso().getCarrera().getId());
		}
		if (agregarFiltroSeccion(filtroDistribucion)) {
			query.setParameter("id_seccion", filtroDistribucion.getCurso().getSeccion().getId());
		}
		if (agregarFiltroSemestre(filtroDistribucion)) {
			query.setParameter("id_semestre", filtroDistribucion.getCurso().getSemestre().getId());
		}

		return query.getResultList();
	}

	private boolean considerarFiltros(Distribucion filtroDistribucion) {
		return filtroDistribucion != null;
	}

	private boolean agregarFiltroCarrera(Distribucion filtroDistribucion) {
		return filtroDistribucion.getCurso() != null && filtroDistribucion.getCurso().getCarrera() != null
				&& filtroDistribucion.getCurso().getCarrera().getId() != null;
	}

	private boolean agregarFiltroSeccion(Distribucion filtroDistribucion) {
		return filtroDistribucion.getCurso() != null && filtroDistribucion.getCurso().getSeccion() != null
				&& filtroDistribucion.getCurso().getSeccion().getId() != null;
	}

	private boolean agregarFiltroSemestre(Distribucion filtroDistribucion) {
		return filtroDistribucion.getCurso() != null && filtroDistribucion.getCurso().getSemestre() != null
				&& filtroDistribucion.getCurso().getSemestre().getId() != null;
	}

}
