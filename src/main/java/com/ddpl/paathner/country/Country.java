package com.ddpl.paathner.country;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "country")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id", updatable = false, nullable = false)
	private long countryId;

	@Column(name = "country_code", length = 50)
	private String countryCode;

	@Column(name = "mobile_code", length = 11, nullable = false)
	private String mobileCode;

	@Column(name = "country_name", length = 100, nullable = false)
	private String countryName;

	@Enumerated(EnumType.STRING)
	@Column(name = "country_status", nullable = false)
	private CountryStatus countryStatus;

	@CreatedDate
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	public enum CountryStatus {
	    ON, OFF
	}


}
