package com.example.demo.service;

import com.example.demo.model.Resource;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface ResourceService {

    List<Resource> getAllResources();

    Resource getResourceById(int id);

    Resource createResource(Resource resource);

    void deleteResource(int id);
}
