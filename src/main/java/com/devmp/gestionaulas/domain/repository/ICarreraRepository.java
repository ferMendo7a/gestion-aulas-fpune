package com.devmp.gestionaulas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.domain.model.Carrera;

@Repository
public interface ICarreraRepository extends JpaRepository<Carrera, Integer> {

}
