package com.ddpl.paathner.common.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends ApiException {
	public ResourceNotFoundException(String resourceName) {
		super(resourceName + " Not Found");
	}
}
