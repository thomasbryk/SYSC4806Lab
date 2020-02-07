package jpa.controllers;

import java.util.concurrent.atomic.AtomicLong;
import jpa.models.AddressBook;
import jpa.models.BuddyInfo;
import jpa.repositories.AddressBookRepository;
import jpa.repositories.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AddressBookWebController {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/addressbook")
    public String newAddressBook(Model model) {
        AddressBook ab = new AddressBook();
        addressBookRepository.save(ab);
        model.addAttribute("addressBook", ab);
        return "addressBook";
    }

    @GetMapping("/addBuddy")
    public String addBuddy(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
        buddyInfoRepository.save(buddy);
        AddressBook ab = addressBookRepository.findById(1L);
        ab.addBuddy(buddy);
        model.addAttribute("addressBook", ab);
        addressBookRepository.save(ab);
        return "displayAddressBook";
    }
}