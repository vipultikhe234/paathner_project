package com.ddpl.paathner.country;


public class CountryMapper {

	public static Country mapToCountry(CountryDto countryDto) {
		Country country = new Country(countryDto.getCountryId(), countryDto.getCountryCode(),
				countryDto.getMobileCode(), countryDto.getCountryName(), countryDto.getCountryStatus(),
				countryDto.getCreatedAt(), countryDto.getUpdatedAt(),null);
		return country;
	}

	public static CountryDto mapToCountryDto(Country country) {
		CountryDto countryDto = new CountryDto(country.getCountryId(), country.getCountryCode(),
				country.getMobileCode(), country.getCountryName(), country.getCountryStatus(), country.getCreatedAt(),
				country.getUpdatedAt());
		return countryDto;

	}

}
