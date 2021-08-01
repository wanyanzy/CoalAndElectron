package com.example.project3.service;

import com.example.project3.pojo.Bid;

import java.util.List;

public interface BidService {
	void insert (Bid target);

	void drop (Integer id);

	void delete (Integer id);

	void update (Bid target);

	List<Bid> selectAll ();

	Bid select (Integer id);

	List<Bid> selectForSell ();

	List<Bid> selectForBuy ();

	List<Bid> selectByCorporateId (Integer corporateId);

}
