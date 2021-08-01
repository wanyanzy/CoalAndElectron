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
		return this.orderDao.save(target);
	}

	@Override
	public Integer drop (Integer id) {
		return this.orderDao.drop(id);
	}

	@Override
	public Integer delete (Integer id) {
		return this.orderDao.delete(id);
	}

	@Override
	public Integer update (Order target) {
		return this.orderDao.update(target);
	}

	@Override
	public List<Order> selectAll () {
		return this.orderDao.selectAll();
	}

	@Override
	public Order select (Integer id) {
		return this.orderDao.select(id);
	}
}
