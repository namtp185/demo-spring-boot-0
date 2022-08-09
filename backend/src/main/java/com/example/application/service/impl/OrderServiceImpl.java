package com.example.application.service.impl;

import java.util.List;

import com.example.application.dto.request.OrderRequest;
import com.example.application.mapper.OrderEntityMapper;
import com.example.application.service.OrderService;
import com.example.domain.Order;
import com.example.infrastructure.entity.OrderEntity;
import com.example.infrastructure.repository.OrderRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    
    OrderEntityMapper orderEntityMapper;
    OrderRepository orderRepository;

    @Override
    public Order addOrder(OrderRequest orderRequest) {
        Order order = new Order(orderRequest);
        OrderEntity orderEntity = orderEntityMapper.toEntity(order);
        orderRepository.save(orderEntity);
        return order;
    }
    @Override
    public List<Order> getListOrder() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Order getOrderByID(String id) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void removeOrder(String id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Order updateOrder(OrderRequest orderRequest, String orderID) {
        // TODO Auto-generated method stub
        return null;
    }

}
