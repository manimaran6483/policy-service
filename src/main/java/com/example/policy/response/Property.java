package com.example.policy.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {

	private Long id;

	private Long businessId;

	private Long consumerId;

	private String insurancetype;

	private String propertytype;

	private String buildingsqft;

	private String buildingtype;

	private String buildingstoreys;

	private Long buildingage;

	private Long propertyvalue;

	private Long costoftheasset;

	private Long salvagevalue;

	private Long usefullifeoftheAsset;







}