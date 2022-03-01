package com.example.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private String type;
    private String color;
    private String store;
    private int value;
    private int price;
    private Date receiveTime;

    @JsonProperty("customer")
    private UserDTO userDTO;

    private String userName;
    private String lat;
    private String lon;
}
