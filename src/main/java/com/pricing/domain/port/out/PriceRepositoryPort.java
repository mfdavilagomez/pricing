package com.pricing.domain.port.out;

import com.pricing.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate);
}


