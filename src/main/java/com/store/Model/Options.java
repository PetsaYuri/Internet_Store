package com.store.Model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView()
    private Long id;

    @JsonView(Views.Preview.class)
    @Column(nullable = false)
    private String title, description;

    @JsonView(Views.Preview.class)
    @Column(nullable = false)
    private int price;

    @ManyToMany()
    @JoinColumn(name = "id_category")
    private List<Categories> categories;

}
