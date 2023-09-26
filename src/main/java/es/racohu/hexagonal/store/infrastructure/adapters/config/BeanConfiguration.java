package es.racohu.hexagonal.store.infrastructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.racohu.hexagonal.store.application.services.PriceService;
import es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.PricePersistenceAdapter;
import es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.mapper.PricePersistenceMapper;
import es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.repository.PriceRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    public PricePersistenceAdapter pricePersistenceAdapter(PriceRepository priceRepository, PricePersistenceMapper pricePersistenceMapper) {
        return new PricePersistenceAdapter(priceRepository, pricePersistenceMapper);
    }

    @Bean
    public PriceService priceService(PricePersistenceAdapter pricePersistenceAdapter) {
        return new PriceService(pricePersistenceAdapter);
    }

}
