package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.UserDto;
import com.project.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) // 201
	public UserDto createUser(@Valid @RequestBody UserDto userDto) {
		log.info("UserController :: createUser {}",userDto.getEmailAddress());
		return userService.save(userDto);
	}
	
	@GetMapping("/{userId}")
	public UserDto fetchUser(@PathVariable Integer userId) {
		log.info("UserController :: fetchUser for {} ",userId);
		return userService.findById(userId);
	}
}
