package com.bridgelabz.address_book.controller;

import com.bridgelabz.address_book.dto.AddressDTO;
import com.bridgelabz.address_book.dto.ResponseDTO;
import com.bridgelabz.address_book.model.Address;
import com.bridgelabz.address_book.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    private IAddressBookService addressBookService;


    @RequestMapping(value = {"", "/","/get"})
    public ResponseEntity<ResponseDTO> getAddressData(){
        List<Address> addressList=null;
        addressList=addressBookService.getAddressData();
        ResponseDTO responseDTO= new ResponseDTO("Get call success", addressList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<ResponseDTO> getAddressDataById(@PathVariable("userId") long userId){
        Address addressData=null;
        addressData=addressBookService.getAddressDataById(userId);
        ResponseDTO responseDTO=new ResponseDTO("Get call successful" ,addressData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addAddressData(@RequestBody AddressDTO addressDTO){
        Address addressData=null;
        addressData=addressBookService.addAddressData(addressDTO);
        ResponseDTO responseDTO=new ResponseDTO("Created address data Successfully " , addressDTO);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/put/{userId}")
    public ResponseEntity<ResponseDTO> updateAddressData(@PathVariable("userId") long userId, @RequestBody AddressDTO addressDTO){
        Address addressData=null;
        addressData=addressBookService.updateAddressData(userId,addressDTO);
        ResponseDTO responseDTO=new ResponseDTO("Updated address data successfully!", addressData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseDTO> deleteAddressData(@PathVariable("userId") long userId){
        addressBookService.deleteAddressData(userId);
        ResponseDTO responseDTO=new ResponseDTO("Delete by id call successful", "Deleted id: "+userId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
