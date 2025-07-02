package com.ddpl.paathner.country;

import java.time.LocalDateTime;

import com.ddpl.paathner.country.Country.CountryStatus;
import com.ddpl.paathner.country.validation.onCreate;
import com.ddpl.paathner.country.validation.onUpdate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
	
	private long countryId;
	
	@NotBlank(message="{message.COUNTRY_CODE.REQUIRED}",groups = {onCreate.class, onUpdate.class})
	@Pattern(regexp = "^[A-Z]{2}$", message = "{message.COUNTRY_CODE.REGEX}",groups = {onCreate.class, onUpdate.class})
    @Size(max = 2, message = "{message.COUNTRY_CODE.SIZE}",groups = {onCreate.class, onUpdate.class})
	private String countryCode;
	
	@NotBlank(message="{message.MOBILE_CODE.REQUIRED}",groups = {onCreate.class,onUpdate.class})
	@Pattern(regexp = "^\\+?\\d+$", message = "{message.MOBILE_CODE.REGEX}",groups = {onCreate.class, onUpdate.class})
    @Size(max = 50, message = "{message.MOBILE_CODE.SIZE}",groups = {onCreate.class, onUpdate.class})
	private String mobileCode;
	
	@NotBlank(message= "{message.COUNTRY_NAME.REQUIRED}",groups = {onCreate.class,onUpdate.class})
	@Pattern(regexp = "^[\\p{L}\\s\\-().,&’']+$", message = "{message.COUNTRY_NAME.PATTERN}",groups = {onCreate.class, onUpdate.class})
    @Size(max = 100, message = "{message.COUNTRY_NAME.SIZE}",groups = {onCreate.class, onUpdate.class})
	private String countryName;
	
	@NotNull(message="{message.COUNTRY_STATUS.REQUIRED}",groups = {onCreate.class,onUpdate.class})
	private CountryStatus countryStatus;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;

}
