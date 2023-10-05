package es.racohu.hexagonal.store.application.services;

import java.time.ZonedDateTime;

import es.racohu.hexagonal.store.application.port.output.PricePersistence;
import es.racohu.hexagonal.store.application.usecases.GetPriceUseCase;
import es.racohu.hexagonal.store.domain.exception.PriceNotFound;
import es.racohu.hexagonal.store.domain.model.Price;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PriceService implements GetPriceUseCase {

	private final PricePersistence pricePersistence;
	
	@Override
	public Price getProductPriceByDate(ZonedDateTime date, Long productId, Long brandId) {
		return pricePersistence.getProductPriceByDate(date, productId, brandId).orElseThrow(() -> new PriceNotFound("Price not found with date: " + date + ", productId: " + productId + ", brandId: " + brandId));
	}

}
