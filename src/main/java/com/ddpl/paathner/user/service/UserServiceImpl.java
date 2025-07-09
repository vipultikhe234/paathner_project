package com.ddpl.paathner.user.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ddpl.paathner.common.exception.DuplicateResourceException;
import com.ddpl.paathner.common.exception.ResourceNotFoundException;
import com.ddpl.paathner.common.helper.ApiResponseUtil;
import com.ddpl.paathner.security.jwt.JwtUtil;
import com.ddpl.paathner.user.User;
import com.ddpl.paathner.user.UserDto;
import com.ddpl.paathner.user.UserMapper;
import com.ddpl.paathner.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	private static final Logger log = LoggerFactory.getLogger(UserDto.class);

	@Override
	public ResponseEntity<Map<String, Object>> insertUser(UserDto userDto) {
		User user = UserMapper.mapToUser(userDto);
		if (userRepository.existsByEmailIgnoreCase(user.getEmail())) {
			String message = messageSource.getMessage("message.DUPLICATE_USER_EMAIL", null,
					LocaleContextHolder.getLocale());
			throw new DuplicateResourceException(message);
		}
		user.setUserPassword(encoder.encode(user.getUserPassword()));
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

	@Override
	public User getUserDetailByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new ResourceNotFoundException("User");
		}
		return user;
	}

	@Override
	public ResponseEntity<Map<String, Object>> logInUser(UserDto userDto) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getUserPassword()));
			User user = this.getUserDetailByEmail(userDto.getEmail());
			String jwt = jwtUtil.generateToken(user.getEmail());
			String message = messageSource.getMessage("message.USER_GET_SUCCESS", null,
					LocaleContextHolder.getLocale());
			return ApiResponseUtil.success(message, "jwt_token", jwt, HttpStatus.OK);
		} catch (Exception e) {
			log.info("Authenticating with: {}", authenticationManager.getClass());
			String message = messageSource.getMessage("message.USER_LOGIN_FAIL", null, LocaleContextHolder.getLocale());
			return ApiResponseUtil.error(message, null, HttpStatus.BAD_REQUEST);
		}
	}
}
