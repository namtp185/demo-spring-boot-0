package com.example.rest;

import java.io.IOException;

import com.example.dto.OrderDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

	private ObjectMapper objectMapper;

	public OrderController(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@GetMapping("/orders")
	public String getOrder(@RequestParam(name = "keyword") String keyword) {
		return "looking for orders with keyword: " + keyword;
	}

	@PostMapping("/orders")
	public String createOrder(@RequestBody String orderJsonString) throws IOException {
		OrderDTO order = objectMapper.readerFor(OrderDTO.class).readValue(orderJsonString);

		return String.format("creating order with info type: %s, color: %s, store: %s, value: %s, price: %s, receivedTime: %s, customerName: %s, latitude: %f, longtitude: %f",
			order.getType(),
			order.getColor(),
			order.getStore(),
			order.getValue(),
			order.getPrice(),
			order.getReceiveTime(),
			order.getCustomerName(),
			order.getLat(),
			order.getLon()
		);
	}

	@GetMapping("/orders/{id}")
	@ResponseBody
	public String getOrderDetail(@PathVariable String id) {
		return "looking for order with id: " + id;
	}

	@PutMapping(value="/orders/{id}")
	public String editOrder(@PathVariable String id, @RequestBody String orderJsonString) throws IOException {
		OrderDTO order = objectMapper.readerFor(OrderDTO.class).readValue(orderJsonString);
		return String.format("editing order id %s with info type: %s, color: %s, store: %s, value: %s, price: %s, receivedTime: %s, customerName: %s, latitude: %f, longtitude: %f", 
		id,
		order.getType(),
		order.getColor(),
		order.getStore(),
		order.getValue(),
		order.getPrice(),
		order.getReceiveTime(),
		order.getCustomerName(),
		order.getLat(),
		order.getLon()
	);}

	@DeleteMapping(value="/orders/{id}")
	public String deleteOrder(@PathVariable String id) {
		return "deleting for order id:" +  id;
	}


}
