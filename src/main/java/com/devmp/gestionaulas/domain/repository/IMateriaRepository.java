package com.devmp.gestionaulas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.domain.model.Materia;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia, Integer> {

}
