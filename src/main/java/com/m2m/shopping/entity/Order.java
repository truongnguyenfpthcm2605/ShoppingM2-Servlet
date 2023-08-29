package com.m2m.shopping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    @Temporal(TemporalType.DATE)
    @Column(name = "createDate")
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "createUpdate")
    private Date createUpdate;
    private String address;
    private String phoneNumbers;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idAccount")
    private Account account;
    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetail;
}
