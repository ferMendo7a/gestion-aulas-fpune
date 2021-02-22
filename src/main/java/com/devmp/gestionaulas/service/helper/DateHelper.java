package com.devmp.gestionaulas.service.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	static SimpleDateFormat truncFormat = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

	public static Date truncDate(Date date) throws ParseException {
		return truncFormat.parse(truncFormat.format(date));
	}

}
