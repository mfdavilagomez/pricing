package com.pricing.infrastructure.adapter.out;

import com.pricing.domain.model.Price;
import com.pricing.domain.port.out.PriceRepositoryPort;
import com.pricing.infrastructure.repository.PriceJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJpaRepository priceJpaRepository;

    public PriceRepositoryAdapter(PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }

    @Override
    public Optional<Price> findApplicablePrice(
            Long productId, Long brandId, LocalDateTime applicationDate) {
        return priceJpaRepository.findApplicablePrice(productId, brandId, applicationDate);
    }

}
