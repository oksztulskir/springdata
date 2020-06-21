package com.example.springdata.web;

import com.example.springdata.domain.model.User;
import com.example.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 */
@RestController
@RequestMapping("/user")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // GET http://localhost:8088/user
    @GetMapping
    @ResponseBody
    public List<User> getAll() {
        return userService.findAll();
    }

    // GET http://localhost:8088/user/{id}
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.find(id);
    }

    // POST http://localhost:8088/user
    @PostMapping
    @ResponseBody
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    // PUT http://localhost:8088/user
    @PutMapping
    @ResponseBody
    public User update(@RequestBody User user) {
        return userService.save(user);
    }
}
