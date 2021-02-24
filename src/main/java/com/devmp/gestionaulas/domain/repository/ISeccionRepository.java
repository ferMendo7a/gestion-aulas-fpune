package com.devmp.gestionaulas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.domain.model.Seccion;

@Repository
public interface ISeccionRepository extends JpaRepository<Seccion, Integer> {

}
