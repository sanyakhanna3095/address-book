package com.bridgelabz.address_book.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
public @ToString class AddressDTO {
    @NotEmpty(message = "User name can't be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid name")
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;

    @NotEmpty(message = "Address can't be null")
    private String address;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "startDate should not be empty")
    @PastOrPresent(message = "Start date should be a past date or today's date")
    public LocalDate startDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "endDate should not be empty")
    @FutureOrPresent(message = "End date should be a future date or today's date")
    public LocalDate endDate;


//    @Override
//    public String toString() {
//        return "AddressDTO{" + "name='" + name + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + '}';
//    }

}
