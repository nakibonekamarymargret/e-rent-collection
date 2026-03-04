package com.musenze.rentals.controller;

import com.musenze.rentals.dtos.requests.TenantRequestDTO;
import com.musenze.rentals.dtos.responses.TenantResponseDTO;
import com.musenze.rentals.service.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    private final TenantService tenantService;
    public TenantController(TenantService tenantService) {
       this.tenantService = tenantService;
    }
    @PostMapping
    public TenantResponseDTO createTenant(@RequestBody TenantRequestDTO tenantRequestDTO){
        return tenantService.create(tenantRequestDTO);
    }

    @GetMapping
    public List<TenantResponseDTO> getAllTenants(){
        return tenantService.getAll();
    }

}
