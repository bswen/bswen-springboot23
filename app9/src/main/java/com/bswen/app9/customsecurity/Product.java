package com.bswen.app9.customsecurity;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;

    @Enumerated(EnumType.STRING)
    private ProductCurrency currency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(ProductCurrency currency) {
        this.currency = currency;
    }
}
