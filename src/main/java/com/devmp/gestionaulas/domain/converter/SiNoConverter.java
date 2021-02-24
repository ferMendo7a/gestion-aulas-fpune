package com.devmp.gestionaulas.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SiNoConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if (attribute == null) {
			return "N";
		}

		return attribute ? "S" : "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return false;
		}

		return dbData.equals("S");
	}

}
