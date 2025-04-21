package com.bridgelabz.address_book.services;

import com.bridgelabz.address_book.dto.AddressDTO;
import com.bridgelabz.address_book.model.Address;

import java.util.List;

public interface IAddressBookService {
    List<Address> getAddressData();
    Address getAddressDataById(long userId);
    Address addAddressData(AddressDTO addressDTO);
    Address updateAddressData(AddressDTO addressDTO);
    void deleteAddressData(long userId);

}
