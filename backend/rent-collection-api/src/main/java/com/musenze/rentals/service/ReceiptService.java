package com.musenze.rentals.service;

import com.musenze.rentals.dtos.requests.InvoiceRequestDTO;
import com.musenze.rentals.dtos.requests.ReceiptRequestDTO;
import com.musenze.rentals.dtos.responses.InvoiceResponseDTO;
import com.musenze.rentals.dtos.responses.ReceiptResponseDTO;
import com.musenze.rentals.entity.Invoice;
import com.musenze.rentals.entity.Lease;
import com.musenze.rentals.entity.Payment;
import com.musenze.rentals.entity.Receipt;
import com.musenze.rentals.repository.InvoiceRepository;
import com.musenze.rentals.repository.LeaseRepository;
import com.musenze.rentals.repository.PaymentRepository;
import com.musenze.rentals.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptService {
private final PaymentRepository paymentRepository;
private final ReceiptRepository receiptRepository;

public ReceiptService(PaymentRepository paymentRepository, ReceiptRepository receiptRepository) {
    this.paymentRepository = paymentRepository;
    this.receiptRepository = receiptRepository;
}
//generate/create receipt
    public ReceiptResponseDTO createReceipt(ReceiptRequestDTO receiptRequestDTO) {
    Payment payment = paymentRepository.findById(receiptRequestDTO.getPaymentId())
            .orElseThrow(()->new RuntimeException("No payment found"));
    Receipt receipt = new Receipt();
    receipt.setPayment(payment);
    receipt.setReceiptNumber(receiptRequestDTO.getReceiptNumber());
    Receipt savedReceipt = receiptRepository.save(receipt);
    return mapToResponse(savedReceipt);

    }
//list receipts
    public List<ReceiptResponseDTO> listReceipts() {
     return receiptRepository.findAll().stream()
             .map(this::mapToResponse).collect(Collectors.toList());
    }
    private ReceiptResponseDTO mapToResponse(Receipt receipt) {
        ReceiptResponseDTO dto = new ReceiptResponseDTO();
        dto.setId(receipt.getId());
        dto.setReceiptNumber(receipt.getReceiptNumber());
        dto.setPayment(receipt.getPayment().getId());
        dto.setIssuedAt(receipt.getIssuedAt());
        return dto;
    }
}