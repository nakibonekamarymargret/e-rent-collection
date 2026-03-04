package com.musenze.rentals.dtos.requests;

import java.time.LocalDate;

public class InvoiceRequestDTO {

    private LocalDate invoiceMonth;
    private LocalDate dueDate;
    private double amountDue;

    private Integer leaseId;

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

    public Integer getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Integer leaseId) {
        this.leaseId = leaseId;
    }
}