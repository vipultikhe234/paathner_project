package com.ddpl.paathner.country;

import java.time.LocalDateTime;

import com.ddpl.paathner.country.Country.CountryStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
	private long countryId;
	private String countryCode;
	private String mobileCode;
	private String countryName;
	private CountryStatus countryStatus;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
