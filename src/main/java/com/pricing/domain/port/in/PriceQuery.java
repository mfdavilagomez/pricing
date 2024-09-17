package com.pricing.domain.port.in;

import com.pricing.domain.dto.PriceDTO;
import java.time.LocalDateTime;

public interface PriceQuery {
    PriceDTO getPrice(LocalDateTime date, Long productId, Long brandId);
}
