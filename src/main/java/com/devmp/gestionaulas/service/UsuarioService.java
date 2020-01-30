package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Usuario;
import com.devmp.gestionaulas.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository repository;

	public List<Usuario> getAll() {
		return repository.findAll();
	}

}
