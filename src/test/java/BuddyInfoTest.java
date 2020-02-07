import jpa.models.BuddyInfo;
import org.junit.Test;

public class BuddyInfoTest {

    private BuddyInfo buddy = new BuddyInfo("Test Buddy", "123-456-7890");

    @Test
    public void getName () {
        assert(this.buddy.getName().equals("Test Buddy"));
    }

    @Test
    public void setName (){
        this.buddy.setName("Test");
        assert(this.buddy.getName().equals("Test"));
    }

    @Test
    public void getNumber () {
        assert(this.buddy.getNumber().equals("123-456-7890"));
    }

    @Test
    public void setNumber (){
        this.buddy.setNumber("987-654-3210");
        assert(this.buddy.getNumber().equals("987-654-3210"));
    }

    @Test
    public void toString_test() {
        this.buddy.setName("Test Buddy");
        this.buddy.setNumber("123-456-7890");
        assert (this.buddy.toString().equals("Name: Test Buddy, Phone Number: 123-456-7890"));
    }
}
