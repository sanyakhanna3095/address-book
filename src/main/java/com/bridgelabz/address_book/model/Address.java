package com.bridgelabz.address_book.model;


import com.bridgelabz.address_book.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;
    private String name;
    private String phone;
    private String address;

    public Address(long userId, AddressDTO addressDTO) {
        this.userId=userId;
        this.name=addressDTO.getName();
        this.phone=addressDTO.getPhone();
        this.address=addressDTO.getAddress();
    }
    public Address(){}
    public Address(long userId, String name, String phone, String address){
        this.userId=userId;
        this.name=name;
        this.phone=phone;
        this.address=address;
    }


}
