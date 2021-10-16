package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Receive data object from clint
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 13/10/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    @NotBlank(message = "First Name cannot be empty")
    @Pattern(regexp = "^[A-Z][A-Za-z]{2,}$", message = "Invalid First Name!!!")
    public String fname;

    @NotBlank(message = "Last Name cannot be empty")
    @Pattern(regexp = "^[A-Z][A-Za-z]{2,}$", message = "Invalid Last Name!!!")
    public String lname;

    @NotBlank(message = "Address cannot be empty")
    public String address;

    @NotBlank(message = "City Name cannot be empty")
    public String city;

    @NotBlank(message = "State Name cannot be empty")
    public String state;

    @Pattern(regexp = "[1-9]\\d{5}", message = "Invalid Zip Code, Please Provide 6 digit Zip Code")
    public String zipCode;

    @Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid Phone Number")
    public String phoneNo;

    @Pattern(regexp = "[a-zA-Z0-9]+[-.+]?[a-z0-9]*@[a-z0-9]+[.][a-z]{2,3}[.]?[a-z]{0,3}",
            message = "Invalid Email")
    public String email;
}
