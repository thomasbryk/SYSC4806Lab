import jpa.models.AddressBook;
import jpa.models.BuddyInfo;
import org.junit.Test;

public class AddressBookTest {

    private AddressBook book = new AddressBook();
    private BuddyInfo buddy = new BuddyInfo("Test1", "123-456-7890");

    @Test
    public void addBuddy() {
        book.addBuddy(buddy);
        assert(book.getBuddies().contains(buddy));
    }

    @Test
    public void getBuddies() {
        book.addBuddy(buddy);
        assert(book.getBuddies().contains(buddy));
    }

    @Test
    public void toStringTest() {
        book.addBuddy(buddy);
        assert(book.toString().equals("Name: Test1, Phone Number: 123-456-7890\n"));
    }

    @Test
    public void removeBuddy() {
        BuddyInfo remove_buddy = new BuddyInfo("Test2", "123-456-7890");
        book.addBuddy(remove_buddy);
        BuddyInfo removed_buddy = book.removeBuddy(remove_buddy.getName(), remove_buddy.getNumber());
        assert (removed_buddy.getName().equals(remove_buddy.getName()) && removed_buddy.getNumber().equals(remove_buddy.getNumber()));
    }
}