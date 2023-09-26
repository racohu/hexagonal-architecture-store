package es.racohu.hexagonal.store.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;

import es.racohu.hexagonal.store.domain.model.Price;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;

@Mapper
public interface PriceRestMapper {
	PriceQueryResponse toPriceQueryResponse(Price price);

}
