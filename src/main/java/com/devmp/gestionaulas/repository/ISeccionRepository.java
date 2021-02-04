package com.devmp.gestionaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.Seccion;

@Repository
public interface ISeccionRepository extends JpaRepository<Seccion, Integer> {

}
