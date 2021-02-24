package com.devmp.gestionaulas.domain.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class CarreraSeccionPK implements Serializable {

	@Getter
	@Setter
	private Integer id_carrera;
	@Getter
	@Setter
	private Integer id_seccion;

	public CarreraSeccionPK() {

	}

	public CarreraSeccionPK(Integer id_carrera, Integer id_seccion) {
		this.id_carrera = id_carrera;
		this.id_seccion = id_seccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_carrera == null) ? 0 : id_carrera.hashCode());
		result = prime * result + ((id_seccion == null) ? 0 : id_seccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarreraSeccionPK other = (CarreraSeccionPK) obj;
		if (id_carrera == null) {
			if (other.id_carrera != null)
				return false;
		} else if (!id_carrera.equals(other.id_carrera))
			return false;
		if (id_seccion == null) {
			if (other.id_seccion != null)
				return false;
		} else if (!id_seccion.equals(other.id_seccion))
			return false;
		return true;
	}

}
