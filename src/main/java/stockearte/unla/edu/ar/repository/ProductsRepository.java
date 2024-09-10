package stockearte.unla.edu.ar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stockearte.unla.edu.ar.repository.entity.ProductModel;

public interface ProductsRepository extends JpaRepository<ProductModel, Long> {

	ProductModel findByCode(String code);

	List<ProductModel> findByName(String name);

	List<ProductModel> findBySize(String size);
	
	List<ProductModel> findByColor(String color);

}