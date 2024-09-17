package com.pricing.application.service;

import com.pricing.domain.dto.PriceDTO;
import com.pricing.domain.exception.ConflictException;
import com.pricing.domain.model.Price;
import com.pricing.domain.port.in.PriceQuery;
import com.pricing.domain.port.out.PriceRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService implements PriceQuery {

    private final PriceRepositoryPort priceRepositoryPort;

    public PriceService(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    /**
     * Obtiene el precio final de un producto basado en la fecha de aplicación, identificador de producto y cadena.
     *
     * @param date Fecha en la que se desea consultar el precio.
    * @param productId Identificador del producto.
     * @param brandId Identificador de la cadena.
     * @return PriceResponse con los detalles del precio aplicable.
     * @throws ConflictException Si el producto no existe.
     */

    @Override
    public PriceDTO getPrice(LocalDateTime date, Long productId, Long brandId) {
        Optional<Price> priceOpt = priceRepositoryPort.findApplicablePrice(
                productId, brandId, date, date);
        return priceOpt.map(this::toPriceDTO)
                .orElseThrow(() -> new ConflictException("No price found for the given parameters"));
    }

    private PriceDTO toPriceDTO(Price price) {
        PriceDTO dto = new PriceDTO();
        dto.setProductId(price.getProductId());
        dto.setBrandId(price.getBrandId());
        dto.setPriceList(price.getPriceList());
        dto.setStartDate(price.getStartDate());
        dto.setEndDate(price.getEndDate());
        dto.setPrice(price.getPrice());
        return dto;
    }
}
