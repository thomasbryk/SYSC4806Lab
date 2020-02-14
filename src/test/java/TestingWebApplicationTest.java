import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import jpa.ServingWebContentApplication;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = {ServingWebContentApplication.class})
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAddressBook() throws Exception {
        this.mockMvc.perform(post("/addressbook")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getAddressBook() throws Exception {
        this.mockMvc.perform(post("/addressbook"));
        this.mockMvc.perform(get("/addressbook").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("id", "1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("AddressBook id=1")));
    }
}