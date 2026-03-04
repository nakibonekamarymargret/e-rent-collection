package com.musenze.rentals.service;

import com.musenze.rentals.dtos.requests.PropertyRequestDTO;
import com.musenze.rentals.dtos.responses.PropertyResponseDTO;
import com.musenze.rentals.entity.Property;
import com.musenze.rentals.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
//    registering property
    public PropertyResponseDTO createProperty(PropertyRequestDTO propertyRequestDTO) {
        Property property = new Property();
        property.setName(propertyRequestDTO.getName());
        property.setLocation(propertyRequestDTO.getLocation());
        property.setDescription(propertyRequestDTO.getDescription());
        Property savedProperty = propertyRepository.save(property);
        return mapToResponse(savedProperty);
    }
//    returning /retrieving/listing properties
    public List<PropertyResponseDTO> getAllProperties(){
return propertyRepository.findAll()
        .stream()
        .map(this::mapToResponse)
        .collect(Collectors.toList());
    }
    private PropertyResponseDTO mapToResponse(Property property){
        PropertyResponseDTO dto = new PropertyResponseDTO();
        dto.setId(property.getId());
        dto.setName(property.getName());
        dto.setLocation(property.getLocation());
        return  dto;
    }
}
