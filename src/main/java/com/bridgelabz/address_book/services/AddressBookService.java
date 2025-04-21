package com.bridgelabz.address_book.services;

import com.bridgelabz.address_book.dto.AddressDTO;
import com.bridgelabz.address_book.exception.AddressBookException;
import com.bridgelabz.address_book.model.Address;
import com.bridgelabz.address_book.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;
    private List<Address> addressDataList=new ArrayList<>();

    public List<Address> getAddressData() {
        return addressBookRepository.findAll();
    }


    public Address getAddressDataById(long userId) {
        return addressBookRepository
                .findById(userId)
                .orElseThrow(()-> new AddressBookException("User with id: "+userId+" does not exist !"));
    }


    public Address addAddressData(AddressDTO addressDTO) {
        Address addressData=null;
        addressData=new Address(addressDataList.size()+1,addressDTO);
        log.debug("Address Data: "+addressData.toString());
        addressDataList.add(addressData);
        return addressBookRepository.save(addressData);
    }


    public Address updateAddressData(long userId, AddressDTO addressDTO) {
        Address addressData=this.getAddressDataById(userId);
//        addressData.setName(addressDTO.getName());
//        addressData.setPhone(addressDTO.getPhone());
//        addressData.setAddress(addressDTO.getAddress());
//        addressDataList.set((int) userId-1, addressData);
        addressData.updateAddressData(addressDTO);
        return addressBookRepository.save(addressData);
    }


    public void deleteAddressData(long userId) {
        Address addressData = getAddressDataById(userId);
//        addressDataList.remove(addressData);
        addressBookRepository.delete(addressData);
    }
}
