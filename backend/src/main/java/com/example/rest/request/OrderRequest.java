package com.example.rest.request;

import java.time.Instant;

import com.example.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequest {
    private String type;
    private String color;
    private String store;
    private int value;
    private int price;
    private Instant receiveTime;
    private User customer;
}
