package com.bridgelabz.address_book.repository;

import com.bridgelabz.address_book.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<Address, Long> {
}
