package com.example.application.service;

import java.util.List;

import com.example.application.dto.request.OrderRequest;
import com.example.domain.Order;

public interface OrderService {
    List<Order> getListOrder();

    Order getOrderByID(String id);

    Order addOrder(OrderRequest orderRequest);

    Order updateOrder(OrderRequest orderRequest, String orderID);

    void removeOrder(String id);
}
