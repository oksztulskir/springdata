package com.example.springdata.web;

import com.example.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 */
@Controller
@RequestMapping("/mvc/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Secured({"USER", "ADMIN"})
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());

        return "index";
    }

    @GetMapping("/{id}")
    @Secured("ADMIN")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.delete(id);
        model.addAttribute("users", userService.findAll());

        return "index";
    }

    @GetMapping("/update/{id}")
    @Secured("ADMIN")
    public String update(@PathVariable Long id, Model model) {
//        model.addAttribute("user", userService.)
        return "updateUser";
    }


}
