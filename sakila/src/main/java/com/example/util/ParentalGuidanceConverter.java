package com.example.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.types.ParentalGuidance;

@Converter
public class ParentalGuidanceConverter implements AttributeConverter<ParentalGuidance, String> {
	@Override
	public String convertToDatabaseColumn(ParentalGuidance value) {
		if ( value == null  || value == ParentalGuidance.Unrated ) {
			return null;
		}
		return value.getCode();	
	}
	@Override
	public ParentalGuidance convertToEntityAttribute(String value) {
		if ( value == null ) {
			return null;
		}
		return ParentalGuidance.fromCode( value );
	}

}
