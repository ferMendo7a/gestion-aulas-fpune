package com.devmp.gestionaulas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmp.gestionaulas.domain.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findByEstadoEquals(String estado);

	Usuario findByUsername(String username);

}
