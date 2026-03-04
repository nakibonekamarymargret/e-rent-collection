package com.musenze.rentals.service;

import com.musenze.rentals.dtos.requests.InvoiceRequestDTO;
import com.musenze.rentals.dtos.responses.InvoiceResponseDTO;
import com.musenze.rentals.entity.Invoice;
import com.musenze.rentals.entity.Lease;
import com.musenze.rentals.repository.InvoiceRepository;
import com.musenze.rentals.repository.LeaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final LeaseRepository leaseRepository;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          LeaseRepository leaseRepository) {
        this.invoiceRepository = invoiceRepository;
        this.leaseRepository = leaseRepository;
    }

    public InvoiceResponseDTO createInvoice(InvoiceRequestDTO dto) {

        Lease lease = leaseRepository.findById(dto.getLeaseId())
                .orElseThrow(() -> new RuntimeException("Lease not found"));

        Invoice invoice = new Invoice();
        invoice.setInvoiceMonth(dto.getInvoiceMonth());
        invoice.setDueDate(dto.getDueDate());
        invoice.setAmountDue(dto.getAmountDue());
        invoice.setStatus("PENDING");
        invoice.setLease(lease);

        Invoice saved = invoiceRepository.save(invoice);

        return mapToResponse(saved);
    }

    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private InvoiceResponseDTO mapToResponse(Invoice invoice) {
        InvoiceResponseDTO dto = new InvoiceResponseDTO();
        dto.setId(invoice.getId());
        dto.setInvoiceMonth(invoice.getInvoiceMonth());
        dto.setDueDate(invoice.getDueDate());
        dto.setAmountDue(invoice.getAmountDue());
        dto.setStatus(invoice.getStatus());
        dto.setCreatedAt(invoice.getCreatedAt());
        dto.setLeaseId(invoice.getLease().getId());
        return dto;
    }
}