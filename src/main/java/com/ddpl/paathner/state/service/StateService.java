package com.ddpl.paathner.state.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ddpl.paathner.country.Country;
import com.ddpl.paathner.state.StateDto;

public interface StateService {
	
	ResponseEntity<Map<String, Object>> insertState(StateDto stateDto,Country country);

}
