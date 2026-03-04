package com.musenze.rentals.service;

import com.musenze.rentals.dtos.requests.UserRequestDTO;
import com.musenze.rentals.dtos.responses.UserResponseDTO;
import com.musenze.rentals.entity.Role;
import com.musenze.rentals.entity.Users;
import com.musenze.rentals.repository.RoleRepository;
import com.musenze.rentals.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserService(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO request){
        Users user = new Users();
        user.setFullName(request.getFullName());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        Role role = roleRepository.findByName(request.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(Set.of(role));

        Users savedUser =userRepository.save(user);
        return  mapToResponse(savedUser);
    }
    public List<UserResponseDTO> getAllUsers(){
        return  userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    private UserResponseDTO mapToResponse(Users user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setActive(user.getIsActive());
        dto.setCreatedAt(user.getCreatedAt());

        return  dto;
    }
}
