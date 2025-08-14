package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class PortfolioSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @ManyToOne(optional = true)
    @JoinColumn(name = "created_by_advisor_id")
    private FinancialAdvisor createdByAdvisor;

    @ManyToOne(optional = true)
    @JoinColumn(name = "updated_by_advisor_id")
    private FinancialAdvisor updatedByAdvisor;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal purchasePrice;

    @Column(nullable = false, precision = 18, scale = 6)
    private BigDecimal quantity;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected PortfolioSecurity() {}

    public PortfolioSecurity(Portfolio portfolio, Security security, LocalDate purchaseDate, BigDecimal purchasePrice, BigDecimal quantity) {
        this.portfolio = portfolio;
        this.security = security;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public FinancialAdvisor getCreatedByAdvisor() {
        return createdByAdvisor;
    }
    public void setCreatedByAdvisor(FinancialAdvisor createdByAdvisor) {
        this.createdByAdvisor = createdByAdvisor;
    }

    public FinancialAdvisor getUpdatedByAdvisor() {
        return updatedByAdvisor;
    }
    public void setUpdatedByAdvisor(FinancialAdvisor updatedByAdvisor) {
        this.updatedByAdvisor = updatedByAdvisor;
    }
}
