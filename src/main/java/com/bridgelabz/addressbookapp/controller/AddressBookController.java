package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contacts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Receive various HTTP requests from clint and call respective method
 * from service layer
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 13-10-2021
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/get-all")
    public ResponseEntity<ResponseDTO> getAllContacts() {
        Contacts contacts = new Contacts(new ContactDTO());
        ResponseDTO respDto = new ResponseDTO("Get call Succeed", contacts);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int contactId) {
        Contacts contact = new Contacts(new ContactDTO());
        ResponseDTO respDto = new ResponseDTO("Get call Succeed for id : " + contactId, contact);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contactDTO) {
        Contacts contact = new Contacts(contactDTO);
        ResponseDTO respDto = new ResponseDTO("Created Contact Data for : ", contact);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int contactId, @RequestBody ContactDTO contactDTO) {
        Contacts contact = new Contacts(contactDTO);
        ResponseDTO respDto = new ResponseDTO("Updated Contact Data for : " + contactId, contact);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int contactId) {
        ResponseDTO respDto = new ResponseDTO("Deleted Contact Data for : " + contactId, null);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }
}
