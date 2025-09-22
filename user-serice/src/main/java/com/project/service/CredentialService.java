package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.CredentialDto;
import com.project.mapper.CredentialMapper;
import com.project.repository.CredentialRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CredentialService {
	
	@Autowired
	private CredentialRepository credentialRepository;
	
	@Autowired
	private CredentialMapper credentialMapper;
	
	
	public CredentialDto findByUsername(String username) {
		return credentialRepository.findByUsername(username)
				.map(credentialMapper::toDto)
				.orElseThrow(() -> new RuntimeException("Username not found in db"));
	}

}
