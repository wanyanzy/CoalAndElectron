package com.example.project3.controller;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.comons.transporter.SuccessFactory;
import com.example.project3.comons.transporter.Transporter;
import com.example.project3.pojo.OfferPrice;
import com.example.project3.service.OfferPriceService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/offer")
@Slf4j
public class OfferController {
	private SuccessFactory successFactory;
	private OfferPriceService offerPriceService;

	@Autowired
	public void setSuccessFactory (SuccessFactory successFactory) {
		this.successFactory = successFactory;
	}


	@Autowired
	public void setOfferPriceService (OfferPriceService offerPriceService) {
		this.offerPriceService = offerPriceService;
	}

	@ApiOperation("发起报价")
	@GetMapping("/create/{price}/{amount}/{userId}/{bidId}/{message}")
	public Transporter create (@PathVariable("price") String priceSting,
	                           @PathVariable("amount") Integer amount,
	                           @PathVariable("userId") Integer userId,
	                           @PathVariable("bidId") Integer bidId,
	                           @PathVariable("message") String message) throws CloneNotSupportedException{
		var offerPrice = new OfferPrice();
		var price = new BigDecimal(priceSting);
		byte enable = 0;
		offerPrice.setPrice(price)
				.setAmount(amount)
				.setUserId(userId)
				.setBidId(bidId)
				.setMessage(message)
				.setEnable(enable);
		offerPriceService.insert(offerPrice);
		var transporter = successFactory.getDeliverPackage("成功发起报价");
		transporter.addData("data", offerPrice);
		return transporter;

	}

	@ApiOperation("删除报价")
	@GetMapping("/delete/{offerId}")
	public Transporter delete (@PathVariable("offerId") Integer offerId) throws CloneNotSupportedException {
		offerPriceService.delete(offerId);
		return successFactory.getDeliverPackage("成功删除报价");
	}

	@ApiOperation("查找投标")
	@GetMapping("/selectByBidId/{bidId}")
	public Transporter selectByBidId (@PathVariable("bidId") Integer bidId) throws CloneNotSupportedException {
		var result = offerPriceService.selectByBidId(bidId);
		var transporter = successFactory.getDeliverPackage(Integer.toString(result.size()));
		transporter.addData("data",result);
		return transporter;
	}
}
