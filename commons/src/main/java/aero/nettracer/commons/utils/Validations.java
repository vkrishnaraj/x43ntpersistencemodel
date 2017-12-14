package aero.nettracer.commons.utils;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Validations {
	
	private Validations() { }

	public static void validateGreaterThanZero(long variable, String name) {
		if (variable <= 0) {
			throw new IllegalArgumentException(name + " must be greater than zero");
		}
	} 
	
	public static void validateNotBlank(String variable, String name) {
		if (StringUtils.isBlank(variable)) {
			throw new IllegalArgumentException(name + " cannot be null or empty");
		}
	}
	
	public static void validateNotNull(Object variable, String name) {
		if (variable == null) {
			throw new IllegalArgumentException(name + " cannot be null");
		}
	}
	
	public static void validateNotNegative(long variable, String name) {
		if (variable < 0) {
			throw new IllegalArgumentException(name + " must be greater than zero");
		}
	}
	
	public static void validatePaginationBounds(long start, long offset) {
		try {
			validateNotNegative(start, "start");
			validateNotNegative(offset, "offset");
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid pagination bounds: " + e.getMessage());
		}
	}
	
	public static void validateNumericValue(long variable, long[] validValues, String name){
		validateNotNull(validValues, "Valid Values Array");
		for(int i = 0; i < validValues.length; i++){
			if(variable == validValues[i]){
				return;
			}
		}
		throw new IllegalArgumentException(name + " must be one of the following: " + validValues);
	}

	public static void validateListNotEmpty(List variable, String name) {
		validateNotNull(variable, name);
		if(variable.isEmpty()) {
			throw new IllegalArgumentException(name + " cannot be empty");
		}
	}
}
