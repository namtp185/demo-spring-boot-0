package com.example.rest;

import com.example.rest.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@Slf4j
@RestController
@RequestMapping(value = "/v2/orders") //all request will start with /v2/orders
public class OrderControllerV2 {

    @PostMapping()
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        log.info("post with orderRequest: {}", orderRequest);
    }

    @GetMapping(value = "/{id}")
    public void getOrderDetail(@PathVariable(name = "id") int id) {
        log.info("get with orderId: {}", id);
    }

    @GetMapping()
    public void searchOrder(@RequestParam(name = "keyword") String keyword) {
        log.info("get with order param: keyword: {}", keyword);
    }

    @PutMapping(value="/{id}")
    public void editOrder(@PathVariable(name = "id") int id, @RequestBody OrderRequest orderRequest) {
        log.info("put with orderRequest: {}", orderRequest);
    }

    @DeleteMapping(value="/{id}")
    public void deleteOrder(@PathVariable(name = "id") int id) {
        log.info("delete with orderId: {}", id);
    }
}

