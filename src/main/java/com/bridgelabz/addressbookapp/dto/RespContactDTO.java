package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespContactDTO {

    private int id;
    private String fname;
    private String lname;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNo;
    private String email;
}
