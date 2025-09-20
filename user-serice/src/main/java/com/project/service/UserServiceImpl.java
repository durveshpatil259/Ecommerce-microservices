package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dto.UserDto;
import com.project.mapper.UserMapper;
import com.project.models.Credential;
import com.project.models.User;
import com.project.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	

	@Override
	public UserDto save(UserDto userDto) {
		User user = userMapper.toEntity(userDto);
		Credential credential = user.getCredential();
		
		credential.setUser(user);
		User dbUser = userRepository.save(user);
		return userMapper.toDto(dbUser);
	}

	@Override
	public UserDto findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto update(Integer userId, UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

}
