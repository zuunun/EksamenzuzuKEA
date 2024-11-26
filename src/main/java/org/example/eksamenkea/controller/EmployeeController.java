package org.example.eksamenkea.controller;

import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.Employee;
import org.example.eksamenkea.service.EmployeeService;
import org.example.eksamenkea.service.Errorhandling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@Controller
public class UserController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) { //konstruktor injection af employeeservice
        this.employeeService = employeeService;
    }

    @GetMapping("/login") //Amalie
    public String login() {
        return "login"; //retunerer til login view
    }

    //håndterer GET-forespørgsler til"/"
    @GetMapping("/") //Amalie
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("employee") != null) { //tjekker om en bruger er logget ind
            model.addAttribute("employeeAvaliable", true); //angiver at brugeren er tilgængelig
            model.addAttribute("employee", session.getAttribute("employee"));
        } else {
            model.addAttribute("employeeAvaliable", false);
        }
        return "homepage";
    }

    @PostMapping("/validate_login") //Amalie
    public String validateLogin(HttpSession session, @RequestParam String email, @RequestParam String password) throws Errorhandling {
        Employee employee = employeeService.signIn(email, password); //metodekald til userrepository
        if (employee != null) {
            //Koden er designet til at håndtere sessioner og brugerroller.
            // Brugerens rolle og ID gemmes i sessionen og bruges til at vise relevante
            // sider og udføre handlinger
            session.setAttribute("employee", employee); //gemmer brugeren i sessionen
            session.setAttribute("userRole", employee.getRole()); // Tilføj denne linje
            return "redirect:/logged_in";
        } else {
            throw new Errorhandling("Enter valid username and password");
        }
    }

    @GetMapping("/logged_in") //Amalie
    public String loggedIn(HttpSession session, Model model) throws Exception {
        Employee employee = (Employee) session.getAttribute("employee");  // Henter "user" fra sessionen.

        if (employee == null) {
            return "redirect:/login"; // Hvis ikke logget ind, send til login
        }
        if (employee.getRole() == Role.PROJECTLEADER) {    // Tjek brugerens rolle
            return "redirect:/project-leader-overview"; //retuner til skabelonen
        } else if (employee.getRole() == Role.WORKER) {
            return "redirect:/worker-overview";//ikke lavet endnu
        }
        throw new Errorhandling("no role found"); //
    }

    @GetMapping("/logout") //Amalie
    public String logout(HttpSession session) {
        session.invalidate(); //invaliderer sessionen for at logge ud
        return "redirect:/"; //return til front pagen ved log out
    }

}