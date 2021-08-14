package com.example.project3.manager.impl;

import com.example.project3.dao.OrderDao;
import com.example.project3.manager.OrderManager;
import com.example.project3.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManagerImpl implements OrderManager {
	OrderDao orderDao;

	@Autowired
	public void setOrderDao (OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Integer insert (Order target) {
		return orderDao.save(target);
	}

	@Override
	public Integer drop (Integer id) {
		return orderDao.drop(id);
	}

	@Override
	public Integer delete (Integer id) {
		return orderDao.delete(id);
	}

	@Override
	public Integer update (Order target) {
		return orderDao.update(target);
	}

	@Override
	public List<Order> selectAll () {
		return orderDao.selectAll();
	}

	@Override
	public Order select (Integer id) {
		return orderDao.select(id);
	}
}
