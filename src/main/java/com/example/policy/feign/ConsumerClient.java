package com.example.policy.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.policy.response.BusinessPropertyDetails;
import com.example.policy.response.ConsumerBusinessDetails;
import com.example.policy.response.Property;


@FeignClient(name = "consumer-client", url = "http://54.242.74.69:8082")
public interface ConsumerClient {
	
	@GetMapping("/viewConsumerBusiness")
	public ConsumerBusinessDetails viewConsumerBusiness(@RequestParam String token,
		 @RequestParam Long Id);
	@GetMapping("/viewConsumerProperty")
	public Property viewBusinessProperty(@RequestHeader(name="Authorization") String token,
			@RequestParam Long consumerid);
}