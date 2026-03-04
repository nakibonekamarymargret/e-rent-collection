package com.musenze.rentals.dtos.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvoiceResponseDTO {

    private Integer id;
    private LocalDate invoiceMonth;
    private LocalDate dueDate;
    private double amountDue;
    private String status;
    private LocalDateTime createdAt;

    private Integer leaseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getInvoiceMonth() {
        return invoiceMonth;
    }

    public void setInvoiceMonth(LocalDate invoiceMonth) {
        this.invoiceMonth = invoiceMonth;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Integer leaseId) {
        this.leaseId = leaseId;
    }
}