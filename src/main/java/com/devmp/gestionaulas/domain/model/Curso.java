package com.devmp.gestionaulas.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(generator = "SEQ_CURSO_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_CURSO_GENERATOR", sequenceName = "seq_curso", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	@ManyToOne
	@JoinColumn(name = "id_semestre")
	private Semestre semestre;

	@ManyToOne
	@JoinColumn(name = "id_seccion")
	private Seccion seccion;

}
