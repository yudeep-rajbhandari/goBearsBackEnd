package com.se.goBears.service;

import com.se.goBears.entity.Resource;
import com.se.goBears.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

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
}
