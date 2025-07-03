package com.ddpl.paathner.country.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ddpl.paathner.country.CountryDto;

public interface CountryService {
	
	ResponseEntity<Map<String, Object>> insertCountry(CountryDto countryDto);
	
	ResponseEntity<Map<String, Object>> getCountryById(Long id);

}
