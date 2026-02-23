package com.musenze.rentals.repository;

import com.musenze.rentals.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<Users,Integer> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String  email);
}
