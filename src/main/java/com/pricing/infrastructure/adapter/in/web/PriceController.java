package com.pricing.infrastructure.adapter.in.web;

import com.pricing.application.service.PriceService;
import com.pricing.domain.dto.PriceDTO;
import com.pricing.domain.exception.DataConflictException;
import com.pricing.infrastructure.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/prices")
    public ResponseEntity<String> getPrice(@RequestParam Long brandId,
                                           @RequestParam Long productId,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {
        try {
            PriceDTO priceDTO = priceService.getPrice(applicationDate, productId, brandId);
            PriceResponse response = new PriceResponse(priceDTO);
            String jsonResponse = JsonUtil.convertToJson(response); // Usa el método aquí
            return ResponseEntity.ok(jsonResponse);
        } catch (DataConflictException e) { // Suponiendo que tienes una excepción específica
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace(); // O usa un logger para registrar el error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + e.getMessage());
        }

    }
}

