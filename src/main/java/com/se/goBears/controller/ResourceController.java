package com.se.goBears.controller;

import com.se.goBears.entity.Error;
import com.se.goBears.entity.Resource;
import com.se.goBears.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller class handles all the API request for resource like resource creation and resource details.
 */
@RestController
@RequestMapping("/api/resource")
@CrossOrigin(origins = "*")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


//    @PostMapping("/addResource")
//    public ResponseEntity createResource(@RequestBody Resource resource){
//        try {
//            Resource resource1 = resourceService.createResource(resource);
//            return new ResponseEntity<>(resource1, HttpStatus.OK);
//        }
//        catch (Exception e){
//            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
//            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//        }
//    }

    /**
     * This method takes a resource body as an input and handles the creation of the resource.
     *
     * @param resource is the resource object to be created.
     * @return the resource object created.
     */
    @PostMapping("/addResource2")
    public Resource addResource2(@RequestBody Resource resource) {
        return resourceService.addResource2(resource);
    }

    /**
     * This method returns a detailed list of all resources.
     *
     * @return a list of all resources
     */
    @GetMapping("/getAllResource")
    public List<Resource> getAllResource() {
        return resourceService.getAllResource();
    }

    /**
     * This method returns a count of all resources.
     *
     * @return an integer count of all resources.
     */
    @GetMapping("/getResourceCount")
    public Integer getResourceCount() {
        return resourceService.getResourceCount();
    }


    /**
     * This method takes a room id as an input and returns all the resources associated with the room.
     *
     * @param roomId is the id of the room.
     * @return a list of resource associated with the room
     */
    @GetMapping("/getResourceByRoom/{roomId}")
    public List<Resource> getResourceByRoom(@PathVariable Long roomId) {
        return resourceService.getResourceByRoom(roomId);
    }
}
