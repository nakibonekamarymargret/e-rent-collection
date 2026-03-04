package com.musenze.rentals.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name ="leases")
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    private  LocalDate endDate;
    private BigDecimal rentAmount;
    private String status;
    @Column(name="created_at",insertable = false,updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="tenant_id",nullable = false)
    private Tenant tenant;
    @ManyToOne
    @JoinColumn(name="room_id",nullable = false)
    private Room room;

    @OneToMany(mappedBy = "lease")
    private Set<Invoice> invoices;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate( LocalDate startDate) {
        this.startDate = startDate;
    }

    public  LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate( LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
}
