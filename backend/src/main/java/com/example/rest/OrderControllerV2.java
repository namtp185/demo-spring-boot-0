package com.example.rest;

import com.example.rest.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/v2/orders") //all request will start with /v2/orders
public class OrderControllerV2 {

    @PostMapping()
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        log.info("orderRequest: {}", orderRequest);
    }

    @GetMapping(value = "/{id}")
    public void getOrderDetail(@PathVariable(name = "id") int id) {
        log.info("orderId: {}", id);
    }
}

