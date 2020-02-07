package jpa.controllers;
import jpa.models.*;
import jpa.views.AddressBookView;

import javax.swing.*;

public class AddressBookController{

    private AddressBook addressBook;
    private AddressBookView view;
    private DefaultListModel<BuddyInfo> buddyInfoModelList;

    public AddressBookController() {
        this.buddyInfoModelList = new DefaultListModel<>();
    }

    public void setModel (AddressBook book){
        this.addressBook = book;
    }

    public void setView (AddressBookView view){
        this.view = view;
    }

    public AddressBook getModel(){
        return this.addressBook;
    }

    public AddressBookView getView(){
        return this.view;
    }

    public DefaultListModel<BuddyInfo> getModelList (){
        return this.buddyInfoModelList;
    }

    public void createAddressBook(){
        this.setModel(new AddressBook());
    }

    public void addBuddy (String name, String number){
        BuddyInfo buddy = new BuddyInfo(name, number);
        buddyInfoModelList.addElement(buddy);
        addressBook.addBuddy(buddy);
    }

    public void removeBuddy (String buddyName){
        buddyInfoModelList.removeElement(buddyName);
        addressBook.removeBuddy(buddyName);
    }

    public String display (){
        return addressBook.toString();
    }
}
