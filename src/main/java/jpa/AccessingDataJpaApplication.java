package jpa;

import jpa.repositories.AddressBookRepository;
import jpa.models.AddressBook;
import jpa.models.BuddyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            AddressBook addressBook1 = new AddressBook();
            addressBook1.addBuddy(new BuddyInfo("Test1", "123456789"));
            addressBook1.addBuddy(new BuddyInfo("Test2", "23456789"));

            AddressBook addressBook2 = new AddressBook();
            addressBook2.addBuddy(new BuddyInfo("Test3", "3456789"));
            addressBook2.addBuddy(new BuddyInfo("Test4", "456789"));

            // save a few customers
            //repository.save(addressBook1);
            //repository.save(addressBook2);


            // fetch all customers
            log.info("jpa.models.AddressBook's found with findAll():");
            log.info("-------------------------------");
            for (AddressBook addressBook : repository.findAll()) {
                log.info(addressBook.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            AddressBook addressBook = repository.findById(1L);
            log.info("jpa.models.AddressBook found with findById(1L):");
            log.info("--------------------------------");
            log.info(addressBook.toString());
            log.info("");
        };
    }

}