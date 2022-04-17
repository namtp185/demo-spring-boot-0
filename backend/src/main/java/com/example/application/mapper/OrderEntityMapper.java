package com.example.application.mapper;

import com.example.domain.Order;
import com.example.infrastructure.entity.OrderEntity;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OrderEntityMapper extends EntityMapper<Order, OrderEntity> {
    
}
