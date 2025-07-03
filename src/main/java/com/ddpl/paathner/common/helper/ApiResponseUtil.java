package com.ddpl.paathner.common.helper;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.ddpl.paathner.common.constants.ResponseConstants;

public class ApiResponseUtil {
	@SuppressWarnings("unchecked")
	public static ResponseEntity<Map<String, Object>> success(String message, String key, Object data,
			HttpStatus status) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Status", ResponseConstants.SUCCESS);
		response.put("Message", message);
		if ("array".equals(key) && data instanceof Map) {
			response.putAll((Map<String, Object>) data);
		} else if (key != null) {
			response.put(key, data);
		}
		return new ResponseEntity<>(response, status);

	}

	public static ResponseEntity<Map<String, Object>> success(String message, String key, Object data) {
		return success(message, key, data, HttpStatus.OK);
	}

	public static ResponseEntity<Map<String, Object>> success(String message) {
		return success(message, null, null, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	public static ResponseEntity<Map<String, Object>> error(String message, Object data, HttpStatus status) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Status", ResponseConstants.FAIL);
		response.put("Message", message);

		if (data instanceof Map) {
			response.putAll((Map<String, Object>) data);
		}

		return new ResponseEntity<>(response, status);
	}

	public static ResponseEntity<Map<String, Object>> error(String message, Object data) {
		return error(message, data, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity<Map<String, Object>> error(String message) {
		return error(message, null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity<Map<String, Object>> validationError(BindingResult result) {
		Map<String, String> fieldErrorMap = new LinkedHashMap<>();
		result.getFieldErrors().forEach(error -> {
			String fieldName = error.getField();
			Object rejectedValue = error.getRejectedValue();

			if (!fieldErrorMap.containsKey(fieldName)) {
				if (rejectedValue == null || rejectedValue.toString().trim().isEmpty()) {
					if (error.getCode().equals("NotBlank") || error.getCode().equals("NotNull")) {
						fieldErrorMap.put(fieldName, error.getDefaultMessage());
					}
				} else {
					fieldErrorMap.put(fieldName, error.getDefaultMessage());
				}
			}
		});
		String errorMessage = String.join("\n", fieldErrorMap.values());
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Status", ResponseConstants.FAIL);
		response.put("Message", errorMessage);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
