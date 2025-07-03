package com.ddpl.paathner.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddpl.paathner.common.helper.ApiResponseUtil;
import com.ddpl.paathner.country.service.CountryService;
import com.ddpl.paathner.country.validation.onCreate;

@RestController
@RequestMapping("/api/country")
public class CountryController {
	@Autowired
	CountryService countryService;

	@PostMapping("/insert_country")
	public ResponseEntity<?> insertCountry(@Validated(onCreate.class) @ModelAttribute CountryDto countryDto,
			BindingResult result) {
		if (result.hasErrors()) {
			return ApiResponseUtil.validationError(result);
		}
		return countryService.insertCountry(countryDto);
	}

}
