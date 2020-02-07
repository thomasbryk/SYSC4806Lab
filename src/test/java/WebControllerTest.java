import jpa.ServingWebContentApplication;
import jpa.controllers.AddressBookWebController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ServingWebContentApplication.class})
public class WebControllerTest {

    @Autowired
    private AddressBookWebController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}