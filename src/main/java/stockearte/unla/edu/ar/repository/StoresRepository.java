package stockearte.unla.edu.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stockearte.unla.edu.ar.repository.entity.StoreModel;

public interface StoresRepository extends JpaRepository<StoreModel, Long> {

	StoreModel findByCode(String code);
	
	StoreModel findByEnabled(boolean enabled);

	StoreModel findByCodeAndEnabled(String code, boolean enabled);

}