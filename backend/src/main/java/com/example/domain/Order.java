package com.example.domain;

import java.time.Instant;

import com.example.application.dto.request.OrderRequest;
import com.example.infrastructure.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private String type;
    private String color;
    private String store;

    private int value;

    private int price;
    
    private Instant receiveTime;

    private UserEntity user;

    public Order(OrderRequest orderRequest) {
        this.type = orderRequest.getType();
        this.color = orderRequest.getColor();
        this.store = orderRequest.getStore();
        this.value = orderRequest.getValue();
        this.price = orderRequest.getPrice();
        this.receiveTime = Instant.from(orderRequest.getReceiveTime());
    }
}
