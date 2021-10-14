package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

@Data
public class RespContact {

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
