package com.musenze.rentals.service;

import com.musenze.rentals.dtos.requests.PaymentRequestDTO;
import com.musenze.rentals.dtos.responses.PaymentResponseDTO;
import com.musenze.rentals.entity.Invoice;
import com.musenze.rentals.entity.Payment;
import com.musenze.rentals.entity.Users;
import com.musenze.rentals.repository.InvoiceRepository;
import com.musenze.rentals.repository.PaymentRepository;
import com.musenze.rentals.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final InvoiceRepository invoiceRepository;
    public PaymentService(PaymentRepository paymentRepository, UserRepository userRepository, InvoiceRepository invoiceRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.invoiceRepository = invoiceRepository;
    }

//    create payment
    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        Users user = userRepository.findById(paymentRequestDTO.getCollectorId())
                .orElseThrow(()-> new RuntimeException("User not fouund"));
        Invoice invoice = invoiceRepository.findById(paymentRequestDTO.getInvoiceId())
                .orElseThrow(()-> new RuntimeException("No invoice found"));
        Payment payment = new Payment();
        payment.setAmountPaid(paymentRequestDTO.getAmountPaid());
        payment.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
        payment.setTransactionReference(paymentRequestDTO.getTransactionReference());
        payment.setNotes(paymentRequestDTO.getNotes());
        payment.setPaymentDate(paymentRequestDTO.getPaymentDate());
        payment.setUser(user);
        payment.setInvoice(invoice);
       Payment savedPayment = paymentRepository.save(payment);
       savedPayment = paymentRepository.findById(savedPayment.getId()).get();
       return mapToResponse(savedPayment);
    }

//    list invoices
    public List<PaymentResponseDTO> getAllPayments(){
        return paymentRepository.findAll()
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }
    private PaymentResponseDTO mapToResponse(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(payment.getId());
        dto.setAmountPaid(payment.getAmountPaid());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setTransactionReference(payment.getTransactionReference());
        dto.setNotes(payment.getNotes());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setCollectorId(payment.getUser().getId());
        dto.setInvoiceId(payment.getInvoice().getId());
        return dto;
    }
}
