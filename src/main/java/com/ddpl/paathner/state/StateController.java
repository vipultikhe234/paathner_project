package com.ddpl.paathner.state;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddpl.paathner.common.exception.ResourceNotFoundException;
import com.ddpl.paathner.common.helper.ApiResponseUtil;
import com.ddpl.paathner.country.Country;
import com.ddpl.paathner.country.CountryRepository;
import com.ddpl.paathner.country.validation.onCreate;
import com.ddpl.paathner.state.service.StateService;

@RestController
@RequestMapping("api/state")
public class StateController {
	@Autowired
	private StateService stateService;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private MessageSource messageSource;

	@PostMapping("/insert_state")
	public ResponseEntity<Map<String, Object>> insertState(@Validated(onCreate.class) @RequestBody StateDto stateDto,
			BindingResult result) {
		if (result.hasErrors()) {
			return ApiResponseUtil.validationError(result);
		}
		Country country = countryRepository.findById(stateDto.getCountryId())
				.orElseThrow(() -> new ResourceNotFoundException(
						messageSource.getMessage("message.COUNTRY", null, LocaleContextHolder.getLocale())));
		return stateService.insertState(stateDto, country);

	}

}
