package es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PRICE")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {

	@Column(name="BRAND_ID")
	private Long brandId;

	@Column(name="START_DATE")
	private ZonedDateTime startDate;

	@Column(name="END_DATE")
	private ZonedDateTime endDate;

	@Id
	@Column(name="PRICE_LIST")
	private Long priceList;

	@Column(name="PRODUCT_ID")
	private Long productId;

	@Column(name="PRIORITY")
	private Long priority;

	@Column(name="PRICE")
	private Double price;

	@Column(name="CURR")
	private String currency;

}
