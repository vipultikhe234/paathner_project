package com.ddpl.paathner.user;

import java.time.LocalDateTime;

import com.ddpl.paathner.country.validation.onCreate;
import com.ddpl.paathner.user.User.UserStatus;

import jakarta.validation.constraints.Email;
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
public class UserDto {

	@NotNull(message = "{message.USER.REQUIRED}")
	private long userId;

	@NotBlank(message = "{message.USER_NAME.REQUIRED}", groups = onCreate.class)
	@Size(max = 255, message = "{message.USER_NAME.MAX}")
	private String userName;

	@NotBlank(message = "{message.USER_EMAIL.REQUIRED}", groups = onCreate.class)
	@Email(message = "{message.USER_EMAIL.INVALID}", groups = onCreate.class)
	private String email;

	@NotBlank(message = "{message.USER_PASSWORD.REQUIRED}", groups = onCreate.class)
	@Size(min = 8, max = 15, message = "{message.USER_PASSWORD.SIZE}", groups = onCreate.class)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "{message.USER_PASSWORD.WEAK}", groups = onCreate.class)
	private String userPassword;

	@NotNull(message = "{message.USER_CONTACT_NUMBER.REQUIRED}", groups = onCreate.class)
	private long userContactNumber;

	private UserStatus userStatus;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
