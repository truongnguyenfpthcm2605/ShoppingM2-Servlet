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
    @Column( name = "id")
    private Integer id;
    private String title;
    private Double price;
    private Double discount;
    private Integer quantity;
    private String img;
    @Temporal(TemporalType.DATE)
    @Column( name = "createDate")
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column( name = "createUpdate")
    private Date createUpdate;
    private Integer stockquantity;
    private Integer buyquantity;
    private String description;
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "idCategories")
    private Categories categories;
    @OneToMany(mappedBy = "product")
    private List<OrderDetails> orderDetails;

}
