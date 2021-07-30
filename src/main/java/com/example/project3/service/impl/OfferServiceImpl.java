package com.example.project3.service.impl;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.manager.OfferPriceManager;
import com.example.project3.pojo.OfferPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project3.service.OfferPriceService;

import java.util.List;
@Service
public class OfferServiceImpl implements OfferPriceService {
    OfferPriceManager offerPriceManager;

    @Autowired
    public void setOfferPriceManager(OfferPriceManager offerPriceManager) {
        this.offerPriceManager = offerPriceManager;
    }

    @Override
    public void insert(OfferPrice target) throws ProjectException {
        offerPriceManager.insert(target);
    }

    @Override
    public void drop(Integer id) throws ProjectException {
        offerPriceManager.drop(id);
    }

    @Override
    public void delete(Integer id) throws ProjectException {
        offerPriceManager.delete(id);
    }

    @Override
    public void update(OfferPrice target) throws ProjectException {
        offerPriceManager.update(target);
    }

    @Override
    public List<OfferPrice> selectAll() throws ProjectException {
        return offerPriceManager.selectAll();
    }

    @Override
    public OfferPrice select(Integer id) throws ProjectException {
        return offerPriceManager.select(id);
    }

    @Override
    public List<OfferPrice> selectByBidId(Integer bidId) throws ProjectException {
        return offerPriceManager.selectByBidId(bidId);
    }

    @Override
    public List<OfferPrice> selectByUserId(Integer userId) throws ProjectException {
        return offerPriceManager.selectByUserId(userId);
    }
}
