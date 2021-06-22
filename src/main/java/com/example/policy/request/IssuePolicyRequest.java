package com.example.policy.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class IssuePolicyRequest {


	@Override
	public String toString() {
		return "IssuePolicyRequest [policyid=" + policyid + ", consumerid=" + consumerid + ", businessid=" + businessid
				+ ", paymentdetails=" + paymentdetails + ", acceptancestatus=" + acceptancestatus + "]";
	}
	@NotBlank
	private Long policyid;
	@NotNull
	private Long consumerid;
	@NotNull
	private Long businessid;
	@NotBlank
	private String paymentdetails;
	@NotBlank
	private String acceptancestatus;
	public Long getPolicyid() {
		return policyid;
	}
	public void setPolicyid(Long policyid) {
		this.policyid = policyid;
	}
	public Long getConsumerid() {
		return consumerid;
	}
	public void setConsumerid(Long consumerid) {
		this.consumerid = consumerid;
	}
	public Long getBusinessid() {
		return businessid;
	}
	public void setBusinessid(Long businessid) {
		this.businessid = businessid;
	}
	public String getPaymentdetails() {
		return paymentdetails;
	}
	public void setPaymentdetails(String paymentdetails) {
		this.paymentdetails = paymentdetails;
	}
	public String getAcceptancestatus() {
		return acceptancestatus;
	}
	public void setAcceptancestatus(String acceptancestatus) {
		this.acceptancestatus = acceptancestatus;
	}

}
