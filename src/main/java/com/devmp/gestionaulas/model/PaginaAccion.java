package com.devmp.gestionaulas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pagina_accion")
public class PaginaAccion {

	@Id
	@GeneratedValue(generator = "SEQ_PAGINA_ACCION_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PAGINA_ACCION_GENERATOR", sequenceName = "seq_pagina_accion", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;

}
