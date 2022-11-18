package com.se.goBears.repository;

import com.se.goBears.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Resource findResourceByResourceName(String resourceName);
    List<Resource> findAll();
    Resource findResourceById(Long id);
    List<Resource> findResourceByResourceType(Resource.ResourceType resourceType);
    List<Resource> findResourceByWorkingCondition(Resource.WorkingCondition workingCondition);

}
