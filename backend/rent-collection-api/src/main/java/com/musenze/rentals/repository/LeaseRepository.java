package com.musenze.rentals.repository;

import com.musenze.rentals.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends JpaRepository<Lease,Integer> {
}
