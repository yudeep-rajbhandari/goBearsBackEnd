 package com.se.goBears.service;

import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import com.se.goBears.errors.CustomException;
import com.se.goBears.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 /**
  * This is the service class for Resource entity.
  */
@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepo;

    @Autowired
    private RoomService roomService;

     /**
      * This method returns a list of all resources.
      *
      * @return a list of all resources.
      */
    public List<Resource> getAllResource(){
        return  resourceRepo.findAll();

    }

     /**
      * This method returns a resource object given a resource id.
      *
      * @param id is the id of the resource.
      * @return a resource object associated with the id.
      */
    public  Resource getResourceByID(Long id){
        return resourceRepo.findResourceById(id);
    }

     /**
      * This method returns a resource object given a resource name.
      *
      * @param name is the name of the resource.
      * @return a resource object associated with the resource name.
      */
    public  Resource getResourceByName(String name){
        return  resourceRepo.findResourceByResourceName(name);

    }

     /**
      * This method returns a list of resource given a resource type.
      *
      * @param type is the type of resource.
      * @return a list of resource associated with a resource type.
      */
    public List<Resource> getResourceByResourceType(Resource.ResourceType type){
        return  resourceRepo.findResourceByResourceType(type);
    }

     /**
      * This method returns a list of resource given a resource working condition.
      *
      * @param condition is the working condition of resource.
      * @return a list of resource associated with the given working condition.
      */
    public List<Resource> getResourceByWorkingCondition(Resource.WorkingCondition condition){
        return resourceRepo.findResourceByWorkingCondition(condition);

    }

     /**
      * This method creates a resource if the resource does not exist already.
      *
      * @param resource is the resource object to be created.
      * @return the resource object created.
      * @throws Exception if a resource with given resource name already exists.
      */
    public Resource createResource(Resource resource){

        if (getResourceByName(resource.getResourceName()) != null){
            throw new CustomException("Resource with given name already exists");
        }
        return resourceRepo.save(resource);
    }

     /**
      * The method sets a resource room and creates a resource.
      *
      * @param resource the resource object to be created.
      * @return the resource object created.
      */
    public Resource addResource2(Resource resource){
        Room room = roomService.findRoomById(resource.getRoom().getId());
        resource.setRoom(room);
        return resourceRepo.save(resource);
    }

     /**
      * This method returns a list of resource associated with a given room id.
      *
      * @param id is the id of the room.
      * @return a list of resources associated with the room.
      */
    public List<Resource> getResourceByRoom(Long id){
        return resourceRepo.findAllByRoomOrderById(roomService.findRoomById(id));
    }

     /**
      * This method returns the total count of the resources.
      *
      * @return a count of all resources.
      */
    public Integer getResourceCount(){
        return resourceRepo.findAll().size();
    }

     /**
      * This method returns the name of a resources given a resource id.
      * @param id is the id of the resource
      * @return a resource object.
      */
    public String getResourceNameById(Long id){
        return resourceRepo.findResourceById(id).getResourceName();
    }


}
