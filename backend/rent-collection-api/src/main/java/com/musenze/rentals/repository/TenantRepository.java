package com.musenze.rentals.repository;

import com.musenze.rentals.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant,Integer> {
Optional<Tenant> findByFullName(String fullName);
}
