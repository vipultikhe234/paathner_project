package com.ddpl.paathner.common.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFound(ApiException ex) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Status", 0);
		response.put("Message", ex.getMessage());
		return ResponseEntity.badRequest().body(response);
	}
}
