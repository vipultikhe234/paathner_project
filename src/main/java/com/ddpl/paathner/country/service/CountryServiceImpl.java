package com.ddpl.paathner.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddpl.paathner.country.Country;
import com.ddpl.paathner.country.CountryDto;
import com.ddpl.paathner.country.CountryMapper;
import com.ddpl.paathner.country.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public CountryDto insertCountry(CountryDto countryDto) {
		Country country = CountryMapper.mapToCountry(countryDto);
		Country savedCountry = countryRepository.save(country);
		return CountryMapper.mapToAccountDto(savedCountry);
	}

}
