package com.ddpl.paathner.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddpl.paathner.country.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {
	@Autowired
	CountryService countryService;
	
	@PostMapping("/insert_country")
	public ResponseEntity<CountryDto> insertCountry(@ModelAttribute CountryDto countryDto){
		return new ResponseEntity<>(countryService.insertCountry(countryDto),HttpStatus.CREATED);
	}
	

}
