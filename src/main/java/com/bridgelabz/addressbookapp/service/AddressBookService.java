package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.RespContact;
import com.bridgelabz.addressbookapp.model.Contacts;
import com.bridgelabz.addressbookapp.repository.IAddressbookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private IAddressbookRepository addressbookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RespContact getAllContacts() {
        RespContact respContact = new RespContact();
        List<Contacts> allContacts = addressbookRepository.findAll();
        modelMapper.map(allContacts, respContact);
        return respContact;
    }

    public RespContact getContactById(int contactId) {
        RespContact respContact = new RespContact();
        Contacts contactById = addressbookRepository.getById(contactId);
        modelMapper.map(contactById, respContact);
        return respContact;
    }

    public RespContact addAndUpdateContact(ContactDTO contactDTO) {
        Contacts newContact = new Contacts();
        RespContact respContact = new RespContact();
        modelMapper.map(contactDTO, newContact);
        addressbookRepository.save(newContact);
        modelMapper.map(newContact, respContact);
        return respContact;
    }

    public RespContact updateContact(int contactId, ContactDTO contactDTO) {
        Contacts contactById = addressbookRepository.getById(contactId);
        RespContact respContact = new RespContact();
        modelMapper.map(contactDTO, contactById);
        addressbookRepository.save(contactById);
        modelMapper.map(contactById, respContact);
        return respContact;
    }

    public Contacts deleteContact(int contactId) {
        addressbookRepository.deleteById(contactId);
        return  null;
    }
}
