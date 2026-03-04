package com.musenze.rentals.controller;

import com.musenze.rentals.dtos.requests.PropertyRequestDTO;
import com.musenze.rentals.dtos.responses.PropertyResponseDTO;
import com.musenze.rentals.entity.Room;
import com.musenze.rentals.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
private final PropertyService propertyService;
public PropertyController(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

    @PostMapping
    public PropertyResponseDTO createProperty(@RequestBody PropertyRequestDTO propertyRequestDTO){
    return propertyService.createProperty(propertyRequestDTO);
    }
//    return/List rooms
    @GetMapping
    public List<PropertyResponseDTO> getProperties(){
    return propertyService.getAllProperties();
    }
}
