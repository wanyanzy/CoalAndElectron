package com.example.project3.manager;

import com.example.project3.pojo.Order;

import java.util.List;

public interface OrderManager {
	Integer insert (Order target);

	Integer drop (Integer id);

	Integer delete (Integer id);

	Integer update (Order target);

	List<Order> selectAll ();

	Order select (Integer id);
}
