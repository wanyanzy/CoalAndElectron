package com.example.project3.service;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.pojo.OfferPrice;

import java.util.List;

public interface OfferPriceService {
    void insert (OfferPrice target) throws ProjectException;

    void drop (Integer id) throws ProjectException;

    void delete (Integer id) throws ProjectException;

    void update (OfferPrice target) throws ProjectException;

    List<OfferPrice> selectAll() throws ProjectException;

    OfferPrice select (Integer id) throws ProjectException;

    List<OfferPrice> selectByBidId(Integer bidId) throws ProjectException;

    List<OfferPrice> selectByUserId(Integer userId) throws ProjectException ;


}
