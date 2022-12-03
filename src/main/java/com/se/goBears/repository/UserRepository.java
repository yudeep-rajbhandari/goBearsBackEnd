package com.se.goBears.repository;

import com.se.goBears.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This is a repository interface for User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * This method returns the user object associated with the given username.
     *
     * @param username is the username to be found.
     * @return user associated with the username.
     */
    Optional<User> findByUsername(String username);

    /**
     * This method returns true if the user with given username exists.
     *
     * @param username is the username to be found.
     * @return true if user exists else false.
     */
    Boolean existsByUsername(String username);

    /**
     * This method returns true if the user with given email exists.
     *
     * @param email is the user email to be found.
     * @return true if user exists else false.
     */
    Boolean existsByEmail(String email);


    /**
     * This method returns user given the user id.
     *
     * @param id is the id of the user to be found.
     * @return a user associated with the id.
     */
    User findUserById(Long id);

    /**
     * This method returns the user given the user email.
     *
     * @param email is the email of the user to be found.
     * @return a user associated with the user email.
     */
    User findUserByEmail(String email);

    /**
     * This method returns a list of all users.
     *
     * @return a list of all users.
     */
    List<User> findAll();
}
