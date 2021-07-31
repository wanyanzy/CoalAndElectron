package com.example.project3.manager;

import com.example.project3.pojo.Bid;

import java.util.List;

public interface BidManager {
	Integer insert (Bid target);

	Integer drop (Integer id);

	Integer delete (Integer id);

	Integer update (Bid target);

	List<Bid> selectAll ();

	Bid select (Integer id);

	List<Bid> selectByCorporateId (Integer corporateId);

	List<Bid> selectForSell ();

	List<Bid> selectForBuy ();
}
