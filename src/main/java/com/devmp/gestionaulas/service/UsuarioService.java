package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.Usuario;
import com.devmp.gestionaulas.repository.IUsuarioRepository;
import com.devmp.gestionaulas.util.Estado;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Usuario> getAll() {
		return repository.findAll();
	}

	public Usuario insertOrUpdate(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario findById(Integer usuarioId) {
		return repository.findById(usuarioId).orElse(null);
	}

	public List<Usuario> getUsuariosActivos() {
		return repository.findByEstadoEquals(Estado.ACTIVO);
	}

	public Usuario cargarDatosUsuarioConectado(String username) {
		return findByUsername(username);
	}

	private Usuario findByUsername(String username) {
		return repository.findByUsername(username);
	}

	public Integer getIdByUsername(String username) {
		Usuario usuario = findByUsername(username);
		if (usuario != null && usuario.getId() != null) {
			return usuario.getId();
		} else
			return null;
	}

	public Usuario registrarNuevoUsuario(Usuario usuario) {
		if (!usernameUnico(usuario.getUsername())) {
			// TODO mensaje de error por username existente
			System.out.println("El username ya existe");
			return null;
		}
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setEstado(Estado.ACTIVO);
		return repository.save(usuario);
	}

	public boolean usernameUnico(String username) {
		Usuario usuario = repository.findByUsername(username);
		return usuario == null;
	}

}
