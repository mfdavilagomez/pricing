package com.pricing.infrastructure.adapter.in.web;

import com.pricing.application.service.PriceService;
import com.pricing.domain.dto.PriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam("date") LocalDateTime date,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
        PriceDTO priceDTO = priceService.getPrice(date, productId, brandId);
        return ResponseEntity.ok(priceDTO);
    }
}
