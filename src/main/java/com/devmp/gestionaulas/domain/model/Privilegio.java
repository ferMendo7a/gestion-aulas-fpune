package com.devmp.gestionaulas.domain.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.devmp.gestionaulas.domain.converter.SiNoConverter;
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

	@Convert(converter = SiNoConverter.class)
	@Column(name = "incluir")
	private Boolean incluir;

	@Convert(converter = SiNoConverter.class)
	@Column(name = "modificar")
	private Boolean modificar;

	@Convert(converter = SiNoConverter.class)
	@Column(name = "eliminar")
	private Boolean eliminar;

	@Convert(converter = SiNoConverter.class)
	@Column(name = "consultar")
	private Boolean consultar;

}
