package com.pricing.infrastructure.repository;

import com.pricing.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceJpaRepository extends JpaRepository<Price, Long> {
    Optional<Price> findApplicablePrice(
            Long productId, Long brandId, LocalDateTime startDate, LocalDateTime endDate);

}
