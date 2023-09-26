package es.racohu.hexagonal.store.infrastructure.adapters.input.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.racohu.hexagonal.store.application.port.input.GetPriceUseCase;
import es.racohu.hexagonal.store.domain.model.Price;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.request.PriceQueryRequest;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;
import es.racohu.hexagonal.store.infrastructure.adapters.input.rest.mapper.PriceRestMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class PriceRestAdapter {
	
	private final GetPriceUseCase getPriceUseCase;

    private final PriceRestMapper priceRestMapper;
    
    @GetMapping(value = "/price/search")
    public ResponseEntity<PriceQueryResponse> getPriceByDate(@RequestBody @Valid PriceQueryRequest priceQueryRequest){
        Price price = getPriceUseCase.getProductPriceByDate(priceQueryRequest.getDate(), priceQueryRequest.getProductId(), priceQueryRequest.getBrandId());
        return new ResponseEntity<>(priceRestMapper.toPriceQueryResponse(price), HttpStatus.OK);
    }

}
