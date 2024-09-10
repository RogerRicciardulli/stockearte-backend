package stockearte.unla.edu.ar.repository;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import stockearte.unla.edu.ar.StockearteApp;
import stockearte.unla.edu.ar.repository.entity.ProductModel;
import stockearte.unla.edu.ar.repository.entity.StockModel;

@SpringBootTest(classes = StockearteApp.class)
@TestMethodOrder(OrderAnnotation.class)
public class StockRepositoryTest {
	
	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private StoresRepository storesRepository;
	@Autowired
	private StockRepository repository;

	@Test     
	@Order(1)
	void insert() {
		ProductModel productModel1 = productsRepository.findByCode("30111000");
		ProductModel productModel2 = productsRepository.findByCode("30111001");
		StockModel stock1 = new StockModel(storesRepository.findByCode("123asfe6678"), productModel1, 10);
		StockModel stock2 = new StockModel(storesRepository.findByCode("654asfe6678"), productModel2, 15);
		StockModel stock3 = new StockModel(storesRepository.findByCode("123asfe6678"), productModel2, 10);
		StockModel stock4 = new StockModel(storesRepository.findByCode("654asfe6678"), productModel1, 15);
		repository.save(stock1);
		repository.save(stock2);
		repository.save(stock3);
		repository.save(stock4);
		assertNotNull(repository.findByProductId(productModel1.getId()));
		assertNotNull(repository.findByProductId(productModel2.getId()));
	}

}