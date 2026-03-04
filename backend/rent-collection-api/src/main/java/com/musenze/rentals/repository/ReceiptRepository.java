package com.musenze.rentals.repository;

import com.musenze.rentals.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt,Integer> {
}
