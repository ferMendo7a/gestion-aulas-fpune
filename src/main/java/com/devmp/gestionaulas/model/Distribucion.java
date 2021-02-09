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
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@EqualsAndHashCode.Exclude
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

	@Transient
	private boolean registrarHastaFinalPeriodo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((horarioFin == null) ? 0 : horarioFin.hashCode());
		result = prime * result + ((horarioInicio == null) ? 0 : horarioInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distribucion other = (Distribucion) obj;
		if (id != null && id == other.id) {
			return true;
		}
		if (aula == null) {
			if (other.aula != null)
				return false;
		} else if (!aula.equals(other.aula))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (horarioFin == null) {
			if (other.horarioFin != null)
				return false;
		} else if (!horarioFin.equals(other.horarioFin))
			return false;
		if (horarioInicio == null) {
			if (other.horarioInicio != null)
				return false;
		} else if (!horarioInicio.equals(other.horarioInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		return true;
	}

}
