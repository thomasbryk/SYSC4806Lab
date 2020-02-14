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
public class AddressBookWebController {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @CrossOrigin
    @GetMapping("/rest/getAddressBooks")
    public Iterable<AddressBook> getAddressBooks() {
        return addressBookRepository.findAll();
    }

    @GetMapping("/rest/getAddressBook")
    public AddressBook getAddressBook(@RequestParam(value = "id") long id) {
        return addressBookRepository.findById(id);
    }

    @CrossOrigin
    @PostMapping("/rest/addAddressbook")
    public AddressBook addAddressBook(){
        AddressBook ab = new AddressBook();
        addressBookRepository.save(ab);
        return ab;
    }

    @GetMapping("/rest/getBuddy")
    public BuddyInfo getBuddy(@RequestParam(value = "id") long id) {
        return buddyInfoRepository.findById(id);
    }

    @PostMapping("/rest/addBuddy")
    public BuddyInfo addBuddy(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "number") String number) {
        BuddyInfo buddy = new BuddyInfo(name,number);
        buddyInfoRepository.save(buddy);
        AddressBook ab = addressBookRepository.findById(id);
        ab.addBuddy(buddy);
        addressBookRepository.save(ab);
        return buddy;
    }
}