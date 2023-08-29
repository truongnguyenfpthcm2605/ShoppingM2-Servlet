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
    private String email;
    @JsonIgnore
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role",
        joinColumns = @JoinColumn(name = "Userid"),inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Set<Roles> roleSet = new HashSet<>();

}
