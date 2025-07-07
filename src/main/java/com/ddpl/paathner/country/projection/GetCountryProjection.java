package com.ddpl.paathner.country.projection;

import com.ddpl.paathner.country.Country.CountryStatus;

public interface GetCountryProjection {
	long getCountryId();

	String getCountryCode();

	String getMobileCode();

	String getCountryName();

	CountryStatus getCountryStatus();

}
