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
		return offerPriceDao.save(target);
	}

	@Override
	public Integer drop (Integer id) {
		return offerPriceDao.drop(id);
	}

	@Override
	public Integer delete (Integer id) {
		return offerPriceDao.delete(id);
	}

	@Override
	public Integer update (OfferPrice target) {
		return offerPriceDao.update(target);
	}

	@Override
	public List<OfferPrice> selectAll () {
		return offerPriceDao.selectAll();
	}

	@Override
	public OfferPrice select (Integer id) {
		return offerPriceDao.select(id);
	}

	@Override
	public List<OfferPrice> selectByBidId (Integer bidId) {
		return offerPriceDao.selectByBidId(bidId);
	}

	@Override
	public List<OfferPrice> selectByUserId (Integer userId) {
		return offerPriceDao.selectByUserId(userId);
	}
}
