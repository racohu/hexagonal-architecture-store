package es.racohu.hexagonal.store.application.port.input;

import java.time.ZonedDateTime;

import es.racohu.hexagonal.store.domain.model.Price;

public interface GetPriceUseCase {
	Price getProductPriceByDate(ZonedDateTime date, Long productId, Long brandId);
}
