package com.musenze.rentals.controller;

import com.musenze.rentals.dtos.requests.RoomRequestDto;
import com.musenze.rentals.dtos.responses.RoomResponseDTO;
import com.musenze.rentals.entity.Room;
import com.musenze.rentals.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
public class RoomController {
    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
//    create room
    @PostMapping
    public RoomResponseDTO createRoom(@RequestBody RoomRequestDto roomRequestDTO){
        return roomService.createRoom(roomRequestDTO);
    }
//    list rooms
    @GetMapping
    public List<RoomResponseDTO> getAllRooms(){
        return roomService.getAllRooms();
    }
}
