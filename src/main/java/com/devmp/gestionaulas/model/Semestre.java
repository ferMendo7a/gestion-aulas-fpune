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
@Table(name = "semestre")
public class Semestre {

	@Id
	@GeneratedValue(generator = "SEQ_SEMESTRE_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_SEMESTRE_GENERATOR", sequenceName = "seq_semestre", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "descripcion")
	private String descripcion;

}
