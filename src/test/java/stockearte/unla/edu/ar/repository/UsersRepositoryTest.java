package stockearte.unla.edu.ar.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import stockearte.unla.edu.ar.StockearteApp;
import stockearte.unla.edu.ar.repository.entity.StoreModel;
import stockearte.unla.edu.ar.repository.entity.UserModel;

@SpringBootTest(classes = StockearteApp.class)
@TestMethodOrder(OrderAnnotation.class)
public class UsersRepositoryTest {
	
	@Autowired
	private UsersRepository repository;
	@Autowired
	private StoresRepository storesRepository;

	@Test
	@Order(1)
	public void insert() {
		String username = "PSanchez3";
		String password = "1234pass";
		String firstName = "Pedro";
		String lastName = "Sanchez";
		boolean enabled = false;;
		UserModel userModel = new UserModel(username, password, firstName, lastName, enabled, null);
		repository.save(userModel);
		assertNotNull(repository.findByUsername(username));
	}
	@Test
	@Order(2)
	public void edit() {
		String username = "PSanchez1";
		String password = "4321pass";
		UserModel userModel = repository.findByUsername(username);
		userModel.setPassword(password);
		repository.save(userModel);
		assertNotNull(repository.findByUsername(username));
	}
	@Test
	@Order(3)
	public void delete() {
		String username = "PSanchez1";
		repository.delete(repository.findByUsername(username));
		assertNull(repository.findByUsername(username));
	}
	@Test
	public void creteUserAssignedToStore() {
		String username = "PSanchez2";
		String password = "1234pass";
		String firstName = "Pedro";
		String lastName = "Sanchez";
		String code = "654asfe6678";
		String address = "Av. Entre Rios 331";
		String city = "Capital";
		String province = "Buenos Aires";
		boolean enabled = false;
		StoreModel storeModel = new StoreModel(code, address, city, province, enabled, null);
		storesRepository.save(storeModel);
		UserModel userModel = new UserModel(username, password, firstName, lastName, enabled, storeModel);
		repository.save(userModel);
		assertNotNull(repository.findByUsername(username));
	}
	
}