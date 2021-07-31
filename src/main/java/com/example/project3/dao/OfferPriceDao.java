package com.example.project3.dao;

import com.example.project3.pojo.OfferPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OfferPriceDao {
	Integer save (@Param("target") OfferPrice offerPrice);

	Integer drop (@Param("id") Integer id);

	Integer delete (@Param("id") Integer id);

	Integer update (@Param("offerPrice") OfferPrice offerPrice);

	OfferPrice select (@Param("id") Integer id);

	List<OfferPrice> selectAll ();

	List<OfferPrice> selectByBidId (@Param("bidId") Integer bidId);

	List<OfferPrice> selectByUserId (@Param("userId") Integer userId);

}
