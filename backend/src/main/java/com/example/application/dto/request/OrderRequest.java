package com.example.application.dto.request;

import java.time.Instant;

import javax.validation.constraints.Min;

import com.example.infrastructure.entity.UserEntity;

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

    // @ValidInstant
    private Instant receiveTime;

    // @Valid
    private UserEntity customer;
}
