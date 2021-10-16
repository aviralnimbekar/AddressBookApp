package com.bridgelabz.addressbookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Create and maintains Entity object i.e. employee payroll data object.
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 13/10/2021
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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