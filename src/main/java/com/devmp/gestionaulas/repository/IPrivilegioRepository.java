package com.devmp.gestionaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.model.Grupo;
import com.devmp.gestionaulas.model.PaginaAccion;
import com.devmp.gestionaulas.model.Privilegio;

@Repository
public interface IPrivilegioRepository extends JpaRepository<Privilegio, Integer> {

	List<Privilegio> findByGrupoAndPaginaAccion(Grupo grupo, PaginaAccion paginaAccion);

}
