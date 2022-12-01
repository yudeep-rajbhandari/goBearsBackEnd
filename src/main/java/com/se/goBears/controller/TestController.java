package com.se.goBears.controller;


import com.se.goBears.entity.User;
import com.se.goBears.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * This is a test controller class that is used for testing.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


    @Autowired
    UserService userService;

    /**
     * This method tests if the system handle the public access.
     * @return message on success
     */
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    /**
     * This method check if the system handle the access as a user.
     * @return message on success.
     */
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "User Board.";
    }

    /**
     * This method check if the system handle the access as a admin.
     * @return message on success.
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    /**
     * This method tests how the system handle admin access to adding a building.
     * @return if user is admin a success message is displayed.
     */
    @GetMapping("/building/addBuilding")
    @PreAuthorize("hasRole('ADMIN')")
    public String addBuilding() {
        return "Add Building here";
    }

    /**
     * This method tests how the system handle user email.
     * @return if user email if exists.
     */
    @GetMapping("/findUserByEmail/{email}")
    @PreAuthorize("hasRole('USER')")
    public User findUserByEmail(String email){
        return userService.findUserByEmail(email);
    }
//    @PutMapping("/updateRole")
//    public User updateRole(@PathVariable Long userId){
//        return userService.findUserByEmail()
//    }
}

