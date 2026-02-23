package com.musenze.rentals.controller;

import com.musenze.rentals.dtos.requests.UserRequestDTO;
import com.musenze.rentals.dtos.responses.UserResponseDTO;
import com.musenze.rentals.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO request){
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        return  userService.getAllUsers();
    }

}
