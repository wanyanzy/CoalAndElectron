package com.example.project3.manager.impl;

import com.example.project3.dao.OfferPriceDao;
import com.example.project3.manager.OfferPriceManager;
import com.example.project3.pojo.OfferPrice;

import java.util.List;

public class OfferPriceManagerImpl implements OfferPriceManager {
    OfferPriceDao offerPriceDao;

    @Override
    public Integer insert(OfferPrice target) {
        return this.offerPriceDao.save(target);
    }

    @Override
    public Integer drop(Integer id) {
        return this.offerPriceDao.drop(id);
    }

    @Override
    public Integer delete(Integer id) {
        return this.delete(id);
    }

    @Override
    public Integer update(OfferPrice target) {
        return this.offerPriceDao.update(target);
    }

    @Override
    public List<OfferPrice> selectAll() {
        return this.offerPriceDao.selectAll();
    }

    @Override
    public OfferPrice select(Integer id) {
        return this.offerPriceDao.select(id);
    }
}
