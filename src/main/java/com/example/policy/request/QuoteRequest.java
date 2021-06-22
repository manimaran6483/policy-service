package com.example.policy.request;

public class QuoteRequest {

	@Override
	public String toString() {
		return "QuoteRequest [policyId=" + policyId + ", property_type=" + property_type + ", business_value="
				+ business_value + ", property_value=" + property_value + "]";
	}
	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}
	public String getProperty_type() {
		return property_type;
	}
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}
	public long getBusiness_value() {
		return business_value;
	}
	public void setBusiness_value(long business_value) {
		this.business_value = business_value;
	}
	public long getProperty_value() {
		return property_value;
	}
	public void setProperty_value(long property_value) {
		this.property_value = property_value;
	}
	private long policyId;
	private String property_type;
	private long business_value;
	private long property_value;
	public QuoteRequest(long policyId, String property_type, long business_value, long property_value) {
		super();
		this.policyId = policyId;
		this.property_type = property_type;
		this.business_value = business_value;
		this.property_value = property_value;
	}
}