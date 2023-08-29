package com.m2m.shopping.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Order order;
    private Double price;
}
