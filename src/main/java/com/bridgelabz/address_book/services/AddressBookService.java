package com.bridgelabz.address_book.services;

import com.bridgelabz.address_book.dto.AddressDTO;
import com.bridgelabz.address_book.model.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    public List<Address> getAddressData() {
        List<Address> addressDataList=new ArrayList<>();
        addressDataList.add(new Address(1, new AddressDTO("Sanya", "234567", "Ludhiana, Punjab")));
        return addressDataList;
    }


    public Address getAddressDataById(long userId) {
        Address addressData=null;
        addressData=new Address(1, new AddressDTO("Sanya", "234567", "Ludhiana, Punjab"));
        return addressData;
    }


    public Address addAddressData(AddressDTO addressDTO) {
        Address addressData=null;
        addressData=new Address(1,addressDTO);
        return addressData;
    }


    public Address updateAddressData(AddressDTO addressDTO) {
        Address addressData=null;
        addressData=new Address(1,new AddressDTO());
        return addressData;
    }


    public void deleteAddressData(long userId) {

    }
}
