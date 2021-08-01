package com.example.project3.manager.impl;

import com.example.project3.dao.OfferPriceDao;
import com.example.project3.manager.OfferPriceManager;
import com.example.project3.pojo.OfferPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferPriceManagerImpl implements OfferPriceManager {
	OfferPriceDao offerPriceDao;

	@Autowired
	public void setOfferPriceDao (OfferPriceDao offerPriceDao) {
		this.offerPriceDao = offerPriceDao;
	}


	@Override
	public Integer insert (OfferPrice target) {
		return this.offerPriceDao.save(target);
	}

	@Override
	public Integer drop (Integer id) {
		return this.offerPriceDao.drop(id);
	}

	@Override
	public Integer delete (Integer id) {
		return this.offerPriceDao.delete(id);
	}

	@Override
	public Integer update (OfferPrice target) {
		return this.offerPriceDao.update(target);
	}

	@Override
	public List<OfferPrice> selectAll () {
		return this.offerPriceDao.selectAll();
	}

	@Override
	public OfferPrice select (Integer id) {
		return this.offerPriceDao.select(id);
	}

	@Override
	public List<OfferPrice> selectByBidId (Integer bidId) {
		return this.offerPriceDao.selectByBidId(bidId);
	}

	@Override
	public List<OfferPrice> selectByUserId (Integer userId) {
		return this.selectByUserId(userId);
	}
}
