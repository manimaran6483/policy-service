package com.example.policy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Entity(name="POLICY_MASTER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyMaster {
	
	@Override
	public String toString() {
		return "PolicyMaster [id=" + id + ", pid=" + pid + ", propertytype=" + propertytype + ", consumertype="
				+ consumertype + ", assuredsum=" + assuredsum + ", tenure=" + tenure + ", businessvalue="
				+ businessvalue + ", propertyvalue=" + propertyvalue + ", baselocation=" + baselocation + ", type="
				+ type + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "Policy_ID")
	private Long pid;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "Property_Type")
	private String propertytype;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "Consumer_Type")
	private String consumertype;

	@NotBlank
	@Size(max = 40)
	@Column(name = "Assured_Sum")
	private String assuredsum;

	@NotBlank
	@Size(max = 30)
	@Column(name = "Tenure")
	private String tenure;

	@NotNull
	@Column(name = "Business_Value")
	private Long businessvalue;
	
	@NotNull
	@Column(name = "Property_Value")
	private Long propertyvalue;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "Base_Location")
	private String baselocation;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "Type")
	private String type;
}
