package com.devmp.gestionaulas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "privilegio")
public class Privilegio {

	@Id
	@GeneratedValue(generator = "SEQ_PRIVILEGIO_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PRIVILEGIO_GENERATOR", sequenceName = "seq_privilegio", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_grupo")
	@JsonBackReference
	private Grupo grupo;

	@ManyToOne
	@JoinColumn(name = "id_pagina_accion")
	private PaginaAccion paginaAccion;

	@Column(name = "incluir")
	private String incluir;

	@Column(name = "modificar")
	private String modificar;

	@Column(name = "eliminar")
	private String eliminar;

	@Column(name = "consultar")
	private String consultar;

}
