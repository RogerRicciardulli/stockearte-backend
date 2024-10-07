package com.unla.stockearte.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.ByteString;
import com.unla.stockearte.CreateProductResponse;
import com.unla.stockearte.DeleteProductResponse;
import com.unla.stockearte.EditProductResponse;
import com.unla.stockearte.FilterProductResponse;
import com.unla.stockearte.GetDetailProductResponse;
import com.unla.stockearte.Product;
import com.unla.stockearte.repository.ProductsRepository;
import com.unla.stockearte.repository.StoresRepository;
import com.unla.stockearte.repository.entity.ProductModel;
import com.unla.stockearte.repository.entity.StoreModel;
import com.unla.stockearte.utils.RandomString;

@Service
public class ProductServiceLogic {
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceLogic.class);
    @Autowired
    private ProductsRepository repository;
    
    @Autowired
    private StoresRepository storeRepository;
    
    public CreateProductResponse saveProduct(String nombre, String talle, String foto, String color, int stock, List<Long> tiendas) {
    	List<StoreModel> listStore = new ArrayList<StoreModel>();
    	
    	for(Long idTienda: tiendas) {
    		Optional<StoreModel> storeModel = storeRepository.findById(idTienda);
    		if(storeModel.isPresent()) {
    			listStore.add(storeModel.get());
    		}
    	}
    	
    	String code = RandomString.getAlphaNumericString(10);
    	
    	ProductModel product = new ProductModel(code, nombre, talle, 0, color, "FOTO", listStore);
    	product.setHabilitado(true);
		repository.save(product);
		
		CreateProductResponse.Builder response = CreateProductResponse.newBuilder();
		response.setSuccess(true);
		return response.build();
    }
    
    public EditProductResponse editProduct(long id, String nombre, String talle, String foto, String color, int stock, List<Long> tiendas) {
    	List<StoreModel> listStore = new ArrayList<StoreModel>();
    	
    	for(Long idTienda: tiendas) {
    		Optional<StoreModel> storeModel = storeRepository.findById(idTienda);
    		if(storeModel.isPresent()) {
    			listStore.add(storeModel.get());
    		}
    	}
    	
    	Optional<ProductModel> product = repository.findById(id);
    	EditProductResponse.Builder response = EditProductResponse.newBuilder();
    	
    	if(product.isPresent()) {
    		product.get().setTalle(talle);
    		product.get().setColor(color);
    		product.get().setName(nombre);
    		product.get().setPhoto(foto);
    		product.get().setStock(stock);
    		product.get().setStores(listStore);
    		product.get().setHabilitado(true);
    		
    		repository.save(product.get());
    		
    		response.setSuccess(true);
    		return response.build();
    	}
    	response.setSuccess(false);
    	return response.build();
    }
    
    public DeleteProductResponse deleteProduct(int id) {
    	Optional<ProductModel> product = repository.findById((long) id);
    	DeleteProductResponse.Builder response = DeleteProductResponse.newBuilder();
    	if(product.isPresent()) {
    		product.get().setHabilitado(false);
    		repository.save(product.get());
    		response.setSuccess(true);
    		return response.build();
    	}
    	response.setSuccess(false);
    	return response.build();
    }
    
    public FilterProductResponse getListByFilterProduct(String color, String nombre, String talle, boolean habilitado) {
    	FilterProductResponse.Builder response = FilterProductResponse.newBuilder();
    	if(!color.isEmpty()) {
    		List<Product> productList = generateList((List<ProductModel>) repository.findByColor(color));
    		response.addAllProduct(productList);
    	} else if(!nombre.isEmpty()) {
    		List<Product> productList = generateList((List<ProductModel>) repository.findByName(nombre));
    		response.addAllProduct(productList);
    	} else if(!talle.isEmpty()) {
    		List<Product> productList = generateList((List<ProductModel>) repository.findByTalle(talle));
    		response.addAllProduct(productList);
    	} else if (habilitado) {
    		List<Product> productList = generateList((List<ProductModel>) repository.findAll());
    		response.addAllProduct(productList);
    	} 
    	return response.build();
    }
    
    public List<Product> generateList(List<ProductModel> productList) {
    	List<Product> productMiddList = new ArrayList<>();
    	for(ProductModel product: productList) {
			Product product2 = Product.newBuilder()
					.setCodigo(product.getCode())
					.setColor(product.getColor())
					.setFoto(product.getPhoto())
					.setId(product.getId().intValue())
					.setNombre(product.getName())
					.setStock(product.getStock())
					.setTalle(product.getTalle())
					.build();
			productMiddList.add(product2);
		}
    	return productMiddList;
    }
    
    public GetDetailProductResponse getDetailProduct(long id, String tipoUsuario, int stock, String nombre, String talle, ByteString foto, String color) {
    	GetDetailProductResponse.Builder response = GetDetailProductResponse.newBuilder();
    	
    	Optional<ProductModel> product = repository.findById(id);
    	
    	if(tipoUsuario.equalsIgnoreCase("tienda")) {
    		if(product.isPresent()) {
    			product.get().setStock(stock);
    			repository.save(product.get());
    		}
    	} else {
    		product.get().setStock(stock);
    		product.get().setName(nombre);
    		product.get().setTalle(talle);
    		product.get().setColor(color);
    		repository.save(product.get());
    	}
    	
    	Product product2 = Product.newBuilder()
    			.setColor(product.get().getColor())
				.setFoto(product.get().getPhoto())
				.setId(product.get().getId().intValue())
				.setNombre(product.get().getName())
				.setStock(product.get().getStock())
				.setTalle(product.get().getTalle())
				.build();
    	
    	response.setProduct(product2);
    	return response.build();
    }

}
