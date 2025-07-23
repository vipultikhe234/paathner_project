package com.ddpl.paathner.state.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ddpl.paathner.state.StateRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueStateNameValidator implements ConstraintValidator<UniqueStateName, String> {
	@Autowired
	private StateRepository stateRepository;

	@Override
	public boolean isValid(String stateName, ConstraintValidatorContext context) {
		if (stateName == null || stateName.trim().isEmpty()) {
			return true;
		}
		return !stateRepository.existsByStateNameIgnoreCase(stateName.trim());
	}

}
