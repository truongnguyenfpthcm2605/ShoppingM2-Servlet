package com.m2m.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    @JsonIgnore
    private String password;
    private String fullname;
    private String address;
    private String phoneNumbers;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDate")
    private Date createDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createUpdate")
    private Date createUpdate;
    private String img;
    private Boolean gender = false;
    private String token;
    private Boolean isActive = true;
    @OneToMany(mappedBy = "account")
    private List<Order> order ;

    @OneToMany(mappedBy = "account")
    private List<Authorities> authorities ;

    public Account(String email, String password, String fullname, Boolean gender) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
    }

    public Account(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }
}
