package com.example.project3.controller;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.comons.transporter.SuccessFactory;
import com.example.project3.comons.transporter.Transporter;
import com.example.project3.pojo.Order;
import com.example.project3.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderController {
	private SuccessFactory successFactory;
	private OrderService orderService;

	@Autowired
	public void setSuccessFactory (SuccessFactory successFactory) {
		this.successFactory = successFactory;
	}


	@Autowired

	public void setOrderService (OrderService orderService) {
		this.orderService = orderService;
	}

	@ApiOperation("创建交易")
	@GetMapping("/create/{price}/{amount}/{sellerId}/{buyerId}/{firstPartIsSeller}/{contractUrl}/{transportWay}/{transportFee}")
	@Transactional(rollbackFor = Exception.class)
	public Transporter create (@PathVariable("price") String priceString,
	                           @PathVariable("amount") Integer amount,
	                           @PathVariable("sellerId") Integer sellerId,
	                           @PathVariable("buyerId") Integer buyerId,
	                           @PathVariable("firstPartIsSeller") String firstPartIsSellerString,
	                           @PathVariable("contractUrl") String contractUrl,
	                           @PathVariable("transportWay") String transportWay,
	                           @PathVariable("transportFee") String transportFeeString) throws CloneNotSupportedException {
		var transportFee = new BigDecimal(transportFeeString);
		var price = new BigDecimal(priceString);
		var firstPartIsSeller = Byte.valueOf(firstPartIsSellerString);
		var order = new Order();
		byte enable = 0;
		order.setPrice(price)
				.setAmount(amount)
				.setSellerId(sellerId)
				.setBuyerId(buyerId)
				.setFirstPartIsSeller(firstPartIsSeller)
				.setContractUrl(contractUrl)
				.setTransportWay(transportWay)
				.setTransportFee(transportFee)
				.setEnable(enable);
		orderService.insert(order);
		var transporter = successFactory.getDeliverPackage("成功创建交易");
		transporter.addData("data", order);
		return transporter;
	}

	@ApiOperation("删除交易")
	@GetMapping("/delete/{orderId}")
	@Transactional(rollbackFor = Exception.class)
	public Transporter delete (@PathVariable("orderId") Integer orderId) throws CloneNotSupportedException{
		orderService.delete(orderId);
		return successFactory.getDeliverPackage("成功删除交易");

	}

	@ApiOperation("查找所有交易")
	@GetMapping("/select")
	public Transporter select () throws CloneNotSupportedException{
		var result = orderService.selectAll();
		var transporter = successFactory.getDeliverPackage(Integer.toString(result.size()));
		transporter.addData("data",result);
		return transporter;
	}
}
