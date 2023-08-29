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
@Table(name = "Account")
public class Account {
    @Id
    private String email;
    private String password;
    private String fullname;
    private String address;
    private String phoneNumbers;
    @Temporal(TemporalType.DATE)
    @Column(name = "createDate")
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "createUpdate")
    private Date createUpdate;
    private String img;
    private Boolean gender = false;
    private String token;
    private Boolean isActive = true;
    @OneToMany(mappedBy = "account")
    private List<Order> order ;

}
