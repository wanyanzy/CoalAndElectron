package com.example.project3.service;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.pojo.Order;

import java.util.List;


public interface OrderService {
	void insert (Order order) throws ProjectException;

	void delete (Integer orderId);

	void drop (Integer orderId);

	Order select (Integer orderId);

	List<Order> selectAll ();

	void update (Order order);


}
