package com.devmp.gestionaulas.rest.controller.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntervaloInicioFin {

	@JsonFormat(timezone = "America/Asuncion")
	private Date fechaHoraInicio;

	@JsonFormat(timezone = "America/Asuncion")
	private Date fechaHoraFin;

}
