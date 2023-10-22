package es.racohu.hexagonal.store.infrastructure.adapters.input.rest;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.racohu.hexagonal.store.application.usecases.GetPriceUseCase;
import es.racohu.hexagonal.store.domain.model.Price;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.response.ExceptionResponse;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.mapper.PriceRestMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@OpenAPIDefinition(
        info = @Info(
                title = "Hexagonal Store API",
                version = "1.0.0",
                description = "Information services for the Hexagonal Store"
        )
)
public class PriceRestAdapter {
	
	private final GetPriceUseCase getPriceUseCase;

    private final PriceRestMapper priceRestMapper;
    
    @Operation(summary = "Obtains the price of the product for a date")
    @Tag(name = "Price")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
      @ApiResponse(responseCode = "500", description = "Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping(value = "/price")
    public ResponseEntity<PriceQueryResponse> getPriceByDate(
    		@Parameter(name = "date", description = "date to filter the search", example = "2020-06-14T16:00:00.000+0200")
    		@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") ZonedDateTime date, 
    		@Parameter(name = "productId", description ="product id", example = "35455")
    		@RequestParam Long productId,
    		@Parameter(name = "brandId", description ="brand id", example = "1")
    		@RequestParam Long brandId){
        Price price = getPriceUseCase.getProductPriceByDate(date, productId, brandId);
        return new ResponseEntity<>(priceRestMapper.toPriceQueryResponse(price), HttpStatus.OK);
    }

}
