package com.ddpl.paathner.country;

public class CountryMapper {
	
	public static Country mapToCountry(CountryDto countryDto) {
		Country country=new Country(
				countryDto.getCountryId(),
				countryDto.get
				);
	}

}
