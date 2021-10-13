package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;

/**
 * Create and maintains Entity object i.e. employee payroll data object.
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 13/10/2021
 */
public class Contacts {

    public String name;
    public String address;
    public long phoneNo;

    public Contacts(ContactDTO contactDTO) {
        name = contactDTO.name;
        address = contactDTO.address;
        phoneNo = contactDTO.phoneNo;
    }
}