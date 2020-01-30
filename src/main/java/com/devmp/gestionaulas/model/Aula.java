package com.devmp.gestionaulas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "aula")
public class Aula {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "sector")
	private String sector;	
	
}
