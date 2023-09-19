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
    private Long price;
    private Long discount;
    private String img;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date createUpdate;
    private Integer stockquantity;
    private Integer buyquantity;
    private String description;
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "idCategories", referencedColumnName = "id")
    private Categories categories;
    @OneToMany(mappedBy = "product")
    private List<OrderDetails> orderDetails;
    @OneToMany(mappedBy = "product")
    private List<Gallery> gallery;

}
