package com.example.project3.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 橙鼠鼠
 */
@Data
@Accessors(chain = true)
public class Corporation implements Serializable,Cloneable {
	Integer id;
	Byte enable;
	Byte status;
	BigDecimal leftMoney;
	BigDecimal offerFrozen;
	BigDecimal performanceFrozen;
	BigDecimal registrationMoney;
	String name;
	String bankName;
	String account;
	String shortName;
	String representationName;
	String registrationArea;
	String contactName;
	String contactTelephone;
	String fax;
	String email;
	String businessLicenseUrl;
	String taxUrl;
	String organizationIdUrl;
	String accountOpeningLicensesUrl;
	String coalBusinessLicenseUrl;
	String idCardUrl;
	String resourcePlaces;
	String transportWay;
	String introduction;
	String auditOpinion;
}
