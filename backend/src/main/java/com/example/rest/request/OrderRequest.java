package com.example.rest.request;

import java.time.Instant;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.example.entity.User;
import com.example.rest.request.validator.ValidInstant;

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

    @Min(value = 0, message = "value must be greater than zero")
    private int value;

    @Min(value = 0, message = "value must be greater than zero")
    private int price;

    @ValidInstant
    private Instant receiveTime;

    @Valid
    private User customer;
}
