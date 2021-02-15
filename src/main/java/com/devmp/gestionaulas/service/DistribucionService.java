package com.devmp.gestionaulas.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Distribucion;
import com.devmp.gestionaulas.model.Periodo;
import com.devmp.gestionaulas.repository.IDistribucionRepository;

@Service
public class DistribucionService {

	@Autowired
	private IDistribucionRepository repository;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private PeriodoService periodoService;

	@Autowired
	private EntityManager em;

	public List<Distribucion> getAll() {
		return repository.findAll();
	}

	public Distribucion insertOrUpdate(Distribucion distribucion) throws Exception {
		Distribucion retorno = null;
		try {

			// validar periodo lectivo activo
			Periodo periodoActual = getPeriodoActual(distribucion);
			if (periodoActual == null) {
				throw new Exception("El periodo lectivo para este semestre no fue configurado");
			}

			// consultar curso, si no existe guardar
			distribucion.setCurso(cursoService.insertIfNotExists(distribucion.getCurso()));

			// validar aula disponible
			// 1. consultar horarios por aula, fecha, inicio y fin de la distribucion
			// 2. si existe informar al usuario
			Distribucion distribucionRegistrada = getDistribucionByAulaAndHorario(distribucion);
			if (distribucionRegistrada != null && distribucionRegistrada.getId() != null) {
				throw new Exception(
						"El aula seleccionada ya tiene un horario registrado en la fecha " + distribucion.getFecha());
			}

			// curso con horario ya registrado
			// 1. consultar horarios por curso, fecha, inicio y fin de la distribucion
			distribucionRegistrada = getDistribucionByCursoAndHorario(distribucion);
			if (distribucionRegistrada != null && distribucionRegistrada.getId() != null) {
				throw new Exception(
						"El curso seleccionado ya tiene un horario registrado en la fecha " + distribucion.getFecha());
			}

			// guardar distribucion hasta el final del periodo lectivo si
			// registrarHastaFinalPeriodo es true
			if (distribucion.isRegistrarHastaFinalPeriodo()) {
				// agregar 8 dias a la fecha de la distribucion hasta llegar a la fecha fin del
				// periodo lectivo
				List<Distribucion> distribucionList = new ArrayList<Distribucion>();
				Date fechaNew = distribucion.getFecha();

				while (periodoActual.getFechaFin().compareTo(fechaNew) >= 0) {
					Distribucion distribucionNew = new Distribucion();
					distribucionNew.setAula(distribucion.getAula());
					distribucionNew.setCurso(distribucion.getCurso());
					distribucionNew.setMateria(distribucion.getMateria());
					distribucionNew.setUsuario(distribucion.getUsuario());
					distribucionNew.setHorarioInicio(distribucion.getHorarioInicio());
					distribucionNew.setHorarioFin(distribucion.getHorarioFin());
					distribucionNew.setFecha(fechaNew);
					distribucionList.add(distribucionNew);

					Calendar calendar = Calendar.getInstance();
					calendar.setTime(distribucionNew.getFecha());
					calendar.add(Calendar.DAY_OF_YEAR, 7);
					fechaNew = calendar.getTime();
				}

				distribucionList = repository.saveAll(distribucionList);
				if (!distribucionList.isEmpty()) {
					retorno = distribucionList.get(0);
				}
			} else {
				retorno = repository.save(distribucion);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return retorno;
	}

	private Distribucion getDistribucionByAulaAndHorario(Distribucion distribucion) {
		List<Distribucion> result = repository
				.findByAulaAndFechaAndHorarioInicioLessThanEqualAndHorarioFinGreaterThanEqual(distribucion.getAula(),
						distribucion.getFecha(), distribucion.getHorarioInicio(), distribucion.getHorarioFin());
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}

	private Distribucion getDistribucionByCursoAndHorario(Distribucion distribucion) {
		List<Distribucion> result = repository
				.findByCursoAndFechaAndHorarioInicioLessThanEqualAndHorarioFinGreaterThanEqual(distribucion.getCurso(),
						distribucion.getFecha(), distribucion.getHorarioInicio(), distribucion.getHorarioFin());
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}

	private Periodo getPeriodoActual(Distribucion distribucion) {
		Periodo periodoActual = periodoService.getPeriodoByFecha(distribucion.getFecha());
		return periodoActual;
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
