package com.devmp.gestionaulas.domain.model;

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
@Table(name = "aula")
public class Aula {

	@Id
	@GeneratedValue(generator = "SEQ_AULA_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_AULA_GENERATOR", sequenceName = "seq_aula", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "sector")
	private String sector;

}
