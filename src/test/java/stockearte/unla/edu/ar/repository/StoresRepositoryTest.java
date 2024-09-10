package stockearte.unla.edu.ar.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class StoresRepositoryTest {
	
	@Autowired
	private StoresRepository repository;
	@Autowired
	private ProductsRepository productsRepository;

	@Test
	@Order(1)
	public void insert() {
		String code = "123asfe6678";
		String address = "Av. Entre Rios 331";
		String city = "Capital";
		String province = "Buenos Aires";
		boolean enabled = false;
		StoreModel storeModel = new StoreModel(code, address, city, province, enabled);
		repository.save(storeModel);
		assertNotNull(repository.findByCode(code));
	}
	@Test
	@Order(2)
	public void edit() {
		String code = "123asfe6678";
		String address = "Av. Entre Rios 444";
		StoreModel storeModel = repository.findByCode(code);
		storeModel.setAddress(address);
		repository.save(storeModel);
		assertEquals(repository.findByCode(code).getAddress(), address);
	}
	@Test
	@Order(3)
	public void delete() {
		String code = "123asfe6678";
		repository.delete(repository.findByCode(code));
		assertNull(repository.findByCode(code));
	}
	@Test
	public void creteStoreAssignedToProducts() {
		String code = "997asfe6678";
		String address = "Av. Entre Rios 331";
		String city = "Capital";
		String province = "Buenos Aires";
		boolean enabled = false;
		List<ProductModel> products = new ArrayList<ProductModel>();
		products.add(productsRepository.findByCode("30111000"));
		products.add(productsRepository.findByCode("30111001"));
		StoreModel storeModel = new StoreModel(code, address, city, province, enabled, products);
		repository.save(storeModel);
		assertNotNull(repository.findByCode(code));
	}
}