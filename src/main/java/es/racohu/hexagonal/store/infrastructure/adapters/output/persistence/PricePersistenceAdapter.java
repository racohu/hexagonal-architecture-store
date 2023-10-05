package es.racohu.hexagonal.store.infrastructure.adapters.output.persistence;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import es.racohu.hexagonal.store.application.port.output.PricePersistence;
import es.racohu.hexagonal.store.domain.model.Price;
import es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.entity.PriceEntity;
import es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.mapper.PricePersistenceMapper;
import es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PricePersistenceAdapter implements PricePersistence{
	
	private final PriceRepository priceRepository;
	
	private final PricePersistenceMapper pricePersistenceMapper;

	@Override
	public Optional<Price> getProductPriceByDate(ZonedDateTime date, Long productId, Long brandId) {
		List<PriceEntity> priceEntity = priceRepository.findByDate(date, productId, brandId);

        if(priceEntity.isEmpty()) {
            return Optional.empty();
        }

        //If there are several possible prices, we will choose the first one, which is the highest priority.
        Price price = pricePersistenceMapper.toPrice(priceEntity.get(0));
        return Optional.of(price);
	}

}
