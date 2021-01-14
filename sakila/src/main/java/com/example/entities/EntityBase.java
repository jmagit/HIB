package com.example.entities;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public abstract class EntityBase<T> {
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); 
	
	public Set<ConstraintViolation<T>> getErrors() {
		return validator.validate((T)this);
	}

	public boolean isValid() {
		return getErrors().size() == 0;
	}
	public boolean isNotValid() {
		return !isValid();
	}
}
