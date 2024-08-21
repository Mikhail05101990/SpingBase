package com.example.techtask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import java.util.List;

@Service
public class OrderService implements com.example.techtask.service.OrderService{
    
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public Order findOrder(){
        return orderRepository.findOrder();
    }

    public List<Order> findOrders(){
        return orderRepository.findOrders();
    }
}
