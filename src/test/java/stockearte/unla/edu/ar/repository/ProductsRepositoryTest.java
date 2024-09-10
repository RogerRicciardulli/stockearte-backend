package stockearte.unla.edu.ar.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import stockearte.unla.edu.ar.StockearteApp;
import stockearte.unla.edu.ar.repository.entity.ProductModel;
import stockearte.unla.edu.ar.repository.entity.StoreModel;

@SpringBootTest(classes = StockearteApp.class)
@TestMethodOrder(OrderAnnotation.class)
public class ProductsRepositoryTest {
	
	@Autowired
	private ProductsRepository repository;
	@Autowired
	private StoresRepository storesRepository;
	
	@Test     
	@Order(1)
	void insert() {
		String code = "30111000";
		String name = "Remera Nike";
		String size = "42";
		String color = "Rojo";
		String photo = "Not Found.jpg";
		ProductModel productModel = new ProductModel(code, name, size, color, photo,
				null);
		repository.save(productModel);
		assertNotNull(repository.findByCode(code));
	}
	@Test
	@Order(2)
	void edit() {
		String code = "30111000";
		String name = "Remera Puma";
		ProductModel productModel = repository.findByCode(code);
		productModel.setName(name);
		repository.save(productModel);
		assertNotNull(repository.findByName(name));
	}
	@Test
	@Order(3)
	void delete() {
		repository.delete(repository.findByCode("30111000"));
		assertNull(repository.findByCode("30111000"));
	}
	@Test
	@Order(4)
	public void creteProductAssignedToStore() {
		String code = "30111008";
		String name = "Remera Nike";
		String size = "42";
		String color = "Rojo";
		String photo = "Not Found.jpg";
		List<StoreModel> stores = new ArrayList<StoreModel>();
		stores.add(storesRepository.findByCode("123asfe6678"));
		stores.add(storesRepository.findByCode("654asfe6678"));
		ProductModel productModel = new ProductModel(code, name, size, color, photo,
				stores);
		repository.save(productModel);
		assertNotNull(repository.findByCode(code));
	}
}