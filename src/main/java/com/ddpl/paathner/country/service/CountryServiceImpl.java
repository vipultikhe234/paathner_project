package com.ddpl.paathner.country.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ddpl.paathner.common.exception.ResourceNotFoundException;
import com.ddpl.paathner.common.helper.ApiResponseUtil;
import com.ddpl.paathner.country.Country;
import com.ddpl.paathner.country.CountryDto;
import com.ddpl.paathner.country.CountryMapper;
import com.ddpl.paathner.country.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;
	@Autowired
	private MessageSource messageSource;

	@Override
	public ResponseEntity<Map<String, Object>> insertCountry(CountryDto countryDto) {
		Country country = CountryMapper.mapToCountry(countryDto);
		Country savedCountry = countryRepository.save(country);
		if (savedCountry != null) {
			String message = messageSource.getMessage("message.COUNTRY_SAVED", null, LocaleContextHolder.getLocale());
			return ApiResponseUtil.success(message, "Country_id", savedCountry.getCountryId(), HttpStatus.CREATED);
		} else {
			String message = messageSource.getMessage("message.COUNTRY_SAVE_FAILED", null,
					LocaleContextHolder.getLocale());
			return ApiResponseUtil.error(message, null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> getCountryById(Long id) {
		Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country"));
		String message = messageSource.getMessage("message.COUNTRY_GET_SUCCESS", null, LocaleContextHolder.getLocale());
		CountryDto countryDto=CountryMapper.mapToAccountDto(country);
		return ApiResponseUtil.success(message, "Data", countryDto);
	}

}
