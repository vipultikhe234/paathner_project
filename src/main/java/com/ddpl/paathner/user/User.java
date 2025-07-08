package com.ddpl.paathner.user;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_id", updatable = false, nullable = false)
	private long userId;

	@Column(name = "user_name", length = 250, nullable = false)
	private String userName;

	@Column(name = "user_email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "user_password", length = 1024, nullable = false)
	private String userPassword;

	@Column(name = "user_contact_number", nullable = false)
	private long userContactNumber;

	@Column(name = "User_status")
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;

	@CreatedDate
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public enum UserStatus {
		ON, OFF
	}

}
