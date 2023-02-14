package com.store.Model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Products {

    public Products(Products product)   {
        this.title = product.getTitle();
        this.description = product.getDescription();
        this.count = product.count;
        this.price = product.getPrice();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(Views.Preview.class)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @JsonView(Views.Preview.class)
    private int count;

    @Column
    @JsonView(Views.Preview.class)
    private int discount;

    @Column
    @JsonView(Views.Preview.class)
    private int priceWithDiscount;

    @JsonView(Views.Preview.class)
    @Column(nullable = false)
    private double price;

    @ManyToOne()
    @JoinColumn(name = "id_category")
    private Categories category;

    @OneToMany()
    private List<Reviews> review;
}
