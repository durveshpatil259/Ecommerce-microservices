package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.models.Credential;


public interface CredentialRepository extends JpaRepository<Credential, Integer>{
	
    Optional<Credential> findByUsername(String username);
	
	Optional<Credential> findByusernameAndPassword(String username,String password);
	

	//@Query(value = "select uname,password from user",nativeQuery = true)
	//Object[] fetchUserINformation(String username);

}
