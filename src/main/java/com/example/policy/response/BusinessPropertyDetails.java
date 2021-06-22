package com.example.policy.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessPropertyDetails {

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	private Long propertyId;
	

	private Long businessId;
	

	private Long consumerId;
	

	private String insurancetype;
	

	private String propertytype;
	

	private String buildingsqft;

	private String buildingtype;
	
	
	private String buildingstoreys;
	

	private Long buildingage;

	private Long costoftheasset;
	

	private Long salvagevalue;
	

	private Long usefullifeoftheAsset;

	private Long propertyValue;

}
