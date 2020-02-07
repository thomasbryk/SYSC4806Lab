package jpa.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    private Long id;
    private List<BuddyInfo> buddies;

    public AddressBook (){
        this.buddies = new ArrayList<>();
    }

    public AddressBook (ArrayList<BuddyInfo> buddies){
        this.buddies = buddies;
    }

    public void addBuddy(BuddyInfo buddy){
        this.buddies.add(buddy);
        buddy.setAddressBook(this);
    }

    @OneToMany (cascade= CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "addressBook")
    public List<BuddyInfo> getBuddies(){
        return this.buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies){
        this.buddies = buddies;
    }

    public BuddyInfo removeBuddy (String name){
        for (int i = 0 ; i < this.buddies.size();i++){
            if (this.buddies.get(i).equals(name)) {
                return this.buddies.remove(i);
            }
        }
        return null;
    }

    public BuddyInfo removeBuddy (String name, String number){
        for (int i = 0 ; i < this.buddies.size();i++){
            if (this.buddies.get(i).equals(name,number)) {
                return this.buddies.remove(i);
            }
        }
        return null;
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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("AddressBook id=");
        sb.append(this.id);
        sb.append("\n");
        for (BuddyInfo b : this.buddies){
            sb.append(b.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main (String[] args){
        AddressBook book = new AddressBook();
        book.addBuddy(new BuddyInfo("Buddy1","123-456-7890"));
        book.addBuddy(new BuddyInfo("Buddy2","987-654-3210"));
        System.out.println(book.toString());
    }
}