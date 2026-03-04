package com.musenze.rentals.controller;

import com.musenze.rentals.dtos.requests.ReceiptRequestDTO;
import com.musenze.rentals.dtos.requests.UserRequestDTO;
import com.musenze.rentals.dtos.responses.ReceiptResponseDTO;
import com.musenze.rentals.dtos.responses.UserResponseDTO;
import com.musenze.rentals.service.ReceiptService;
import com.musenze.rentals.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {
   private final ReceiptService receiptService;
   public ReceiptController(ReceiptService receiptService) {
       this.receiptService = receiptService;
   }
//   create receipt
    @PostMapping
    public ReceiptResponseDTO createReceipt(@RequestBody ReceiptRequestDTO receiptRequestDTO){
       return receiptService.createReceipt(receiptRequestDTO);
    }
//    return list
    @GetMapping
    public List<ReceiptResponseDTO> listReceipts() {
       return receiptService.listReceipts();
    }
}
