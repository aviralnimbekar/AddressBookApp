package com.bridgelabz.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class contains Main method to run entire application
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 13-10-2021
 */
@SpringBootApplication
@Slf4j
class AddressBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
        log.info("Address Book Application is Running");
    }

}
