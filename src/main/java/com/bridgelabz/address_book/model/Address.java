package com.bridgelabz.address_book.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;
    private String name;
    private String phone;
    private String address;

    public long getId(){
        return userId;
    }

    public void setId(long userId){
        this.userId=userId;
    }

    public String getName(){
        return name;
    }

    public  void setName(String name){
        this.name=name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress(String address){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }
    public Address(){}
    public Address(long userId, String name, String phone, String address){
        this.userId=userId;
        this.name=name;
        this.phone=phone;
        this.address=address;
    }
}
