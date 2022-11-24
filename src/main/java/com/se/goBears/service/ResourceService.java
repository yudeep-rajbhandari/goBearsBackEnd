 package com.se.goBears.service;

import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import com.se.goBears.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepo;

    @Autowired
    private RoomService roomService;

    public List<Resource> getAllResource(){
        return  resourceRepo.findAll();

    };

    public  Resource getResourceByID(Long id){
        Resource resource = resourceRepo.findResourceById(id);
        return resource;
    };

    public  Resource getResourceByName(String name){
        Resource resource = resourceRepo.findResourceByResourceName(name);
        return resource;
    };

    public List<Resource> getResourceByResourceType(Resource.ResourceType type){
        List<Resource> resources = resourceRepo.findResourceByResourceType(type);
        return resources;
    };

    public List<Resource> getResourceByWorkingCondition(Resource.WorkingCondition condition){
        List<Resource> resources = resourceRepo.findResourceByWorkingCondition(condition);
        return resources;
    };

    public Resource createResource(Resource resource) throws Exception {

        if (getResourceByName(resource.getResourceName()) != null){
            throw new Exception("Resource with given name already exists");
        };
        return resourceRepo.save(resource);
    }


    public Resource addResource2(Resource resource){
        Room room = roomService.findRoomById(resource.getRoom().getId());
        resource.setRoom(room);
        return resourceRepo.save(resource);
    }


}