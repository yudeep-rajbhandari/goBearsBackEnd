package com.se.goBears.controller;


import com.se.goBears.entity.User;
import com.se.goBears.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


    @Autowired
    UserService userService;
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "User Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/building/addBuilding")
    @PreAuthorize("hasRole('ADMIN')")
    public String addBuilding() {
        return "Add Building here";
    }


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

