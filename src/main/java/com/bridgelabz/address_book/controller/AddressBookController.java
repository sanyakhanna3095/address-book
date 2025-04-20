package com.bridgelabz.address_book.controller;

import com.bridgelabz.address_book.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @RequestMapping(value = {"", "/","/get"})
    public ResponseEntity<String> getAddressData(){
        return new ResponseEntity<String>("Get call success", HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<String> getAddressDataById(@PathVariable("userId") long userId){
        return new ResponseEntity<String>("Get by id call successful for id: "+userId, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> addAddressData(@RequestBody AddressDTO addressDTO){
        return new ResponseEntity<String>("Created address data for: "+ addressDTO, HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<String> updateAddressData(@RequestBody AddressDTO addressDTO){
        return new ResponseEntity<String>("Updated address data for id: "+ addressDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteAddressData(@PathVariable("userId") long userId){
        return new ResponseEntity<String>("Delete by id call successful for id: "+userId, HttpStatus.OK);
    }

}
