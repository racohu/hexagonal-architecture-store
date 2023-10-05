package es.racohu.hexagonal.store.application.port.output;

import java.time.ZonedDateTime;
import java.util.Optional;

import es.racohu.hexagonal.store.domain.model.Price;

public interface PricePersistence {
	Optional<Price> getProductPriceByDate(ZonedDateTime date, Long productId, Long brandId);
}
