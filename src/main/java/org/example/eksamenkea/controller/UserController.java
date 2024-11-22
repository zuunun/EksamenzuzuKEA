//package org.example.eksamenkea.controller;
//
//import org.example.eksamenkea.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@RequestMapping("")
//@Controller
//public class UserController {
//
//    private UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
////    @PostMapping("/validate_login")
////    public String validateLogin(HttpSession session, @RequestParam String username, @RequestParam String password) {
////        User user =
////        if (user != null) {
////            session.setAttribute("user", user);
////            return "redirect:/logged_in";
////        } else {
////            return "login";
////        }
////    }
//}