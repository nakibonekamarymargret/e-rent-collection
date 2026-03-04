package com.musenze.rentals.service;

import com.musenze.rentals.dtos.requests.TenantRequestDTO;
import com.musenze.rentals.dtos.responses.TenantResponseDTO;
import com.musenze.rentals.entity.Tenant;
import com.musenze.rentals.repository.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }
//    creating a tenant
    public TenantResponseDTO create(TenantRequestDTO tenantRequestDTO) {
        Tenant tenant = new Tenant();
        tenant.setTenantCode(tenantRequestDTO.getTenantCode());
        tenant.setFullName(tenantRequestDTO.getFullName());
        tenant.setNationalId(tenantRequestDTO.getNationalId());
        tenant.setPhone(tenantRequestDTO.getPhone());
        Tenant savedTenant = tenantRepository.save(tenant);
        return mapToResponse(savedTenant);
    }

    //    returning tenants
    public List<TenantResponseDTO> getAll(){
        return tenantRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    private TenantResponseDTO mapToResponse(Tenant tenant) {
        TenantResponseDTO dto = new TenantResponseDTO();
        dto.setId(tenant.getId());
        dto.setTenantCode(tenant.getTenantCode());
        dto.setFullName(tenant.getFullName());
        dto.setNationalId(tenant.getNationalId());
        dto.setPhone(tenant.getPhone());
        dto.setCreatedAt(tenant.getCreatedAt());
        return dto;
    }
}
