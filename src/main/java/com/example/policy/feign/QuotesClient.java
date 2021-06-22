package com.example.policy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.policy.request.QuoteRequest;

@FeignClient(name = "quotes-service", url = "http://18.234.202.143:8084")
public interface QuotesClient {
	
	@GetMapping("/getQuotesForPolicy") 
	public Long getQuotesForPolicy(@RequestParam String token,
			@RequestParam long businessValue,@RequestParam long propertyValue,
			@RequestParam String propertyType,
			@RequestParam long policyId);

}