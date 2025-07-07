package com.ddpl.paathner.country;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ddpl.paathner.country.projection.GetCountryProjection;

public interface CountryRepository extends JpaRepository<Country, Long> {

	@Query("SELECT c FROM Country c")
	List<GetCountryProjection> getAllCountries(); 
	
	@Query("SELECT c FROM Country c WHERE c.id = :id")
	Optional<GetCountryProjection> findCountryViewById(@Param("id") Long id); 
	
	boolean existsByCountryNameIgnoreCase(String CounteryName);
}
