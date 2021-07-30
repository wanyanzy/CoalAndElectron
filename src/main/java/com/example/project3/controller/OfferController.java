package com.example.project3.controller;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.comons.transporter.FailFactory;
import com.example.project3.comons.transporter.SuccessFactory;
import com.example.project3.comons.transporter.Transporter;
import com.example.project3.pojo.OfferPrice;
import com.example.project3.service.OfferPriceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/offer")
public class OfferController {
    private SuccessFactory successFactory;
    private FailFactory failFactory;
    private OfferPriceService offerPriceService;

    @Autowired
    public void setSuccessFactory(SuccessFactory successFactory) {
        this.successFactory = successFactory;
    }

    @Autowired
    public void setFailFactory(FailFactory failFactory) {
        this.failFactory = failFactory;
    }

    @Autowired
    public void setOfferPriceService(OfferPriceService offerPriceService) {
        this.offerPriceService = offerPriceService;
    }
    @ApiOperation("发起报价")
    @GetMapping("/create/{price}/{amount}/{userId}/{bidId}/{message}")
    public Transporter create(@PathVariable("price") String priceSting,
                              @PathVariable("amount") Integer amount,
                              @PathVariable("userId") Integer userId,
                              @PathVariable("bidId") Integer bidId,
                              @PathVariable("message") String message) throws ProjectException{
        var offerPrice = new OfferPrice();
        var price = new BigDecimal(priceSting);
        offerPrice.setPrice(price)
                .setAmount(amount)
                .setUserId(userId)
                .setBidId(bidId)
                .setMessage(message);
        try {
            var transporter = successFactory.getDeliverPackage("成功发起报价");
            transporter.addData("data" ,offerPrice);
            return transporter;
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
        }
        return null;
    }
    @ApiOperation("删除报价")
    @GetMapping("/delete/{offerId}")
    public Transporter delete(@PathVariable("offerId") Integer offerId){
        offerPriceService.delete(offerId);
        try {
            var transporter = successFactory.getDeliverPackage("成功删除报价");
            return transporter;
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
        }
        return null;
    }
}
