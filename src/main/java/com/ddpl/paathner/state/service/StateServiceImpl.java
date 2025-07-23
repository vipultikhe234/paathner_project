package com.ddpl.paathner.state.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ddpl.paathner.common.helper.ApiResponseUtil;
import com.ddpl.paathner.country.Country;
import com.ddpl.paathner.state.State;
import com.ddpl.paathner.state.StateDto;
import com.ddpl.paathner.state.StateMapper;
import com.ddpl.paathner.state.StateRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private MessageSource messageSource;

	@Override
	public ResponseEntity<Map<String, Object>> insertState(StateDto stateDto, Country country) {
		State state = StateMapper.mapToState(stateDto, country);
		State savedState = stateRepository.save(state);
		if (savedState != null) {
			String message = messageSource.getMessage("message.STATE_SAVED", null, LocaleContextHolder.getLocale());
			return ApiResponseUtil.success(message, "state_id", savedState.getStateId(), HttpStatus.CREATED);
		} else {
			String message = messageSource.getMessage("message.STATE_SAVE_FAILED", null,
					LocaleContextHolder.getLocale());
			return ApiResponseUtil.error(message, null, HttpStatus.BAD_REQUEST);
		}
	}

}
