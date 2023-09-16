package com.m2m.shopping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Double price;
    private Double discount;
    private Long views;
    private String img;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date createUpdate;
    private Integer stockquantity;
    private Integer buyquanity;
    private String description;
    private Boolean isActive;
    private Integer ram;
    private Integer rom;
    private Integer pin;
    private Integer camera;
    private String chip;
    private Double screen;
    @ManyToOne
    @JoinColumn(name = "idCategories", referencedColumnName = "id")
    private Categories categories;
    @OneToMany(mappedBy = "product")
    private List<OrderDetails> orderDetails;
    @OneToMany(mappedBy = "product")
    private List<Gallery> gallery;


    @Override
    public String toString() {
        return "Product{}";
    }
}
