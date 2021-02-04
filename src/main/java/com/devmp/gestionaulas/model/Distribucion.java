package com.devmp.gestionaulas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "distribucion")
public class Distribucion {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DISTRIBUCION_GENERATOR")
	@SequenceGenerator(name = "SEQ_DISTRIBUCION_GENERATOR", sequenceName = "seq_distribucion", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "id_aula")
	private Aula aula;

	@ManyToOne
	@JoinColumn(name = "id_materia")
	private Materia materia;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "horario_inicio")
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm", timezone = "America/Asuncion")
	private Date horarioInicio;

	@Column(name = "horario_fin")
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm", timezone = "America/Asuncion")
	private Date horarioFin;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
	private Date fecha;

}
