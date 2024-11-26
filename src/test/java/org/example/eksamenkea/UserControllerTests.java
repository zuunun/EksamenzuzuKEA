package org.example.eksamenkea;

import org.example.eksamenkea.controller.UserController;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.User;
import org.example.eksamenkea.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService; // Mock UserService for afhængigheder

    @Test
    public void HomePage_UserNotLoggedIn() throws Exception { //Amalie
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"))
                .andExpect(model().attributeExists("userAvaliable"));
    }
    @Test
    public void testHomePage_UserLoggedIn() throws Exception { //Amalie
        // Simuler session med en bruger
        mockMvc.perform(get("/")
                        .sessionAttr("user", new User(1, "test@example.com", "password", Role.WORKER)))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"))
                .andExpect(model().attribute("userAvaliable", true))
                .andExpect(model().attributeExists("user")); // Tjekker for brugerattribut
    }
}
