package com.musenze.rentals.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name ="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double amountPaid;
    private String paymentMethod;
    private String transactionReference;
    @Column(name="payment_date")
    private LocalDate paymentDate;
//    for large texts above 255 use @Lob (large objects
    @Lob
    private String notes;
    @CreationTimestamp
    @Column(name="created_at",insertable = false,updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="invoice_id",nullable = false)
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name="collected_by",nullable = false)
    private Users collector;

    @OneToMany(mappedBy = "payment")
    private Set<Receipt> receipts;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Users getUser() {
        return collector;
    }

    public void setUser(Users collector) {
        this.collector = collector;
    }

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
    }
}
