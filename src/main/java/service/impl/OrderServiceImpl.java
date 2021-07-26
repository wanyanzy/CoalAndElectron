package service.impl;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.manager.OrderManager;
import com.example.project3.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    OrderManager orderManager;

    @Autowired
    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @Override
    public void insert(Order order) throws ProjectException {
        orderManager.insert(order);
    }

    @Override
    public void delete(Integer orderId) {
        orderManager.delete(orderId);
    }

    @Override
    public void drop(Integer orderId) {
        orderManager.drop(orderId);
    }

    @Override
    public Order select(Integer orderId) {
        return orderManager.select(orderId);
    }

    @Override
    public List<Order> selectAll() {
        return orderManager.selectAll();
    }

    @Override
    public void update(Order order) {
        orderManager.update(order);
    }
}
