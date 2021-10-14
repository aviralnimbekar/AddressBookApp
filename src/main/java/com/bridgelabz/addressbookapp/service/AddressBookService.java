package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.constants.ExceptionMsg;
import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.RespContactDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookAppException;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.repository.IAddressbookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<RespContactDTO> getAllContacts() {
        return addressbookRepository.findAll()
                .stream()
                .map(contact -> modelMapper.map(contact, RespContactDTO.class))
                .collect(Collectors.toList());
    }

    public Contact getContactById(int contactId) {
        return addressbookRepository.findById(contactId)
                .orElseThrow(() -> new AddressBookAppException(ExceptionMsg.NOT_FOUND.message + contactId));
    }

    public RespContactDTO addAndUpdateContact(ContactDTO contactDTO) {
        Contact newContact = modelMapper.map(contactDTO, Contact.class);
        addressbookRepository.save(newContact);
        return modelMapper.map(newContact, RespContactDTO.class);
    }

    public RespContactDTO updateContact(int contactId, ContactDTO contactDTO) {
        Contact contactById = this.getContactById(contactId);
        modelMapper.map(contactDTO, contactById);
        addressbookRepository.save(contactById);
        return modelMapper.map(contactById, RespContactDTO.class);
    }

    public RespContactDTO deleteContact(int contactId) {
        Contact contact = this.getContactById(contactId);
        addressbookRepository.delete(contact);
        return new RespContactDTO();
    }
}
