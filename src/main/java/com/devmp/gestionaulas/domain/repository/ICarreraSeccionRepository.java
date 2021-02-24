package com.devmp.gestionaulas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.domain.model.CarreraSeccion;
import com.devmp.gestionaulas.domain.model.pk.CarreraSeccionPK;

@Repository
public interface ICarreraSeccionRepository extends JpaRepository<CarreraSeccion, CarreraSeccionPK> {

}
