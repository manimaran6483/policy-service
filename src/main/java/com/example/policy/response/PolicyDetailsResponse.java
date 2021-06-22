package com.example.policy.response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PolicyDetailsResponse {
	@Override
	public String toString() {
		return "PolicyDetailsResponse [consumerid=" + consumerid + ", policyid=" + policyid + ", property_type="
				+ property_type + ", consumer_type=" + consumer_type + ", assured_sum=" + assured_sum + ", tenure="
				+ tenure + ", business_value=" + business_value + ", property_value=" + property_value
				+ ", base_location=" + base_location + ", type=" + type + ", businessid=" + businessid
				+ ", paymentdetails=" + paymentdetails + ", acceptancestatus=" + acceptancestatus + ", policystatus="
				+ policystatus + ", effectivedate=" + effectivedate + ", covered_sum=" + covered_sum + ", duration="
				+ duration + ", acceptedquote=" + acceptedquote + "]";
	}

	public PolicyDetailsResponse(Long consumerid2, Long pid, String propertytype,
			String consumertype,
			String assuredsum, String tenure2, Long businessvalue, 
			Long propertyvalue, String baselocation,
			String type2, Long businessid2, String paymentdetails2, 
			String acceptancestatus2, String policystatus2,
			String effectivedate2, String covered_sum2,
			String duration2, String acceptedquote2) {
		// TODO Auto-generated constructor stub
		this.consumerid = consumerid2;
		this.policyid=pid;
		this.property_type= propertytype;
		this.consumer_type = consumertype;
		this.assured_sum = assuredsum;
		this.tenure =tenure2;
		this.business_value = businessvalue;
		this.property_value=propertyvalue;
		this.base_location=baselocation;
		this.type=type2;
		this.businessid=businessid2;
		this.paymentdetails =paymentdetails2;
		this.acceptancestatus=acceptancestatus2;
		this.policystatus=policystatus2;
		this.effectivedate=effectivedate2;
		this.covered_sum=covered_sum2;
		this.duration=duration2;
		this.acceptedquote=acceptedquote2;
		
	}

	private Long consumerid;

	private Long policyid;

	private String property_type;

	private String consumer_type;


	private String assured_sum;

	private String tenure;

	private Long business_value;

	private Long property_value;


	private String base_location;

	private String type;

	private Long businessid;

	private String paymentdetails;

	private String acceptancestatus;

	private String policystatus;

	private String effectivedate;

	private String covered_sum;

	private String duration;

	private String acceptedquote;
	

}