package com.example.project3.controller;


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
	                           @PathVariable("address") String address) throws CloneNotSupportedException{
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
		var transporter = successFactory.getDeliverPackage("");
		transporter.addData("data", bid);
		return transporter;

	}

	@ApiOperation("招标信息完善")
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
	                             @PathVariable("sodiumBasicOxide") double sodiumBasicOxide) throws CloneNotSupportedException {
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
		bidService.update(bid);
		var transporter = successFactory.getDeliverPackage("");
		transporter.addData("data", bid);
		return transporter;

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
	public Transporter selectForBuy () throws CloneNotSupportedException{
		var result = bidService.selectForBuy();
		var transporter = successFactory.getDeliverPackage(Integer.toString(result.size()));
		transporter.addData("data", result);
		return transporter;

	}

	@ApiOperation("查找所有招标")
	@GetMapping("selectAll")
	public Transporter selectAll () throws CloneNotSupportedException{
		var result = bidService.selectAll();
		var transporter = successFactory.getDeliverPackage(Integer.toString(result.size()));
		transporter.addData("data",result);
		return transporter;
	}

	@ApiOperation("查找指定id招标")
	@GetMapping("selectById/{id}")
	public Transporter selectById (@PathVariable("id") Integer id) throws CloneNotSupportedException{
		var result = bidService.select(id);
		var transporter = successFactory.getDeliverPackage("查询成功");
		transporter.addData("data",result);
		return transporter;
	}

	@ApiOperation("查找指定法人的所有招标")
	@GetMapping("selectByCorporateId/{corporateId}")
	public Transporter selectByCorporateID (@PathVariable("corporateId") Integer corporateId) throws CloneNotSupportedException{
		var result = bidService.selectByCorporateId(corporateId);
		var transporter = successFactory.getDeliverPackage(Integer.toString(result.size()));
		transporter.addData("data", result);
		return transporter;
	}

	@ApiOperation("删除招标")
	@GetMapping("delete/{id}")
	@Transactional(rollbackFor = Exception.class)
	public Transporter delete (@PathVariable("id") Integer id) throws CloneNotSupportedException{
		bidService.delete(id);
		return successFactory.getDeliverPackage("成功删除");
	}

	@ApiOperation("移除招标")
	@GetMapping("drop/{id}")
	@Transactional(rollbackFor = Exception.class)
	public Transporter drop (@PathVariable("id") Integer id) throws CloneNotSupportedException{
		bidService.drop(id);
		return successFactory.getDeliverPackage("成功删除");
	}

}


