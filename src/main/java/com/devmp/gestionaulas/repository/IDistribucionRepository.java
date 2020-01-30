package com.devmp.gestionaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.Distribucion;

@Repository
public interface IDistribucionRepository extends JpaRepository<Distribucion, Integer> {

}
