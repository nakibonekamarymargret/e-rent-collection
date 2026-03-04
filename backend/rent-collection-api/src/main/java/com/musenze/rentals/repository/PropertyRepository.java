package com.musenze.rentals.repository;

import com.musenze.rentals.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
Optional<Property> findByName(String name);
}
