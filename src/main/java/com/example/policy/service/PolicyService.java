package com.example.policy.service;
import com.example.policy.exception.ConsumerNotFoundException;
import com.example.policy.exception.PolicyNotFoundException;
import com.example.policy.request.CreatePolicyRequest;
import com.example.policy.request.IssuePolicyRequest;
import com.example.policy.response.ConsumerBusinessDetails;
import com.example.policy.response.PolicyDetailsResponse;



public interface PolicyService {

	long getQuotes(String token,long id);

	PolicyDetailsResponse viewPolicy(String token,Long consumerid, Long policyid) throws PolicyNotFoundException, ConsumerNotFoundException;

	String issuePolicy(String token,IssuePolicyRequest issuePolicyRequest) throws ConsumerNotFoundException;

	String createPolicy(String token,CreatePolicyRequest createPolicyRequest) throws ConsumerNotFoundException;
	
	ConsumerBusinessDetails getConsumerBusiness(String token,Long consumerid);
	
}