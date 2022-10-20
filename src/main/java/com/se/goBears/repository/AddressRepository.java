package com.se.goBears.repository;

import com.se.goBears.entity.Address;
import com.se.goBears.entity.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>  {
}
