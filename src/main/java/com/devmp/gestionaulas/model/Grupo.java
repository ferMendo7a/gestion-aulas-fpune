package com.devmp.gestionaulas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "grupo")
public class Grupo {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Privilegio> privilegios;

}
