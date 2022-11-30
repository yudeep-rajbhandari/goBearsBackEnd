package com.se.goBears.controller;


import com.se.goBears.entity.User;
import com.se.goBears.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }


    @PutMapping("/updateRole")
    public User updateRole(@RequestBody User user) {
        return userService.updateRole(user);
    }
}
