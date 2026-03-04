package com.musenze.rentals.controller;

import com.musenze.rentals.dtos.requests.InvoiceRequestDTO;
import com.musenze.rentals.dtos.responses.InvoiceResponseDTO;
import com.musenze.rentals.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public InvoiceResponseDTO createInvoice(@RequestBody InvoiceRequestDTO dto) {
        return invoiceService.createInvoice(dto);
    }

    @GetMapping
    public List<InvoiceResponseDTO> getAll() {
        return invoiceService.getAllInvoices();
    }
}