package com.devmp.gestionaulas.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devmp.gestionaulas.domain.model.pk.CarreraSeccionPK;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "carrera_seccion")
public class CarreraSeccion {

	@EmbeddedId
	private CarreraSeccionPK pk;

	@ManyToOne
	@JoinColumn(name = "id_seccion", insertable = false, updatable = false)
	private Seccion seccion;

	@ManyToOne
	@JoinColumn(name = "id_carrera", insertable = false, updatable = false)
	@JsonBackReference
	private Carrera carrera;

}
