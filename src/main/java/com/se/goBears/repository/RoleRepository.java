package com.se.goBears.repository;


import com.se.goBears.entity.Role;
import com.se.goBears.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This is a repository interface for Role entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * This method returns the role object given the role name.
     * @param name is the name of the role.
     * @return role associated with the name.
     */
    Optional<Role> findByName(ERole name);
}
