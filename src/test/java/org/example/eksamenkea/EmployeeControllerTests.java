package org.example.eksamenkea;
import org.example.eksamenkea.controller.EmployeeController;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.Employee;
import org.example.eksamenkea.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService; // Mock UserService for afhængigheder

    @Test
    public void HomePage_UserNotLoggedIn() throws Exception { //Amalie
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"))
                .andExpect(model().attributeExists("employeeAvaliable"));
    }
    @Test
    public void testHomePage_UserLoggedIn() throws Exception { //Amalie
        // Simuler session med en bruger
        mockMvc.perform(get("/")
                        .sessionAttr("employee", new Employee(1, "test@example.com", "password", Role.WORKER)))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"))
                .andExpect(model().attribute("employeeAvaliable", true))
                .andExpect(model().attributeExists("employee")); // Tjekker for brugerattribut
    }
}
