package com.parrot.backendchallenge.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="external_client_name")
    private String externalClientName;
    @Column(name="total_price")
    private BigDecimal totalPrice;
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Product> products;
}