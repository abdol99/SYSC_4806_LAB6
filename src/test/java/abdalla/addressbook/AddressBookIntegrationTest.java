package abdalla.addressbook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressBookRestController.class)
public class AddressBookIntegrationTest {

    private final UUID id = UUID.randomUUID();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddressBookRepository mockRepo;

    /**
     * Bare minimum test thanks
     */
    @Test
    public void testCreateAddressBook() throws Exception {
        mockMvc.perform(post("/addressBooks")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":null,\"addressBookSize\":0,\"buddyList\":[]}")));
    }
}
