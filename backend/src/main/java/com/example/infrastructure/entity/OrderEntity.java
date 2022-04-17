package com.example.infrastructure.entity;

import java.time.Instant;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;
    private String color;
    private String store;

    private int value;

    private int price;
    
    private Instant receiveTime;

    private String userName;

    // @Valid
    @Embedded
    @AttributeOverrides({
        @AttributeOverride( name = "lat", column = @Column(name = "address_lat")),
        @AttributeOverride( name = "lon", column = @Column(name = "address_lon")),
    })
    private Address address;
}
