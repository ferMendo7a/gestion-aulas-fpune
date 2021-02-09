package com.devmp.gestionaulas.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Periodo;
import com.devmp.gestionaulas.repository.IPeriodoRepository;

@Service
public class PeriodoService {

	@Autowired
	private EntityManager em;

	@Autowired
	private IPeriodoRepository repository;

	public List<Periodo> getAll() {
		return repository.findAll();
	}

	public Periodo insertOrUpdate(Periodo periodo) {
		if (periodoYaRegistrado(periodo)) {
			return null;
		}

		return repository.save(periodo);
	}

	public Periodo findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Periodo getPeriodoByFecha(Date fecha) {
		List<Periodo> result = repository.findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(fecha, fecha);
		if (result != null && !result.isEmpty()) {
			return result.get(0);
		} else
			return null;
	}

	private boolean periodoYaRegistrado(Periodo periodo) {
		boolean existePeriodoRegistrado;
		StringBuilder sql = new StringBuilder();
		sql.append("select p.* from periodo_lectivo p");
		sql.append("\n where (p.fecha_inicio <= :fechaInicio and p.fecha_fin >= :fechaInicio) or");
		sql.append("\n 	   (p.fecha_inicio <= :fechaFin and p.fecha_fin >= :fechaFin)");

		Query query = em.createNativeQuery(sql.toString(), Periodo.class);
		query.setParameter("fechaInicio", periodo.getFechaInicio());
		query.setParameter("fechaFin", periodo.getFechaFin());

		List<Periodo> result = query.getResultList();
		existePeriodoRegistrado = result != null && !result.isEmpty() && result.get(0).getId() != null;
		return existePeriodoRegistrado;
	}

}
