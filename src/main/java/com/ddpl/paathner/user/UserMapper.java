package com.ddpl.paathner.user;

public class UserMapper {
	public static User mapToUser(UserDto userDto) {
		User user = new User(userDto.getUserId(), userDto.getUserName(), userDto.getEmail(),
				userDto.getUserPassword(), userDto.getUserContactNumber(), userDto.getUserStatus(),
				userDto.getCreatedAt(), userDto.getUpdatedAt());
		return user;
	}

	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(user.getUserId(), user.getUserName(), user.getEmail(), user.getUserPassword(),
				user.getUserContactNumber(), user.getUserStatus(), user.getCreatedAt(), user.getUpdatedAt());
		return userDto;
	}
}
