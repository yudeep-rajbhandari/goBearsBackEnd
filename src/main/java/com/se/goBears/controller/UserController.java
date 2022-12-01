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


    @PutMapping("/updateRoleToAdmin")
    public User updateRoleToAdmin(@RequestBody User user) {
        return userService.updateRoleToAdmin(user);
    }

    @PutMapping("/updateRoleToUser")
    public User updateRoleToUser(@RequestBody User user) {
        return userService.updateRoleToUser(user);
    }
}
