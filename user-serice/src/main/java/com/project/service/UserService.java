package com.project.service;

import com.project.dto.UserDto;

public interface UserService {

	UserDto save(UserDto userDto);
	UserDto findById(Integer userId);
	UserDto update(Integer userId,UserDto user);
}
