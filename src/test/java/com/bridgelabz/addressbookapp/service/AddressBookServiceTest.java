package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.RespContactDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookAppException;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.repository.IAddressbookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("dev")
class AddressBookServiceTest {

    private final Contact contact1 = new Contact(1, "Lisa", "Kudrow", "CH", "RAI", "CG",
            "12345", "9087654321", "exapmle12@gmail.com");
    private final Contact contact2 = new Contact(2, "Mark", "Taylor", "CH", "RAI", "CG",
            "12345", "9087654321", "example007@gmail.com");
    private final Contact contact3 = new Contact(3, "Monica", "Geller", "CH", "RAI", "CG",
            "12345", "9087654321", "exapmle12@gmail.com");
    private final List<Contact> mockContactList = new ArrayList<>();

    @Mock
    private IAddressbookRepository addressbookRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ContactDTO contactDTO;

    @Mock
    private RespContactDTO respContactDTO;

    @InjectMocks
    private AddressBookService addressBookService;

    @BeforeEach
    void setUp() {
        mockContactList.add(contact1);
        mockContactList.add(contact2);
    }

    @Test
    void givenGetAllContact_WhenCalled_ShouldReturnNumberOfContacts() {
        when(addressbookRepository.findAll()).thenReturn(mockContactList);
        List<RespContactDTO> actual = addressBookService.getAllContacts();
        Assertions.assertEquals(2, actual.size());
    }

    @Test
    void givenGetAllContact_WhenCalled_ShouldNotReturnNumberOfContacts() {
        when(addressbookRepository.findAll()).thenReturn(mockContactList);
        List<RespContactDTO> actual = addressBookService.getAllContacts();
        Assertions.assertNotEquals(1, actual.size());
    }

    @Test
    void givenGetContactById_WhenCalled_ShouldReturnContactById() {
        when(addressbookRepository.findById(any())).thenReturn(Optional.of(contact2));
        Contact actual = addressBookService.getContactById(2);
        Assertions.assertEquals(contact2, actual);
    }

    @Test
    void givenGetContactById_WhenCalled_ShouldNotReturnContactById() {
        when(addressbookRepository.findById(any())).thenReturn(Optional.of(contact1));
//        Contact actual = addressBookService.getContactById(2);
//        Assertions.assertNotEquals(contact2, actual);

        Assertions.assertThrows(AddressBookAppException.class, () -> addressBookService.getContactById(2));
    }

    @Test
    void addContact() {
        ContactDTO contactDTO = new ContactDTO("Monica", "Geller", "CH", "RAI", "CG",
                "12345", "9087654321", "exapmle12@gmail.com");
        Contact contact = new Contact();
        RespContactDTO expected = new RespContactDTO(3, "Monica", "Geller", "CH", "RAI", "CG",
                "12345", "9087654321", "exapmle12@gmail.com");

        when(modelMapper.map(contactDTO, Contact.class)).thenReturn(contact);
        when(addressbookRepository.save(any())).thenReturn(contact3);
        when(modelMapper.map(contact3, RespContactDTO.class)).thenReturn(respContactDTO);
        RespContactDTO actual = addressBookService.addContact(any());

        Assertions.assertEquals(respContactDTO.getCity().equals("RAI"), actual.getCity().equals("RAI"));
    }

    @Test
    void updateContact() {
    }

    @Test
    void deleteContact() {
    }
}