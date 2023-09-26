package es.racohu.hexagonal.store.infrastructure.adapters.input.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.racohu.hexagonal.store.application.port.input.GetPriceUseCase;
import es.racohu.hexagonal.store.domain.model.Price;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.request.PriceQueryRequest;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.mapper.PriceRestMapper;
import es.racohu.hexagonal.store.infrastructure.adapters.output.exception.data.response.ExceptionResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
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
    @PostMapping(value = "/price/search")
    public ResponseEntity<PriceQueryResponse> getPriceByDate(@RequestBody @Valid PriceQueryRequest priceQueryRequest){
        Price price = getPriceUseCase.getProductPriceByDate(priceQueryRequest.getDate(), priceQueryRequest.getProductId(), priceQueryRequest.getBrandId());
        return new ResponseEntity<>(priceRestMapper.toPriceQueryResponse(price), HttpStatus.OK);
    }

}
