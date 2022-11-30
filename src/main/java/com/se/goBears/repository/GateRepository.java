package com.se.goBears.repository;

import com.se.goBears.entity.Gate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GateRepository extends CrudRepository<Gate, Long> {

    Gate findGateById(Long id);

}
