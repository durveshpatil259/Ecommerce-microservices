package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.UserDto;
import com.project.mapper.UserMapper;
import com.project.models.Credential;
import com.project.models.User;
import com.project.repository.UserRepository;

@Service
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
		
		return userRepository.findById(userId).map(userMapper::toDto).orElseThrow(()-> new RuntimeException());
	}

	@Override
	public UserDto update(Integer userId, UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

}
