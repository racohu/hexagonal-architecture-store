package es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.response;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceQueryResponse {
	
	private Long brandId;

	private ZonedDateTime startDate;

	private ZonedDateTime endDate;

	private Long priceList;

	private Long productId;

	private Double price;

	private String currency;

}
