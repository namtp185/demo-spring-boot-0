package com.example.rest.request;

import com.example.entity.User;
import lombok.*;

import java.time.Instant;
import java.util.Date;

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
