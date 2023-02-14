package com.store.Model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories_of_products")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView()
    private Long id;

    @Column
    @JsonView(Views.Preview.class)
    private String title;

    @Column
    private String description;

    @OneToMany()
    private List<Products> products;

    @JsonView(Views.Preview.class)
    @ManyToMany()
    private List<Options> options;
}
