package com.example.project3.dao;


import com.example.project3.pojo.Bid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BidDao {
    Integer save (@Param("bid") Bid target);

    Integer drop (@Param("id") Integer id);

    Integer delete(@Param("id") Integer id);

    Integer update (@Param("bid") Bid target);

    Bid select(@Param("id") Integer id);

    List<Bid> selectAll ();

    List<Bid> selectByCorporationId(@Param("corporationId") Integer corporationId);

    List<Bid> selectForSell();

    List<Bid> selectForBuy();
}
