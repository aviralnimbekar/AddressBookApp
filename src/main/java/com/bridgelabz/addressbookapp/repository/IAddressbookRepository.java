package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressbookRepository extends JpaRepository<Contact, Integer> {
}
