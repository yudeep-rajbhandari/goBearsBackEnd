package com.se.goBears.repository;

import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This is a repository interface for Resource entity.
 */
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    /**
     * This method returns the resource object given the resource name.
     *
     * @param resourceName is the name of the resource.
     * @return resource object.
     */
    Resource findResourceByResourceName(String resourceName);

    /**
     * This method returns a list of all resource.
     *
     * @return a list of resources.
     */
    List<Resource> findAll();

    /**
     * This method returns a resource object given a associated resource id.
     *
     * @param id is the id of the resource.
     * @return resource associated with the id.
     */
    Resource findResourceById(Long id);

    /**
     * This method returns a list of resource given a resource type.
     *
     * @param resourceType is the type of the resource to be found.
     * @return a list of resource associated with the given resource type.
     */
    List<Resource> findResourceByResourceType(Resource.ResourceType resourceType);

    /**
     * This method returns a list of resource given the resource working condition.
     *
     * @param workingCondition is the resource working condition to be found.
     * @return a list of resource associated with the working condition.
     */
    List<Resource> findResourceByWorkingCondition(Resource.WorkingCondition workingCondition);

    /**
     * The method returns a list of resource when a room associated is given.
     *
     * @param room room to be found.
     * @return a list of resources associated to a room.
     */
    List<Resource> findAllByRoomOrderById(Room room);

}
