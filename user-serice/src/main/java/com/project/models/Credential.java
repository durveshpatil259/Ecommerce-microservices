package com.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Credential {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer credentialId;
	
	@Column(unique = true)
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private RoleBasedAuthority roleBasedAuthority;
	
	@JsonIgnore  // not to include this field in json response
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",unique = true)
	private User user;
	
	

}
