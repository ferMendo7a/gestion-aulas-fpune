package com.devmp.gestionaulas.domain.util;

public class Util {

	private static ThreadLocal<Integer> usuarioId;

	private Util() {
	}

	private static void init() {
		if (usuarioId == null) {
			usuarioId = new ThreadLocal<>();
		}
	}

	public static void setUsuarioId(Integer id) {
		init();
		usuarioId.set(id);
	}

	public static Integer getUsuarioId() {
		return usuarioId.get();
	}

}
