package com.se.goBears.controller;


import com.se.goBears.entity.User;
import com.se.goBears.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller class handles API requests for user
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This method returns all users registered in the system.
     * @return a list of all users in the system.
     */
    @GetMapping("/getAllUser")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }


    @PutMapping("/updateRoleToAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateRoleToAdmin(@RequestBody User user) {
        return userService.updateRoleToAdmin(user);
    }

    @PutMapping("/updateRoleToUser")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateRoleToUser(@RequestBody User user) {
        return userService.updateRoleToUser(user);
    }
}
