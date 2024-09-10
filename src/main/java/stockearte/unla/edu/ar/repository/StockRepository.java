package stockearte.unla.edu.ar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stockearte.unla.edu.ar.repository.entity.StockModel;


public interface StockRepository extends JpaRepository<StockModel, Long> {

	List<StockModel> findByProductId(Long productId);

	List<StockModel> findByStoreId(Long storeId);
	
	StockModel findByProductIdAndStoreId(Long productId, Long storeId);

}