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
        this.mockMvc.perform(post("/rest_addAddressbook")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getAddressBook() throws Exception {
        this.mockMvc.perform(post("/rest_addAddressbook"));
        this.mockMvc.perform(get("/rest_getAddressBook").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("id", "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void createBuddies() throws Exception {
        this.mockMvc.perform(post("/rest_addAddressbook"));
        this.mockMvc.perform(get("/rest_getAddressBook").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("id", "1")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(post("/rest_addBuddy").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("id", "1").param("name", "Thomas").param("number", "123456789")).andDo(print()).andExpect(status().isOk());
    }
}