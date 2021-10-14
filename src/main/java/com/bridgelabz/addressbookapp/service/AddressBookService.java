package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contacts;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Layer contains business logic,
 * also implements all the method in controller layer
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 13/10/2021
 */
@Service
public class AddressBookService {

    private final List<Contacts> contactList = new ArrayList<>();

    @Autowired
    private ModelMapper modelMapper;

    public List<Contacts> getAllContacts() {
        return contactList;
    }

    public Contacts getContactById(int contactId) {
        return contactList.get(contactId - 1);
    }

    public Contacts addContact(ContactDTO contactDTO) {
        Contacts newContact = new Contacts();
        modelMapper.map(contactDTO, newContact);
        contactList.add(newContact);
        return newContact;
    }

    public Contacts updateContact(int contactId, ContactDTO contactDTO) {
        return addContact(contactDTO);
    }

    public Contacts deleteContact(int contactId) {
        return contactList.remove(contactId - 1);
    }
}
