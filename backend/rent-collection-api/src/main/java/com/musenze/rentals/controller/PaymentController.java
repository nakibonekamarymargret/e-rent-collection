package com.musenze.rentals.controller;

import com.musenze.rentals.dtos.requests.PaymentRequestDTO;
import com.musenze.rentals.dtos.responses.PaymentResponseDTO;
import com.musenze.rentals.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //    Create payment
    @PostMapping
    public PaymentResponseDTO create(@RequestBody PaymentRequestDTO paymentRequestDTO){
        return paymentService.createPayment(paymentRequestDTO);
    }
    //    list payments
    @GetMapping
    public List<PaymentResponseDTO> getPayments(){
        return paymentService.getAllPayments();
    }
}
