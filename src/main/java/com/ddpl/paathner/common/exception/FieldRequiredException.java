package com.ddpl.paathner.common.exception;

public class FieldRequiredException extends ApiException {
	public FieldRequiredException(String fieldName) {
		super(fieldName + "is required");
	}
}
