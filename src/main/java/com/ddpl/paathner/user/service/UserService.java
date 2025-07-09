package com.ddpl.paathner.user.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ddpl.paathner.user.User;
import com.ddpl.paathner.user.UserDto;

public interface UserService {

	ResponseEntity<Map<String, Object>> insertUser(UserDto userDto);

	User getUserDetailByEmail(String UserEmail);

	ResponseEntity<Map<String, Object>> logInUser(UserDto userDto);

}
