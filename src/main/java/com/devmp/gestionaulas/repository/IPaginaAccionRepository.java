package com.devmp.gestionaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.PaginaAccion;

@Repository
public interface IPaginaAccionRepository extends JpaRepository<PaginaAccion, Integer> {

	List<PaginaAccion> findByDescripcion(String descripcion);

}
