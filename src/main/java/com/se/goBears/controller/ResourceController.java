package com.se.goBears.controller;

import com.se.goBears.entity.Resource;
import com.se.goBears.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
@CrossOrigin(origins = "*")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

//    @PostMapping("/addResource")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity createResource(@RequestBody Resource resource) {
//        try {
//            Resource resource1 = resourceService.createResource(resource);
//            return new ResponseEntity<>(resource1, HttpStatus.OK);
//        } catch (Exception e) {
//            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
//            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/addResource2")
    @PreAuthorize("hasRole('ADMIN')")
    public Resource addResource2(@RequestBody Resource resource) {
        return resourceService.addResource2(resource);
    }

    @GetMapping("/getAllResource")
    public List<Resource> getAllResource() {
        return resourceService.getAllResource();
    }

    @GetMapping("/getResourceCount")
    public Integer getResourceCount() {
        return resourceService.getResourceCount();
    }

    @GetMapping("/getResourceByRoom/{roomId}")
    public List<Resource> getResourceByRoom(@PathVariable Long roomId) {
        return resourceService.getResourceByRoom(roomId);
    }

    @GetMapping("/getResourceById/{roomId}")
    public Resource getResourceById(@PathVariable Long roomId) {
        return resourceService.getResourceByID(roomId);
    }

    @GetMapping("/getResourceNameById/{id}")
    public String getResourceNameById(@RequestParam Long id) {
        return resourceService.getResourceNameById(id);
    }
}
