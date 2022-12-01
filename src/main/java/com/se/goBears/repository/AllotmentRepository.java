package com.se.goBears.repository;

import com.se.goBears.entity.Allotment;
import com.se.goBears.entity.Building;
import com.se.goBears.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This is a repository interface for Allotment entity.
 */
public interface AllotmentRepository extends CrudRepository<Allotment, Long> {

    /**
     * This method returns a list of all allotments.
     *
     * @return list of allotments.
     */
    List<Allotment> findAll();

    /**
     * This method returns a list of all allotment by user.
     *
     * @param user is the user to be found.
     * @return a list od allotments.
     */
    List<Allotment> findAllotmentsByUser(User user);

}
