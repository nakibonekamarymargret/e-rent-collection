package com.musenze.rentals.controller;

import com.musenze.rentals.dtos.requests.LeaseRequestDTO;
import com.musenze.rentals.dtos.responses.LeaseResponseDTO;
import com.musenze.rentals.service.LeaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lease")
public class LeaseController {
    private final LeaseService leaseService;

    public LeaseController(LeaseService leaseService) {
        this.leaseService = leaseService;
    }
//    creating a lease
    @PostMapping
    public LeaseResponseDTO createLease(@RequestBody LeaseRequestDTO leaseRequestDTO){
        return leaseService.createLease(leaseRequestDTO);
    }
//    Return lease
    @GetMapping
    public List<LeaseResponseDTO> getLeases(){
        return leaseService.getAllLease();
    }
}
