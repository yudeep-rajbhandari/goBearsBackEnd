package com.se.goBears.repository;

import com.se.goBears.entity.Allotment;
import com.se.goBears.entity.Building;
import com.se.goBears.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AllotmentRepository extends CrudRepository<Allotment, Long> {

    List<Allotment> findAll();

    List<Allotment> findAllotmentsByUser(User user);

}
