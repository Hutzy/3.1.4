package ru.kata.spring.boot_security.demo.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UsersDetailsService;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

        private final UsersDetailsService userService;

        @Autowired
        public UserController(UsersDetailsService userService) {
                this.userService = userService;
        }

        @GetMapping()
        public String showUser (Model model, Principal principal) {
                model.addAttribute("user", userService.getUser(principal.getName()));
                return "userPage";
        }


}