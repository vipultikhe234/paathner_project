package com.ddpl.paathner.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddpl.paathner.common.helper.ApiResponseUtil;
import com.ddpl.paathner.country.validation.onCreate;
import com.ddpl.paathner.user.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/insert_user")
	ResponseEntity<Map<String, Object>> insertUser(@Validated(onCreate.class)@ModelAttribute UserDto userDto,BindingResult result){
		if(result.hasErrors()) {
			return ApiResponseUtil.validationError(result);
		}
		return userService.insertUser(userDto);
	}

}
