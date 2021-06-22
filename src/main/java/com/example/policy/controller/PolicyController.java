package com.example.policy.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.policy.exception.ConsumerNotFoundException;
import com.example.policy.exception.PolicyNotFoundException;
import com.example.policy.feign.AuthClient;
import com.example.policy.request.CreatePolicyRequest;
import com.example.policy.request.IssuePolicyRequest;
import com.example.policy.response.PolicyDetailsResponse;
import com.example.policy.service.PolicyService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class PolicyController {

	@Autowired
	private PolicyService policyService; 
	
	@Autowired
	private AuthClient auth; 
	
	@PostMapping("/createPolicy")
	public String createPolicy(String token,
			@RequestBody CreatePolicyRequest createPolicyRequest) throws ConsumerNotFoundException {
		if(auth.validate(token)) {
			log.info("Start createPolicy");
			String messageResponse = policyService.createPolicy(token,createPolicyRequest);
			log.debug("MessageResponse : {}", messageResponse);
			log.info("End createPolicy");
			return (messageResponse);
		}
		else {
			return "Invalid Token";
		}
	}

	@PostMapping("/issuePolicy")
	public String issuePolicy(String token,
			@RequestBody IssuePolicyRequest issuePolicyRequest) throws ConsumerNotFoundException {
		if(auth.validate(token)) {
			log.info("Start issuePolicy");

			
			if (!(issuePolicyRequest.getPaymentdetails().equals("Success"))) {
				return "Sorry!!, Payment Failed!! Try Again";
			}
			//i/f(StringUtils.e)
			if (!(issuePolicyRequest.getAcceptancestatus().equals("Accepted"))) {
				return "Sorry!!, Accepted Failed !! Try Again";
			}
			log.info(issuePolicyRequest.getConsumerid()+issuePolicyRequest.getPaymentdetails()+issuePolicyRequest.getPolicyid());
			String messageResponse = policyService.issuePolicy(token,issuePolicyRequest);
			log.debug("MessageResponse : {}", messageResponse);
			log.info("End issuePolicy");
			return messageResponse;
		}
		else {
			return "Invalid token";
		}
	}

	@GetMapping("/viewPolicy")
	public ResponseEntity<?> viewPolicy(String token,
			 @RequestParam Long consumerid, @RequestParam Long policyid) throws PolicyNotFoundException, ConsumerNotFoundException {
		if(auth.validate(token)) {
			log.info("Start viewPolicy");
			
			PolicyDetailsResponse policyDetailsResponse = policyService.viewPolicy(token,consumerid, policyid);
			log.debug("PolicyDetailsResponse: {}", policyDetailsResponse);
			log.info("End viewPolicy");
			return ResponseEntity.ok(policyDetailsResponse);
		}
		else {
			return ResponseEntity.badRequest().body("Invalid Token");
		}
	}

	
}