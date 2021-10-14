package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.constants.RequestMsg;
import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.RespContactDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.modelmapper.ModelMapper;
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
        List<RespContactDTO> allContacts = addressBookService.getAllContacts();
        ResponseDTO respDto = new ResponseDTO(RequestMsg.GET_CALL.message, allContacts);
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
        ModelMapper modelMapper = new ModelMapper();
        Contact contactById = addressBookService.getContactById(contactId);
        RespContactDTO respContactDTO = modelMapper.map(contactById, RespContactDTO.class);
        ResponseDTO respDto = new ResponseDTO(RequestMsg.GET_CALL_ID.message + contactId, respContactDTO);
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
        RespContactDTO newContact = addressBookService.addAndUpdateContact(contactDTO);
        ResponseDTO respDto = new ResponseDTO(RequestMsg.POST_CALL.message, newContact);
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
        RespContactDTO updatedContact = addressBookService.updateContact(contactId, contactDTO);
        ResponseDTO respDto = new ResponseDTO(RequestMsg.PUT_CALL.message + contactId, updatedContact);
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
        RespContactDTO deletedContact = addressBookService.deleteContact(contactId);
        ResponseDTO respDto = new ResponseDTO(RequestMsg.DELETE_CALL.message + contactId, deletedContact);
        return new ResponseEntity<>(respDto, HttpStatus.OK);
    }
}
