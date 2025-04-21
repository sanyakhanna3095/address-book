package com.bridgelabz.address_book.services;

import com.bridgelabz.address_book.dto.AddressDTO;
import com.bridgelabz.address_book.exception.AddressBookException;
import com.bridgelabz.address_book.model.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    private List<Address> addressDataList=new ArrayList<>();

    public List<Address> getAddressData() {
        return addressDataList;
    }


    public Address getAddressDataById(long userId) {
        return addressDataList.stream()
                .filter(addressData -> addressData.getUserId()== userId)
                .findFirst()
                .orElseThrow(()-> new AddressBookException("User not found"));
    }


    public Address addAddressData(AddressDTO addressDTO) {
        Address addressData=null;
        addressData=new Address(addressDataList.size()+1,addressDTO);
        addressDataList.add(addressData);
        return addressData;
    }


    public Address updateAddressData(long userId, AddressDTO addressDTO) {
        Address addressData=this.getAddressDataById(userId);
        addressData.setName(addressDTO.getName());
        addressData.setPhone(addressDTO.getPhone());
        addressData.setAddress(addressDTO.getAddress());
        addressDataList.set((int) userId-1, addressData);
        return addressData;
    }


    public void deleteAddressData(long userId) {
        Address addressData = getAddressDataById(userId);
        addressDataList.remove(addressData);
    }
}
