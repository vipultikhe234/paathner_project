package com.ddpl.paathner.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ddpl.paathner.common.exception.DuplicateResourceException;
import com.ddpl.paathner.common.helper.ApiResponseUtil;
import com.ddpl.paathner.user.User;
import com.ddpl.paathner.user.UserDto;
import com.ddpl.paathner.user.UserMapper;
import com.ddpl.paathner.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	MessageSource messageSource;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<Map<String, Object>> insertUser(UserDto userDto) {
		User user = UserMapper.mapToUser(userDto);
		if (userRepository.existsByEmailIgnoreCase(user.getEmail())) {
			String message = messageSource.getMessage("message.DUPLICATE_USER_EMAIL", null,
					LocaleContextHolder.getLocale());
			throw new DuplicateResourceException(message);
		}
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		User savedUser = userRepository.save(user);
		if (savedUser != null) {
			String message = messageSource.getMessage("message.USER_SAVED", null, LocaleContextHolder.getLocale());
			return ApiResponseUtil.success(message, "Country_id", savedUser.getUserId(), HttpStatus.CREATED);
		} else {
			String message = messageSource.getMessage("message.USER_SAVE_FAILED", null,
					LocaleContextHolder.getLocale());
			return ApiResponseUtil.error(message, null, HttpStatus.BAD_REQUEST);
		}
	}

}
