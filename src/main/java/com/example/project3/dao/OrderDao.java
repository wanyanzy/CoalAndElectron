package com.example.project3.dao;

import com.example.project3.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    Integer save (@Param("target") Order order);

    Integer drop (@Param("id") Integer id);

    Integer delete (@Param("id") Integer id);

    Integer update (@Param("target") Order order);

    Order select(@Param("id") Integer id);

    List<Order> selectAll();

}
