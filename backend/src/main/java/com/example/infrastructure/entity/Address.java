package com.example.infrastructure.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    // @ValidLatitude
    private double lat;

    // @ValidLongtitude
    private double lon;

    public String toString() {
        return String.valueOf(lat + ", " + lon);
    }
}
