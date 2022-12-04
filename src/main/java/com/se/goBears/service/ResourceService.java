 package com.se.goBears.service;

import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import com.se.goBears.errors.CustomException;
import com.se.goBears.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepo;

    @Autowired
    private RoomService roomService;

    public List<Resource> getAllResource(){
        return  resourceRepo.findAll();

    }

    public  Resource getResourceByID(Long id){
        return resourceRepo.findResourceById(id);
    }

    public  Resource getResourceByName(String name){
        return  resourceRepo.findResourceByResourceName(name);

    }

    public List<Resource> getResourceByResourceType(Resource.ResourceType type){
        return  resourceRepo.findResourceByResourceType(type);
    }

    public List<Resource> getResourceByWorkingCondition(Resource.WorkingCondition condition){
        return resourceRepo.findResourceByWorkingCondition(condition);

    }

    public Resource createResource(Resource resource){

        if (getResourceByName(resource.getResourceName()) != null){
            throw new CustomException("Resource with given name already exists");
        }
        return resourceRepo.save(resource);
    }



    public Resource addResource2(Resource resource){
        Room room = roomService.findRoomById(resource.getRoom().getId());
        resource.setRoom(room);
        return resourceRepo.save(resource);
    }

    public List<Resource> getResourceByRoom(Long id){
        return resourceRepo.findAllByRoomOrderById(roomService.findRoomById(id));
    }


    public Integer getResourceCount(){
        return resourceRepo.findAll().size();
    }

    public String getResourceNameById(Long id){
        return resourceRepo.findResourceById(id).getResourceName();
    }


}
