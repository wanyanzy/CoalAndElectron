package com.example.project3.manager;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.pojo.OfferPrice;

import java.util.List;

public interface OfferPriceManager {
    Integer insert (OfferPrice target);

    Integer drop (Integer id);

    Integer delete (Integer id);

    Integer update (OfferPrice target);

    List<OfferPrice> selectAll();

    OfferPrice select (Integer id);

    List<OfferPrice> selectByBidId(Integer bidId);

    List<OfferPrice> selectByUserId(Integer userId);

}
