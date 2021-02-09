package com.devmp.gestionaulas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.Periodo;

@Repository
public interface IPeriodoRepository extends JpaRepository<Periodo, Integer> {

	List<Periodo> findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(Date fecha1, Date fecha2);

}
