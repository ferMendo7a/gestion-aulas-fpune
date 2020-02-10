package com.devmp.gestionaulas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "distribucion")
public class Distribucion {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@OneToOne
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	@OneToOne
	@JoinColumn(name = "id_aula")
	private Aula aula;

	@OneToOne
	@JoinColumn(name = "id_materia")
	private Materia materia;

	@Column(name = "horario_inicio")
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm:ss")
	private Date horarioInicio;

	@Column(name = "horario_fin")
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm:ss")
	private Date horarioFin;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

}
