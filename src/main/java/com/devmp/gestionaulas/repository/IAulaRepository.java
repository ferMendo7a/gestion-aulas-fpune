package com.devmp.gestionaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.Aula;

@Repository
public interface IAulaRepository extends JpaRepository<Aula, Integer> {

}
