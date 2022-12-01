package com.se.goBears.repository;

import com.se.goBears.entity.Address;
import com.se.goBears.entity.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * This is a repository interface for Address entity.
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    /**
     * On an input id the method returns the address associated with the id.
     *
     * @param id is the id to be found.
     * @return an address object.
     */
    Address findAddressById(Long id);
}
