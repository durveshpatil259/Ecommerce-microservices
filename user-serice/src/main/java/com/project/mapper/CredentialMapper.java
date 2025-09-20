package com.project.mapper;

import org.mapstruct.Mapper;

import com.project.dto.CredentialDto;
import com.project.models.Credential;

@Mapper(componentModel = "spring")
public interface CredentialMapper {
	
	CredentialDto toDto(Credential credential);

}
