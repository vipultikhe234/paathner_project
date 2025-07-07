package com.ddpl.paathner.country;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddpl.paathner.common.helper.ApiResponseUtil;
import com.ddpl.paathner.country.service.CountryService;
import com.ddpl.paathner.country.validation.onCreate;
import com.ddpl.paathner.country.validation.onUpdate;

@RestController
@RequestMapping("/api/country")
public class CountryController {
	@Autowired
	CountryService countryService;

	@PostMapping("/insert_country")
	public ResponseEntity<Map<String, Object>> insertCountry(
			@Validated(onCreate.class) @ModelAttribute CountryDto countryDto, BindingResult result) {
		if (result.hasErrors()) {
			return ApiResponseUtil.validationError(result);
		}
		return countryService.insertCountry(countryDto);
	}

	// get Country By ID
	@GetMapping("/get_country_by_id/{id}")
	public ResponseEntity<Map<String, Object>> getCountryById(@PathVariable long id) {
		return countryService.getCountryById(id);
	}

	// update Country
	@PutMapping("/update_country/{id}")
	public ResponseEntity<Map<String, Object>> updateCountry(@PathVariable long id,
			@Validated(onUpdate.class) @ModelAttribute CountryDto countryDto, BindingResult result) {
		if (result.hasErrors()) {
			return ApiResponseUtil.validationError(result);
		}
		return countryService.UpdateCountry(id, countryDto);
	}

	@GetMapping("/get_all_country")
	public ResponseEntity<Map<String, Object>> getAllCountry() {
		return countryService.getCountryListing();
	}

}
