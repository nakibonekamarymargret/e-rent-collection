package com.musenze.rentals.service;

import com.musenze.rentals.dtos.requests.LeaseRequestDTO;
import com.musenze.rentals.dtos.responses.LeaseResponseDTO;
import com.musenze.rentals.entity.Lease;
import com.musenze.rentals.entity.Room;
import com.musenze.rentals.entity.Tenant;
import com.musenze.rentals.repository.LeaseRepository;
import com.musenze.rentals.repository.RoomRepository;
import com.musenze.rentals.repository.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaseService {
    private final LeaseRepository leaseRepository;
    private final TenantRepository tenantRepository;
    private final RoomRepository roomRepository;
    public LeaseService(LeaseRepository leaseRepository, TenantRepository tenantRepository,RoomRepository roomRepository) {
        this.leaseRepository = leaseRepository;
        this.tenantRepository= tenantRepository;
        this.roomRepository = roomRepository;

    }

//    creating a lease
    public LeaseResponseDTO createLease(LeaseRequestDTO dto) {
         Tenant tenant = tenantRepository.findById(dto.getTenantId())
                 .orElseThrow(()-> new RuntimeException("Tenant not found"));
       Room room = roomRepository.findById(dto.getRoomId())
               .orElseThrow(()-> new RuntimeException("Room not found"));
        Lease lease = new Lease();
        lease.setStartDate(dto.getStartDate());
        lease.setEndDate(dto.getEndDate());
        lease.setTenant(tenant);
        lease.setRoom(room);
        lease.setRentAmount(dto.getRentAmount());
        lease.setStatus("ACTIVE");

//        saving
        Lease savedLease = leaseRepository.save(lease);
        savedLease = leaseRepository.findById(savedLease.getId()).get();
        return mapToResponse(savedLease);
    }
//    return lease
    public List<LeaseResponseDTO> getAllLease() {
        return  leaseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
     private LeaseResponseDTO mapToResponse(Lease lease){
        LeaseResponseDTO dto = new LeaseResponseDTO();
        dto.setId(lease.getId());
        dto.setTenantId(lease.getTenant().getId());
        dto.setRoomId(lease.getRoom().getId());
        dto.setStartDate(lease.getStartDate());
        dto.setEndDate(lease.getEndDate());
        dto.setRentAmount(lease.getRentAmount());
        dto.setStatus(lease.getStatus());
         dto.setCreatedAt(lease.getCreatedAt());
return dto;
     }
}
