package com.musenze.rentals.service;

import com.musenze.rentals.dtos.requests.RoomRequestDto;
import com.musenze.rentals.dtos.responses.RoomResponseDTO;
import com.musenze.rentals.entity.Property;
import com.musenze.rentals.entity.Room;
import com.musenze.rentals.repository.PropertyRepository;
import com.musenze.rentals.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final PropertyRepository propertyRepository;

    public RoomService(RoomRepository roomRepository, PropertyRepository propertyRepository) {
        this.roomRepository = roomRepository;
        this.propertyRepository = propertyRepository;
    }
//    create a room
    public RoomResponseDTO createRoom(RoomRequestDto request){
        Room room = new Room();
        room.setRoomNumber(request.getRoomNumber());
        room.setMonthlyRent(request.getMonthlyRent());
        room.setStatus(request.getStatus());
//Fetching property
        Property property =propertyRepository.findById(request.getPropertyId())
                .orElseThrow(()-> new RuntimeException("property not found"));

        room.setProperty(property);
        Room savedRoom =roomRepository.save(room);
        return mapToResponse(savedRoom);
    }
//Return/list rooms
    public List<RoomResponseDTO> getAllRooms(){
        return roomRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    private RoomResponseDTO mapToResponse(Room room){
        RoomResponseDTO dto = new RoomResponseDTO();
        dto.setId(room.getId());
        dto.setPropertyId(room.getProperty().getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setMonthlyRent(room.getMonthlyRent());
        dto.setStatus(room.getStatus());
        return dto;
    }

}
