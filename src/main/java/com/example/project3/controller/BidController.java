package com.example.project3.controller;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.comons.transporter.FailFactory;
import com.example.project3.comons.transporter.SuccessFactory;
import com.example.project3.comons.transporter.Transporter;
import com.example.project3.pojo.Bid;
import com.example.project3.service.BidService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/bid")
public class BidController {
	private SuccessFactory successFactory;
	private BidService bidService;


	@Autowired
	public void setBidService (BidService bidService) {
		this.bidService = bidService;
	}

	@Autowired
	public void setSuccessFactory (SuccessFactory successFactory) {
		this.successFactory = successFactory;
	}

	@ApiOperation("招标")
	@GetMapping("/create/{firstPartIsSeller}/{corporateId}/{amount}/{price}/{coal}/{transportWay}/{transportFee}/{address}")
	@Transactional(rollbackFor = Exception.class)
	public Transporter create (@PathVariable("firstPartIsSeller") Integer firstPartIsSeller,
	                           @PathVariable("corporateId") Integer corporateId,
	                           @PathVariable("amount") Integer amount,
	                           @PathVariable("price") String priceString,
	                           @PathVariable("coal") String coal,
	                           @PathVariable("transportWay") String transportWay,
	                           @PathVariable("transportFee") String transportFeeString,
	                           @PathVariable("address") String address) throws ProjectException {
		var bid = new Bid();
		var price = new BigDecimal(priceString);
		var transportFee = new BigDecimal(transportFeeString);
		byte enable = 0;
		bid.setFirstPartIsSeller(firstPartIsSeller)
				.setCorporateId(corporateId)
				.setAmount(amount)
				.setPrice(price)
				.setCoal(coal)
				.setTransportWay(transportWay)
				.setTransportFee(transportFee)
				.setAddress(address)
				.setEnable(enable);
		bidService.insert(bid);
		try {
			var transporter = successFactory.getDeliverPackage("");
			transporter.addData("data", bid);
			return transporter;
		} catch (CloneNotSupportedException cloneNotSupportedException) {
			cloneNotSupportedException.printStackTrace();
		}
		return null;
	}

	@ApiOperation("招标信息完善或更新")
	@GetMapping("/coalinfo/{bidId}/{qnetar}/{mt}/{aar}/{varHigh}/{varLow}/{star}/{st}/{hgi}/{grain}/{fc}/{g}/{y}/{sodiumBasicOxide}")
	@Transactional(rollbackFor = Exception.class)
	public Transporter coalInfo (@PathVariable("bidId") Integer id,
	                             @PathVariable("qnetar") double qnetar,
	                             @PathVariable("mt") double mt,
	                             @PathVariable("aar") double aar,
	                             @PathVariable("varHigh") double varHigh,
	                             @PathVariable("varLow") double varLow,
	                             @PathVariable("star") double star,
	                             @PathVariable("st") double st,
	                             @PathVariable("hgi") double hgi,
	                             @PathVariable("grain") double grain,
	                             @PathVariable("fc") double fc,
	                             @PathVariable("g") double g,
	                             @PathVariable("y") double y,
	                             @PathVariable("sodiumBasicOxide") double sodiumBasicOxide) throws ProjectException {
		var bid = bidService.select(id);
		bid.setQnetar(qnetar)
				.setMt(mt)
				.setAar(aar)
				.setVarHigh(varHigh)
				.setVarLow(varLow)
				.setStar(star)
				.setSt(st)
				.setHgi(hgi)
				.setGrain(grain)
				.setFc(fc)
				.setG(g)
				.setY(y)
				.setSodiumBasicOxide(sodiumBasicOxide);
		try {
			var transporter = successFactory.getDeliverPackage("");
			transporter.addData("data", bid);
			return transporter;
		} catch (CloneNotSupportedException cloneNotSupportedException) {
			cloneNotSupportedException.printStackTrace();
		}
		return null;
	}

	@ApiOperation("查找所有卖方招标")
	@GetMapping("selectForSell")
	public Transporter selectForSell ()throws CloneNotSupportedException {
		var result = bidService.selectForSell();
		var transporter = successFactory.getDeliverPackage(Integer.toString(result.size()));
		transporter.addData("data", result);
		return transporter;
	}

	@ApiOperation("查找买方招标")
	@GetMapping("selectForBuy")
	public Transporter selectForBuy () {
		var result = bidService.selectForBuy();
		try {
			var transporter = successFactory.getDeliverPackage("");
			transporter.addData("data", result);
			return transporter;
		} catch (CloneNotSupportedException cloneNotSupportedException) {
			cloneNotSupportedException.printStackTrace();
		}
		return null;
	}

	@ApiOperation("查找指定法人的所有招标")
	@GetMapping("selectByCorporateId/{corporateId}")
	public Transporter selectByCorporateID (@PathVariable("corporateId") Integer corporateId) {
		var result = bidService.selectByCorporateId(corporateId);
		try {
			var transporter = successFactory.getDeliverPackage("");
			transporter.addData("data", result);
			return transporter;
		} catch (CloneNotSupportedException cloneNotSupportedException) {
			cloneNotSupportedException.printStackTrace();
		}
		return null;
	}

	@ApiOperation("删除招标")
	@GetMapping("delete/{corporateId}")
	@Transactional(rollbackFor = Exception.class)
	public Transporter delete (@PathVariable("corporateId") Integer corporteId) {
		try {
			bidService.delete(corporteId);
			return successFactory.getDeliverPackage("成功删除");
		} catch (CloneNotSupportedException cloneNotSupportedException) {
			cloneNotSupportedException.printStackTrace();
		}
		return null;
	}


}


