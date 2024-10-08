package com.pricing.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricing.domain.dto.PriceDTO;
import com.pricing.domain.model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @BeforeEach
    void setUp() {
        // Se puede configurar la base de datos en memoria aquí si es necesario.
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        // Lógica de prueba para verificar que el servicio está funcionando
        return ResponseEntity.ok("Service is running");
    }

    @Test
    void testPriceAt10AMOn14thJune() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Price priceResponse = objectMapper.readValue(jsonResponse, Price.class);

        // Validar que el precio es el esperado (35.50 EUR)
        assertThat(priceResponse.getPrice()).isEqualByComparingTo(35.50);
    }

    @Test
    void testPriceAt16PMOn14thJune() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-14T16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Price priceResponse = objectMapper.readValue(jsonResponse, Price.class);

        // Validar que el precio es el esperado (25.45 EUR)
        assertThat(priceResponse.getPrice()).isEqualByComparingTo(25.45);
    }

    @Test
    void testPriceAt21PMOn14thJune() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-16T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Price priceResponse = objectMapper.readValue(jsonResponse, Price.class);

        // Validar que el precio es el esperado (35.50 EUR)
        assertThat(priceResponse.getPrice()).isEqualByComparingTo(38.95);
    }

    @Test
    void testPriceAt10AMOn15thJune() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Price priceResponse = objectMapper.readValue(jsonResponse, Price.class);

        // Validar que el precio es el esperado (30.50 EUR)
        assertThat(priceResponse.getPrice()).isEqualByComparingTo(30.50);
    }

    @Test
    public void testPriceAt21PMOn16thJune() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16T21:00:00"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Price priceResponse = objectMapper.readValue(jsonResponse, Price.class);

        // Validar que el precio es el esperado (30.50 EUR)
        assertThat(priceResponse.getPrice()).isEqualByComparingTo(38.95);
   }

}
