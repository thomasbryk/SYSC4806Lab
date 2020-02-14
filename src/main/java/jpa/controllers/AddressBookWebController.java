package jpa.controllers;

import java.util.concurrent.atomic.AtomicLong;
import jpa.models.AddressBook;
import jpa.models.BuddyInfo;
import jpa.repositories.AddressBookRepository;
import jpa.repositories.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AddressBookWebController {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;


    @GetMapping("/rest_getAddressBook")
    public AddressBook getAddressBook(@RequestParam(value = "id") long id) {
        return addressBookRepository.findById(id);
    }

    @PostMapping("/rest_addAddressbook")
    public AddressBook addAddressBook(){
        AddressBook ab = new AddressBook();
        addressBookRepository.save(ab);
        return ab;
    }

    @GetMapping("/rest_getBuddy")
    public BuddyInfo getBuddy(@RequestParam(value = "id") long id) {
        return buddyInfoRepository.findById(id);
    }

    @PostMapping("/rest_addBuddy")
    public BuddyInfo addBuddy(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "number") String number) {
        BuddyInfo buddy = new BuddyInfo(name,number);
        buddyInfoRepository.save(buddy);
        AddressBook ab = addressBookRepository.findById(id);
        ab.addBuddy(buddy);
        addressBookRepository.save(ab);
        return buddy;
    }
}