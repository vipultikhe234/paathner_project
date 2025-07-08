package com.ddpl.paathner.user.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ddpl.paathner.user.UserDto;

public interface UserService {

	ResponseEntity<Map<String, Object>> insertUser(UserDto userDto);

}
