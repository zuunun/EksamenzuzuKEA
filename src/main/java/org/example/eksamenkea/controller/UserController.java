package org.example.eksamenkea.controller;
import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.User;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) { //konstruktor injection af userservice
        this.userService = userService;
    }

    @GetMapping("/login") //Amalie
    public String login() {
        return "login"; //retunerer til login view
    }

    @GetMapping("/") //håndterer GET-forespørgsler til"/"
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) { //tjekker om en bruger er logget ind
            model.addAttribute("userAvaliable", true); //angiver at brugeren er tilgængelig
            model.addAttribute("user", session.getAttribute("user"));
        } else {
            model.addAttribute("userAvaliable", false);
        }
        return "homepage";
    }

    @PostMapping("/validate_login")
    public String validateLogin(HttpSession session, @RequestParam String email, @RequestParam String password) throws Errorhandling {
        User user = userService.signIn(email, password); //metodekald til userrepository
        if (user != null) {
            //Koden er designet til at håndtere sessioner og brugerroller.
            // Brugerens rolle og ID gemmes i sessionen og bruges til at vise relevante
            // sider og udføre handlinger
            session.setAttribute("user", user); //gemmer brugeren i sessionen
            session.setAttribute("userRole", user.getRole_id()); // Tilføj denne linje
            return "redirect:/logged_in";
        } else {
            throw new Errorhandling("Enter valid username and password");
        }
    }

    @GetMapping("/logged_in")
    public String loggedIn(HttpSession session, Model model) throws Exception {
        User user = (User) session.getAttribute("user");  // Henter "user" fra sessionen.

        if (user == null) {
            return "redirect:/login"; // Hvis ikke logget ind, send til login
        }

        if (user.getRole_id() == Role.PROJECTLEADER) {    // Tjek brugerens rolle
            return "redirect:/project-leader-overview"; //retuner til skabelonen
        } else if (user.getRole_id() == Role.WORKER) {
            return "redirect:/worker-overview";//ikke lavet endnu
        }
        throw new Errorhandling("no role found"); //
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); //invaliderer sessionen for at logge ud
        return "redirect:/"; //return til front pagen ved log out
    }

}