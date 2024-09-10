package stockearte.unla.edu.ar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stockearte.unla.edu.ar.repository.entity.StoreModel;
import stockearte.unla.edu.ar.repository.entity.UserModel;

public interface UsersRepository extends JpaRepository<UserModel, Long> {

	UserModel findByUsername(String username);

	List<UserModel> findByStore(StoreModel store);
	
	UserModel findByUsernameAndStore(String username, StoreModel store);

}