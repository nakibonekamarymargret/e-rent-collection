package com.musenze.rentals.repository;

import com.musenze.rentals.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
Optional<Room> findByRoomNumber(String roomNumber);
}
