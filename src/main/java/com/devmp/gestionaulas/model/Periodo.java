package com.devmp.gestionaulas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "periodo_lectivo")
public class Periodo {

	@Id
	@GeneratedValue(generator = "SEQ_PERIODO_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PERIODO_GENERATOR", sequenceName = "seq_periodo", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
	private Date fechaInicio;

	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
	private Date fechaFin;

}
