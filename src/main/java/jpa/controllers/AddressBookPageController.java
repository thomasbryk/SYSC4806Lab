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
class AddressBookPageController {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/addressbook")
    public String getAddressBooks(Model model) {
        model.addAttribute("addressBooks", addressBookRepository.findAll());
        return "addressbook";
    }

    @GetMapping("/displayAddressBook")
    public String getAddressBookPage(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("addressBook", addressBookRepository.findById(id));
        return "displayAddressBook";
    }

    @GetMapping("/getAddressBook")
    public String getAddressBook(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("addressBook", addressBookRepository.findById(id));
        return "addressbook";
    }

    @PostMapping("/addAddressbook")
    public String addAddressBook(Model model){
        AddressBook ab = new AddressBook();
        addressBookRepository.save(ab);
        model.addAttribute("addressBook", ab);
        return "redirect:addressbook";
    }

    @GetMapping("/getBuddy")
    public String getBuddy(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("buddy", buddyInfoRepository.findById(id));
        return "displayAddressBook";
    }

    @PostMapping("/addBuddy")
    public String addBuddy(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "number") String number, Model model) {
        BuddyInfo buddy = new BuddyInfo(name,number);
        buddyInfoRepository.save(buddy);
        AddressBook ab = addressBookRepository.findById(id);
        ab.addBuddy(buddy);
        model.addAttribute("addressBook", ab);
        addressBookRepository.save(ab);
        return "displayAddressBook";
    }
}