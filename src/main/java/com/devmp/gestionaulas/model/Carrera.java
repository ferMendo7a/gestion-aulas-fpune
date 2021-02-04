package com.devmp.gestionaulas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "carrera")
public class Carrera {

	@Id
	@GeneratedValue(generator = "SEQ_CARRERA_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_CARRERA_GENERATOR", sequenceName = "seq_carrera", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "carrera")
	@JsonManagedReference
	private List<CarreraSeccion> secciones;

}
