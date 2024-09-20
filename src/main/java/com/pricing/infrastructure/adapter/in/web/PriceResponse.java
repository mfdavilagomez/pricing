package com.pricing.infrastructure.adapter.in.web;

import com.pricing.domain.dto.PriceDTO;

import java.time.LocalDateTime;

public class PriceResponse {
    private Long productId;
    private Long brandId;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Constructor para crear el DTO a partir de una entidad Price
    public PriceResponse(PriceDTO priceDTO) {
        this.productId = priceDTO.getProductId();
        this.brandId = priceDTO.getBrandId();
        this.price = priceDTO.getPrice();
        this.startDate = priceDTO.getStartDate();
        this.endDate = priceDTO.getEndDate();
    }

    // Getters y setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
