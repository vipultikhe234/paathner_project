package com.ddpl.paathner.country.service;

import org.springframework.stereotype.Service;

import com.ddpl.paathner.country.CountryDto;
import com.ddpl.paathner.country.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	private CountryRepository countryRepository;
	
	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository=countryRepository;
	}
	@Override
	public CountryDto insertCountry(CountryDto countryDto) {
		return null;
	}

}
