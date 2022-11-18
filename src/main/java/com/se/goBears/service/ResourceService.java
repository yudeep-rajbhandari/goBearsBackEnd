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

    public List<Resource> getAllResource(){
        List<Resource> allResources= resourceRepo.findAll();
        return allResources;
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

    public void createResource(){

    }

    public Resource createResource(Resource resource) throws Exception {

        if (getResourceByName(resource.getResourceName()) != null){
            throw new Exception("Resource with given name already exists");
        };
        return resourceRepo.save(resource);
    }

}
