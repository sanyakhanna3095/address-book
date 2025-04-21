package com.bridgelabz.address_book.model;


import com.bridgelabz.address_book.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "book_service")
public @Data class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "userId")
    private long userId;

    @Column(name = "name")
    private String name;
    private String phone;
    private String address;
    private LocalDate startDate;
    private LocalDate endDate;

    public Address(long userId, AddressDTO addressDTO) {
        this.userId=userId;
        this.name=addressDTO.getName();
        this.phone=addressDTO.getPhone();
        this.address=addressDTO.getAddress();
        this.startDate=addressDTO.getStartDate();
        this.endDate=addressDTO.getEndDate();
    }
    public Address(){}
    public Address(long userId, String name, String phone, String address, LocalDate startDate, LocalDate endDate){
        this.userId=userId;
        this.name=name;
        this.phone=phone;
        this.address=address;
        this.startDate=startDate;
        this.endDate=endDate;
    }


    public void updateAddressData(AddressDTO addressDTO) {
        this.name=addressDTO.getName();
        this.phone=addressDTO.getPhone();
        this.address=addressDTO.getAddress();
        this.startDate=addressDTO.getStartDate();
        this.endDate=addressDTO.getEndDate();
    }
}
