package com.example.infrastructure.repository;

import com.example.infrastructure.entity.OrderEntity;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    
}
