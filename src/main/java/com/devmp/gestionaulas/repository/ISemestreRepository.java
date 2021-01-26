package com.devmp.gestionaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.Aula;
import com.devmp.gestionaulas.model.Semestre;

@Repository
public interface ISemestreRepository extends JpaRepository<Semestre, Integer> {

}
