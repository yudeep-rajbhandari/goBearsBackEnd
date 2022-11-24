package com.se.goBears.controller;

import com.se.goBears.entity.Error;
import com.se.goBears.entity.Resource;
import com.se.goBears.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
@CrossOrigin(origins = "http://localhost:3000")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/addResource")
    public ResponseEntity createResource(@RequestBody Resource resource){
        try {
            Resource resource1 = resourceService.createResource(resource);
            return new ResponseEntity<>(resource1, HttpStatus.OK);
        }
        catch (Exception e){
            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addResource2")
    public Resource addResource2(@RequestBody Resource resource){
        return resourceService.addResource2(resource);
    }

    @GetMapping("/getAllResource")
    public List<Resource> getAllResource(){
        return resourceService.getAllResource();
    }


}