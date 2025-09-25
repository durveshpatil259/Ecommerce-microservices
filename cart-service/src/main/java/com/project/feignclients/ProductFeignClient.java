package com.project.feignclients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service")
//@FeignClient(name="product",url="http://localhost:8051")
@LoadBalancerClient
public interface ProductFeignClient {

	@GetMapping("/products/exits/{productId}")
	public boolean isProductExits(@PathVariable("productId") Long productId);
}
