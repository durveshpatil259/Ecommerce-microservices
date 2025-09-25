package com.project.feignclients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.dto.UserDto;

@FeignClient(name="user-service")
@LoadBalancerClient
public interface UserFeignClient {

	@GetMapping("/api/users/{userId}")
	public UserDto fetchUser(@PathVariable("userId") Integer userId);
}