package com.example.project3.controller;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.comons.transporter.FailFactory;
import com.example.project3.comons.transporter.SuccessFactory;
import com.example.project3.comons.transporter.Transporter;
import com.example.project3.pojo.Corporation;
import com.example.project3.service.CorporationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/corporate")
public class CorporationController {
	private SuccessFactory successFactory;
	private CorporationService corporationService;

	@Autowired
	public void setSuccessFactory (SuccessFactory successFactory) {
		this.successFactory = successFactory;
	}

	@Autowired
	public void setCorporationService (CorporationService corporationService) {
		this.corporationService = corporationService;
	}

	@ApiOperation("创建法人")
	@GetMapping("/create/{name}/{status}/{bankName}/{account}/{shortName}/" +
			"{representativeName}/{registrationArea}/{registeredMoney}/{contactName}/{contactTelephone}" +
			"/{fax}/{email}/{businessLisenseUrl}/{taxUrl}/{organizationIdUrl}/{accountOpeningLisenseUrl}" +
			"/{coalBusinessLisenseUrl}/{idCardUrl}/{resourcePlaces}/{transportWay}/{introduction}/{auditOpinion}")
	public Transporter create (@PathVariable("name") String name,
	                           @PathVariable("status") String statusString,
	                           @PathVariable("bankName") String bankName,
	                           @PathVariable("account") String account,
	                           @PathVariable("shortName") String shortName,
	                           @PathVariable("representativeName") String representativeName,
	                           @PathVariable("registrationArea") String registrationArea,
	                           @PathVariable("registeredMoney") String registeredMoneyString,
	                           @PathVariable("contactName") String contactName,
	                           @PathVariable("contactTelephone") String contactTelephone,
	                           @PathVariable("fax") String fax,
	                           @PathVariable("email") String email,
	                           @PathVariable("businessLisenseUrl") String businessLisenseUrl,
	                           @PathVariable("taxUrl") String taxUrl,
	                           @PathVariable("organizationIdUrl") String organizationIdUrl,
	                           @PathVariable("accountOpeningLisenseUrl") String accountOpeningLisenseUrl,
	                           @PathVariable("coalBusinessLisenseUrl") String coalBusinessLisenseUrl,
	                           @PathVariable("idCardUrl") String idCardUrl,
	                           @PathVariable("resourcePlaces") String resourcePlaces,
	                           @PathVariable("transportWay") String transportWay,
	                           @PathVariable("introduction") String introduction,
	                           @PathVariable("auditOpinion") String auditOpinion) throws CloneNotSupportedException {
		var corporation = new Corporation();
		var status = Byte.valueOf(statusString);
		byte enable = 0;
		var registeredMoney = new BigDecimal(registeredMoneyString);
		corporation.setName(name)
				.setStatus(status)
				.setBankName(bankName)
				.setAccount(account)
				.setShortName(shortName)
				.setRepresentativeName(representativeName)
				.setRegistrationArea(registrationArea)
				.setRegistrationMoney(registeredMoney)
				.setContactName(contactName)
				.setContactTelephone(contactTelephone)
				.setFax(fax)
				.setEmail(email)
				.setBusinessLicenseUrl(businessLisenseUrl)
				.setTaxUrl(taxUrl)
				.setOrganizationIdUrl(organizationIdUrl)
				.setAccountOpeningLicenseUrl(accountOpeningLisenseUrl)
				.setCoalBusinessLicenseUrl(coalBusinessLisenseUrl)
				.setIdCardUrl(idCardUrl)
				.setResourcePlaces(resourcePlaces)
				.setTransportWay(transportWay)
				.setIntroduction(introduction)
				.setAuditOpinion(auditOpinion).setEnable(enable);
		corporationService.insert(corporation);
		var transporter = successFactory.getDeliverPackage("" + corporation.getId());
		transporter.addData("data", corporation);
		return transporter;

	}

	@ApiOperation("删除法人")
	@GetMapping("delete/{corporateId}")
	public Transporter delete (@PathVariable("corporateId") Integer corporateId) throws CloneNotSupportedException{
		corporationService.delete(corporateId);
		return successFactory.getDeliverPackage("成功删除");

	}

	@ApiOperation("更新法人")
	@GetMapping("/update/{corporateId}/{name}/{status}/{bankName}/{account}/{shortName}/" +
			"{representativeName}/{registrationArea}/{registeredMoney}/{contactName}/{contactTelephone}" +
			"/{fax}/{email}/{businessLisenseUrl}/{taxUrl}/{organizationIdUrl}/{accountOpeningLisenseUrl}" +
			"/{coalBusinessLisenseUrl}/{idCardUrl}/{resourcePlaces}/{transportWay}/{introduction}/{auditOpinion}")
	public Transporter create (@PathVariable("corporateId") Integer corporateId,
	                           @PathVariable("name") String name,
	                           @PathVariable("status") String statusString,
	                           @PathVariable("bankName") String bankName,
	                           @PathVariable("account") String account,
	                           @PathVariable("shortName") String shortName,
	                           @PathVariable("representativeName") String representativeName,
	                           @PathVariable("registrationArea") String registrationArea,
	                           @PathVariable("registeredMoney") String registeredMoneyString,
	                           @PathVariable("contactName") String contactName,
	                           @PathVariable("contactTelephone") String contactTelephone,
	                           @PathVariable("fax") String fax,
	                           @PathVariable("email") String email,
	                           @PathVariable("businessLisenseUrl") String businessLisenseUrl,
	                           @PathVariable("taxUrl") String taxUrl,
	                           @PathVariable("organizationIdUrl") String organizationIdUrl,
	                           @PathVariable("accountOpeningLisenseUrl") String accountOpeningLisenseUrl,
	                           @PathVariable("coalBusinessLisenseUrl") String coalBusinessLisenseUrl,
	                           @PathVariable("idCardUrl") String idCardUrl,
	                           @PathVariable("resourcePlaces") String resourcePlaces,
	                           @PathVariable("transportWay") String transportWay,
	                           @PathVariable("introduction") String introduction,
	                           @PathVariable("auditOpinion") String auditOpinion) throws CloneNotSupportedException {
		var corporation = new Corporation();
		var status = Byte.valueOf(statusString);
		var registeredMoney = new BigDecimal(registeredMoneyString);
		corporation.setId(corporateId)
				.setName(name)
				.setStatus(status)
				.setBankName(bankName)
				.setAccount(account)
				.setShortName(shortName)
				.setRepresentativeName(representativeName)
				.setRegistrationArea(registrationArea)
				.setRegistrationMoney(registeredMoney)
				.setContactName(contactName)
				.setContactTelephone(contactTelephone)
				.setFax(fax)
				.setEmail(email)
				.setBusinessLicenseUrl(businessLisenseUrl)
				.setTaxUrl(taxUrl)
				.setOrganizationIdUrl(organizationIdUrl)
				.setAccountOpeningLicenseUrl(accountOpeningLisenseUrl)
				.setCoalBusinessLicenseUrl(coalBusinessLisenseUrl)
				.setIdCardUrl(idCardUrl)
				.setResourcePlaces(resourcePlaces)
				.setTransportWay(transportWay)
				.setIntroduction(introduction)
				.setAuditOpinion(auditOpinion);
		corporationService.update(corporation);
		var transporter = successFactory.getDeliverPackage("更新成功");
		transporter.addData("data", corporation);
		return transporter;
	}
}
























