package com.example.dto;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private String type;
    private String color;
    private String store;
    private int value;
    private int price;
    private Date receiveTime;

    private String customerName;

    private double lat;
    private double lon;


    @SuppressWarnings("unchecked")
    @JsonProperty(value = "customer")
    private void unpackNested(Map<String, Object> customer) {
        this.customerName = (String) customer.get("name");
        Map<String, Object> address = (Map<String, Object>) customer.get("address");
        this.lat = (double) address.get("lat");
        this.lon = (double) address.get("lon");
    }
}
