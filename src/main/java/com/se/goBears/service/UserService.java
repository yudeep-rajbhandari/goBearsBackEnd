package com.se.goBears.service;

import com.se.goBears.entity.Role;
import com.se.goBears.entity.User;
import com.se.goBears.enums.ERole;
import com.se.goBears.repository.RoleRepository;
import com.se.goBears.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * This method handles user role for user request.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    /**
     * This method returns a user object given a useremail.
     */
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }


    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    /**
     * This method updates the user role to admin.
     */
    public User updateRoleToAdmin(User user) {
        user.setRoles(new HashSet<>());
        Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("roleError"));
        user.getRoles().add(userRole);
        return userRepository.save(user);
    }

    /**
     * This method updates a user role to user.
     */
    public User updateRoleToUser(User user) {
        user.setRoles(new HashSet<>());
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("roleError"));
        user.getRoles().add(userRole);
        return userRepository.save(user);
    }
}
