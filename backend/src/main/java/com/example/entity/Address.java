package com.example.entity;

import com.example.rest.request.validator.ValidLatitude;
import com.example.rest.request.validator.ValidLongtitude;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @ValidLatitude
    private double lat;

    @ValidLongtitude
    private double lon;
}
