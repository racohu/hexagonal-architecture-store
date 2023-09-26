package es.racohu.hexagonal.store.domain.model;

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
public class Price {

	private Long brandId;

	private ZonedDateTime startDate;

	private ZonedDateTime endDate;

	private Long priceList;

	private Long productId;

	private Long priority;

	private Double price;

	private String currency;

}
