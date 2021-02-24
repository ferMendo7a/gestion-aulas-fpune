package com.devmp.gestionaulas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.domain.model.Grupo;

@Repository
public interface IGrupoRepository extends JpaRepository<Grupo, Integer> {

}
