package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.RespContact;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contacts;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @Autowired
    private AddressBookService addressBookService;

    /**
     * Function to receive get request from clint
     *
     * @return list of all contact saved in system
     */
    @GetMapping("/get-all")
    public ResponseEntity<ResponseDTO> getAllContacts() {
        RespContact allContacts = addressBookService.getAllContacts();
        ResponseDTO respDto = new ResponseDTO("Get call Succeed", allContacts);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }

    /**
     * Function to receive get request from clint
     *
     * @param contactId unique Id of contact
     * @return response entity contact from DB
     */
    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int contactId) {
        RespContact contactById = addressBookService.getContactById(contactId);
        ResponseDTO respDto = new ResponseDTO("Get call Succeed for id : " + contactId, contactById);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }

    /**
     * Function to receive post request from clint
     *
     * @param contactDTO contact data object from clint
     * @return response entity newly created contact data object
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody ContactDTO contactDTO) {
        RespContact newContact = addressBookService.addAndUpdateContact(contactDTO);
        ResponseDTO respDto = new ResponseDTO("Created Contact Data for : ", newContact);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }

    /**
     * Function to receive put request from clint
     *
     * @param contactId  unique Id of contact
     * @param contactDTO contact data object from clint
     * @return response entity updated contact data object
     */
    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int contactId, @RequestBody ContactDTO contactDTO) {
        RespContact updatedContact = addressBookService.updateContact(contactId, contactDTO);
        ResponseDTO respDto = new ResponseDTO("Updated Contact Data for : " + contactId, updatedContact);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }

    /**
     * Function to receive delete request from clint
     *
     * @param contactId unique Id of contact
     * @return response entity with conformation message
     */
    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int contactId) {
        Contacts deletedContact = addressBookService.deleteContact(contactId);
        ResponseDTO respDto = new ResponseDTO("Deleted Contact Data for : " + contactId, null);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }
}
