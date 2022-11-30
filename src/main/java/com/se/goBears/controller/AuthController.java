package com.se.goBears.controller;


import com.se.goBears.entity.Role;
import com.se.goBears.entity.User;
import com.se.goBears.enums.ERole;
import com.se.goBears.payload.request.LoginRequest;
import com.se.goBears.payload.request.SignupRequest;
import com.se.goBears.payload.response.JwtResponse;
import com.se.goBears.payload.response.MessageResponse;
import com.se.goBears.repository.RoleRepository;
import com.se.goBears.repository.UserRepository;
import com.se.goBears.security.jwt.JwtUtils;
import com.se.goBears.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This controller class handles all the API request for user creation, user roles assignment and authentication.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {
    /**
     * This is an autowire to Authentication Manager.
     */
    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * This is an autowire to User Repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * This is an autowire to Role Repository.
     */
    @Autowired
    RoleRepository roleRepository;

    /**
     * This is an autowire to Password Encoder.
     */
    @Autowired
    PasswordEncoder encoder;

    /**
     * This is an autowire to Java Utils.
     */
    @Autowired
    JwtUtils jwtUtils;

    /**
     * For a valid request for an authentication, the method handles user authentication
     * and returns user details.
     * @param loginRequest login request body for the user that is to be authenticated.
     * @return the user details for the authenticated user.
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    /**
     * This method handles the user signup request. It handles user and roles creation.
     * Exception will be thrown if the username and email are not unique.
     * @param signUpRequest signup request body with user details.
     * @return a message response for successful signup or error..
     * @throws RuntimeException if user assigned roles is not found.
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
