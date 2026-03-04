package com.musenze.rentals.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table( name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@Column(name="full_name",nullable = false)
    private String fullName;
    private String phone;
    private String email;
    private String username;
    private String password;
    @Column(name="is_active")
    private Boolean isActive =true;
    @Column(name="created_at",insertable = false,updatable = false)
    private LocalDateTime createdAt;

//    role relationship
    @ManyToMany
    @JoinTable(
            name ="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<AuditLog>auditLogs;

    @OneToMany(mappedBy = "collector")
    private Set<Payment> payments;
// getters and setters
    public Integer getId() {
        return id;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setRole(Set<Role> roles) {
        this.roles = roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Set<AuditLog> getAuditLogs() {
        return auditLogs;
    }

    public void setAuditLogs(Set<AuditLog> auditLogs) {
        this.auditLogs = auditLogs;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
