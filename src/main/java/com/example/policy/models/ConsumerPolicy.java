package com.example.policy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Consumer_Policy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerPolicy {
	@Override
	public String toString() {
		return "ConsumerPolicy [id=" + id + ", consumerid=" + consumerid + ", policyid=" + policyid + ", businessid="
				+ businessid + ", paymentdetails=" + paymentdetails + ", acceptancestatus=" + acceptancestatus
				+ ", policystatus=" + policystatus + ", effectivedate=" + effectivedate + ", covered_sum=" + covered_sum
				+ ", duration=" + duration + ", acceptedquote=" + acceptedquote + ", quotation=" + quotation + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;
	
	@NotNull
	@Column(name = "Consumer_ID")
	private Long consumerid;
	
	@Size(max = 10)
	@Column(name = "Policy_ID")
	private Long policyid;
	
	@NotNull
	@Column(name = "Business_ID")
	private Long businessid;
	
	@Size(max = 10)
	@Column(name = "Payment_Details")
	private String paymentdetails;
	
	@Size(max = 10)
	@Column(name = "Acceptance_Status")
	private String acceptancestatus;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "Policy_Status")
	private String policystatus;
	
	@Size(max = 20)
	@Column(name = "Effective_Date")
	private String effectivedate;
	
	@Size(max = 15)
	@Column(name = "Covered_Sum")
	private String covered_sum;
	
	
	@Size(max = 15)
	@Column(name = "Duration")
	private String duration;
	
	@NotBlank
	@Size(max = 15)
	@Column(name = "Accepted_Quotes")
	private String acceptedquote;

	@NotNull
	@Column(name="quote")
	private long quotation;
	public ConsumerPolicy(@NotNull Long consumerid, @NotNull Long businessid,
			@NotBlank @Size(max = 10) String policystatus, @NotBlank @Size(max = 15) String acceptedquote) {
		super();
		this.consumerid = consumerid;
		this.businessid = businessid;
		this.policystatus = policystatus;
		this.acceptedquote = acceptedquote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConsumerid() {
		return consumerid;
	}

	public void setConsumerid(Long consumerid) {
		this.consumerid = consumerid;
	}

	public Long getPolicyid() {
		return policyid;
	}

	public void setPolicyid(Long policyid) {
		this.policyid = policyid;
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

	public String getPolicystatus() {
		return policystatus;
	}

	public void setPolicystatus(String policystatus) {
		this.policystatus = policystatus;
	}

	public String getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getCovered_sum() {
		return covered_sum;
	}

	public void setCovered_sum(String covered_sum) {
		this.covered_sum = covered_sum;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAcceptedquote() {
		return acceptedquote;
	}

	public void setAcceptedquote(String acceptedquote) {
		this.acceptedquote = acceptedquote;
	}



		
}
