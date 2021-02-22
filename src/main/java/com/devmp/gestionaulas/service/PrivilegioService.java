package com.devmp.gestionaulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devmp.gestionaulas.model.PaginaAccion;
import com.devmp.gestionaulas.model.Privilegio;
import com.devmp.gestionaulas.model.Usuario;
import com.devmp.gestionaulas.repository.IPaginaAccionRepository;
import com.devmp.gestionaulas.repository.IPrivilegioRepository;

@Service
public class PrivilegioService {

	private static final String PRIVILEGIO_PAGINA = "PRIVILEGIOS";

	@Autowired
	private IPrivilegioRepository repository;
	@Autowired
	private UsuarioService serviceUsuario;
	@Autowired
	private IPaginaAccionRepository servicePaginaAccion;

	public List<Privilegio> getAll() throws Exception {
		if (!puedeConsultarPagina(PRIVILEGIO_PAGINA)) {
			throw new Exception("No tienes acceso a esta pagina");
		}
		return repository.findAll();
	}

	public Privilegio insertOrUpdate(Privilegio privilegio) {
		return repository.save(privilegio);
	}

	public Privilegio findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public boolean puedeConsultarPagina(String pagina) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = serviceUsuario.cargarDatosUsuarioConectado(auth.getName());
		PaginaAccion paginaAccion = servicePaginaAccion.findByDescripcion(pagina).get(0);

		List<Privilegio> consultaPrivilegio = repository.findByGrupoAndPaginaAccion(usuario.getGrupo(), paginaAccion);
		if (consultaPrivilegio.isEmpty()) {
			return false;
		}
		return consultaPrivilegio.get(0).getConsultar().equals("S");
	}

}
