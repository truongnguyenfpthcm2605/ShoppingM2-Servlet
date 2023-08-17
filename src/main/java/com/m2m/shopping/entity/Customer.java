package com.m2m.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    String email;
    @Column(name ="password")
    String password;
    @Column(name="fullname")
    String fullname;
    @Column(name="address")
    String address;
    @Column(name = "phoneNumbers")
    Integer phoneNumbers;
    @Column(name ="img")
    String image;
    @Column(name ="gender")
    Boolean gender = false;
    @Column(name ="isActive")
    Boolean isActive = true;
    @Column(name ="role")
    Boolean role = false;

    public Customer() {
    }

    public Customer(String email, String password, String fullname, String address, Integer phoneNumbers, String image, Boolean gender, Boolean isActive, Boolean role) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.image = image;
        this.gender = gender;
        this.isActive = isActive;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Integer phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }
}
