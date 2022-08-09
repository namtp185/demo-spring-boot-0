package com.example.rest;

import javax.validation.Valid;

import com.example.application.dto.request.OrderRequest;
import com.example.application.service.OrderService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value = "/v2/orders") //all request will start with /v2/orders
@AllArgsConstructor
public class OrderControllerV2 {

    OrderService orderService;

    @PostMapping()
    public void createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        log.info("post with orderRequest: {}", orderRequest);
        // OrderCommand cmd = orderService.orderRequestTorderCommand(orderRequest);
        orderService.addOrder(orderRequest);
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
    public void editOrder(@PathVariable(name = "id") int id, @Valid @RequestBody OrderRequest orderRequest) {
        log.info("put with orderRequest: {}", orderRequest);
    }

    @DeleteMapping(value="/{id}")
    public void deleteOrder(@PathVariable(name = "id") int id) {
        log.info("delete with orderId: {}", id);
    }
}

