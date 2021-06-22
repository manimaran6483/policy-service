package com.example.policy.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreatePolicyRequest {

	@Override
	public String toString() {
		return "CreatePolicyRequest [consumerid=" + consumerid + ", acceptedquotes=" + acceptedquotes + "]";
	}
	@NotNull
	private Long consumerid;
	@NotBlank
	private String acceptedquotes;
	
	public Long getConsumerid() {
		return consumerid;
	}
	public void setConsumerid(Long consumerid) {
		this.consumerid = consumerid;
	}
	public String getAcceptedquotes() {
		return acceptedquotes;
	}
	public void setAcceptedquotes(String acceptedquotes) {
		this.acceptedquotes = acceptedquotes;
	}

	

}
