package com.ddpl.paathner.state;

import java.time.LocalDateTime;

import com.ddpl.paathner.state.State.StateStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class StateDto {
	@NotNull(message = "{message.State_ID.REQUIRED}")
	private long stateId;

	@NotNull(message = "{message.COUNTRY_ID.REQUIRED}")
	private long countryId;

	@NotBlank(message = "{message.STATE_NAME.REQUIRED}")
	@Size(max = 255, message = "{message.STATE_NAME.MAX}")
	@Pattern(regexp = "^[^\\d]*$", message = "{message.STATE_NAME.NO_DIGITS}")
	private String stateName;

	@NotNull(message = "{message.STATE_STATUS.REQUIRED}")
	private StateStatus stateStuStatus;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

}
