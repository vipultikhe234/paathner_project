package com.ddpl.paathner.state;

import com.ddpl.paathner.country.validation.onCreate;
import com.ddpl.paathner.state.State.StateStatus;
import com.ddpl.paathner.state.validation.UniqueStateName;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateDto {

	@NotNull(message = "{message.State_ID.REQUIRED}")
	private Long stateId;

	@NotNull(message = "{message.COUNTRY_ID.REQUIRED}",groups = {onCreate.class})
	private long countryId;

	@UniqueStateName(message="{message.STATE_NAME_UNIQUE}",groups = {onCreate.class})
	@NotBlank(message = "{message.STATE_NAME.REQUIRED}",groups = {onCreate.class})
	@Size(max = 255, message = "{message.STATE_NAME.MAX}")
	@Pattern(regexp = "^[^\\d]*$", message = "{message.STATE_NAME.NO_DIGITS}")
	private String stateName;

	@NotNull(message = "{message.STATE_STATUS.REQUIRED}",groups = {onCreate.class})
	private StateStatus stateStatus;
}
