package com.se.goBears.controller;

import com.se.goBears.entity.Building;
import com.se.goBears.entity.User;
import com.se.goBears.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<User> getAllUser(){
        return userService.findAllUser();
    }

}
