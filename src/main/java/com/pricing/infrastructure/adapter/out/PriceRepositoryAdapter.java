package com.pricing.infrastructure.adapter.out;

import com.pricing.domain.model.Price;
import com.pricing.domain.port.out.PriceRepositoryPort;
import com.pricing.infrastructure.repository.PriceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJpaRepository priceJpaRepository;

    @Autowired
    public PriceRepositoryAdapter(PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }

    @Override
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        List<Price> prices = priceJpaRepository.findApplicablePrice(productId, brandId, applicationDate);
        return prices.stream().findFirst(); // Esto garantiza que devuelvas solo el primer resultado
    }
}

