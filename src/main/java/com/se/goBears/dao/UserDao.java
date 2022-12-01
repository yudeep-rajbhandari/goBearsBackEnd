package com.se.goBears.dao;

import com.se.goBears.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This interface DAO handles the data for the User entity.
 */
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * This method on provided username returns a user associated with it.
     * @param username is the name of the user.
     * @return the associated user object.
     */
    User findByUsername(String username);

    /**
     * This method on provided role returns all users associated with it.
     * @param role is the specified role.
     * @return the list of users associated with the role.
     */
    User findUsersByRoles(String role);

}
