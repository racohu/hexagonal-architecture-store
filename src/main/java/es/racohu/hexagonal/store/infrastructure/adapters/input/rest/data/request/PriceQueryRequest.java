package es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.request;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class PriceQueryRequest {
	@NotNull(message = "Date may not be empty")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime date;

	@NotNull(message = "ProductId may not be null")
    private Long productId;
    
    @NotNull(message = "BrandId may not be null")
    private Long brandId;
}
