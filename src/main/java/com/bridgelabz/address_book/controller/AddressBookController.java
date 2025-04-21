package com.bridgelabz.address_book.controller;

import com.bridgelabz.address_book.dto.AddressDTO;
import com.bridgelabz.address_book.dto.ResponseDTO;
import com.bridgelabz.address_book.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @RequestMapping(value = {"", "/","/get"})
    public ResponseEntity<ResponseDTO> getAddressData(){
        Address address=new Address(1, new AddressDTO());
        ResponseDTO responseDTO= new ResponseDTO("Get call success", address);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<ResponseDTO> getAddressDataById(@PathVariable("userId") long userId){
        Address address=new Address(1, new AddressDTO());
        ResponseDTO responseDTO=new ResponseDTO("Get by id call successful for id: ",userId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addAddressData(@RequestBody AddressDTO addressDTO){
        Address address=new Address(1, new AddressDTO());
        ResponseDTO responseDTO=new ResponseDTO("Created address data for: ", addressDTO +"Successfully!");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<ResponseDTO> updateAddressData(@RequestBody AddressDTO addressDTO){
        Address address=new Address(1, new AddressDTO());
        ResponseDTO responseDTO=new ResponseDTO("Updated address data for id: ", addressDTO);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseDTO> deleteAddressData(@PathVariable("userId") long userId){
        ResponseDTO responseDTO=new ResponseDTO("Delete by id call successful for id: ",userId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
