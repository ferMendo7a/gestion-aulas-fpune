package com.devmp.gestionaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.CarreraSeccion;
import com.devmp.gestionaulas.model.pk.CarreraSeccionPK;

@Repository
public interface ICarreraSeccionRepository extends JpaRepository<CarreraSeccion, CarreraSeccionPK> {

}
