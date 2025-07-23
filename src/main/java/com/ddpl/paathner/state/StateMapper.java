package com.ddpl.paathner.state;

import com.ddpl.paathner.country.Country;

public class StateMapper {
	public static State mapToState(StateDto stateDto, Country country) {
		State state = new State();
		if (stateDto.getStateId() != null) {
			state.setStateId(stateDto.getStateId());
		}
		state.setCountry(country);
		state.setStateName(stateDto.getStateName());
		state.setStateStatus(stateDto.getStateStatus());
		return state;
	}

}
