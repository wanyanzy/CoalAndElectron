package com.example.project3.controller;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.comons.transporter.FailFactory;
import com.example.project3.comons.transporter.SuccessFactory;
import com.example.project3.comons.transporter.Transporter;
import com.example.project3.pojo.Order;
import com.example.project3.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

public class OrderController {
    private SuccessFactory successFactory;
    private FailFactory failFactory;
    private OrderService orderService;

    @Autowired
    public void setSuccessFactory(SuccessFactory successFactory) {
        this.successFactory = successFactory;
    }

    @Autowired
    public void setFailFactory(FailFactory failFactory) {
        this.failFactory = failFactory;
    }

    @Autowired

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @ApiOperation("创建交易")
    @GetMapping("/create/{price}/{amount}/{sellerId}/{buyerId}/{firstPartIsSeller}/{contractUrl}/{transportWay}/{transportFee}")
    public Transporter create(@PathVariable("price") String priceString,
                              @PathVariable("amount") Integer amount,
                              @PathVariable("sellerId") Integer sellerId,
                              @PathVariable("buyerId") Integer buyerId,
                              @PathVariable("firstPartIsSeller") String firstPartIsSellerString,
                              @PathVariable("contractUrl") String contractUrl,
                              @PathVariable("transportWay") String transportWay,
                              @PathVariable("transportFee") String transportFeeString) throws ProjectException{
        var transportFee = new BigDecimal(transportFeeString);
        var price = new BigDecimal(priceString);
        var firstPartIsSeller =  Byte.valueOf(firstPartIsSellerString);
        var order = new Order();
        order.setPrice(price)
                .setAmount(amount)
                .setSellerId(sellerId)
                .setBuyerId(buyerId)
                .setFirstPartIsSeller(firstPartIsSeller)
                .setContractUrl(contractUrl)
                .setTransportWay(transportWay)
                .setTransportFee(transportFee);
        try {
            var transporter = successFactory.getDeliverPackage("成功创建合同");
            transporter.addData("data" ,order);
            return transporter;
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
        }
        return null;
    }

}
