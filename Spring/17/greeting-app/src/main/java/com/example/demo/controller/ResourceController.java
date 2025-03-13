package com.example.demo.controller;

import com.example.demo.model.Resource;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public Resource getResourceById(@PathVariable("id") int id) {
        return resourceService.getResourceById(id);
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable("id") int id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok("Resource with ID " + id + " deleted successfully.");
    }

    //deliberately throws an unhandled exception, such as a NullPointerException
    @GetMapping("/error")
    public void throwError() {
        throw new NullPointerException("This is a simulated server error!");
    }

}
