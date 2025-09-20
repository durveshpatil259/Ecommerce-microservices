package com.project.dto;

import com.project.models.RoleBasedAuthority;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CredentialDto {

	private String username;
	private String password;
	private RoleBasedAuthority roleBasedAuthority;
}
