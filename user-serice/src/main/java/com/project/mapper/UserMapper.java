package com.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.dto.UserDto;
import com.project.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(source = "email",target = "emailAddress")
	@Mapping(source = "phone",target = "contact")
	UserDto toDto(User user);
	
	@Mapping(source = "emailAddress",target = "email")
	@Mapping(source = "contact",target = "phone")
	User toEntity(UserDto userDto);
}
