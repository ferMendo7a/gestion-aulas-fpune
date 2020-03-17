package com.devmp.gestionaulas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Transient
	private String token;
	
}
