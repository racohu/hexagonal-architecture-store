package es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.racohu.hexagonal.store.infrastructure.adapters.output.persistence.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity>{
	
	public final static String GET_PRODUCT_PRICE_BY_DATE = "SELECT price FROM PriceEntity price WHERE startDate <= :date AND endDate >= :date AND productId = :productId AND brandId = :brandId ORDER BY priority DESC";

	@Query(GET_PRODUCT_PRICE_BY_DATE)
	List<PriceEntity> findByDate(@Param("date") ZonedDateTime date, @Param("productId") Long productId, @Param("brandId") Long brandId);
	
}
