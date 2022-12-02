package com.se.goBears.repository;

import com.se.goBears.entity.Gate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * This is a repository interface for Gate entity.
 */
@Repository
public interface GateRepository extends CrudRepository<Gate, Long> {

    /**
     * This method returns a gate for the provided id.
     *
     * @param id is the id to be found.
     * @return associated gate.
     */
    Gate findGateById(Long id);

}
