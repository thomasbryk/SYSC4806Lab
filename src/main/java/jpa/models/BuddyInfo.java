package jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BuddyInfo {

    private Long id;
    private String name;
    private String number;
    @JsonIgnore
    private AddressBook addressBook;

    public BuddyInfo (){
        this.name = null;
        this.number = null;
    }

    public BuddyInfo (String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getNumber () {
        return this.number;
    }

    public void setNumber (String number){
        this.number = number;
    }

    @ManyToOne
    public AddressBook getAddressBook (){
        return this.addressBook;
    }

    public void setAddressBook(AddressBook addressBook){
        this.addressBook = addressBook;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Player to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals (String name){
        return this.name.equals(name);
    }


    public boolean equals (String name, String number){
        return this.name.equals(name) && this.number.equals(number);
    }

    public String toString(){
        return("Name: " + this.name + ", Phone Number: " + this.number);
    }
}