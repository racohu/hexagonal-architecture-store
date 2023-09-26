package es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;

import es.racohu.hexagonal.store.domain.model.Price;
import es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.entity.PriceEntity;

@Mapper
public interface PricePersistenceMapper {

	PriceEntity toPriceEntity(Price price);
	
	Price toPrice(PriceEntity priceEntity);
}
