package com.unla.stockearte.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.stockearte.CreateProductResponse;
import com.unla.stockearte.DeleteProductResponse;
import com.unla.stockearte.EditProductResponse;
import com.unla.stockearte.FilterProductResponse;
import com.unla.stockearte.GetDetailProductResponse;
import com.unla.stockearte.Product;
import com.unla.stockearte.repository.ProductsRepository;
import com.unla.stockearte.repository.StockRepository;
import com.unla.stockearte.repository.StoresRepository;
import com.unla.stockearte.repository.entity.ProductModel;
import com.unla.stockearte.repository.entity.StockModel;
import com.unla.stockearte.repository.entity.StoreModel;
import com.unla.stockearte.utils.RandomString;

@Service
public class ProductServiceLogic {
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceLogic.class);
    @Autowired
    private ProductsRepository repository;
    
    @Autowired
    private StoresRepository storeRepository;
    @Autowired
    private StocksServiceLogic stocksServiceLogic;
    @Autowired
    private StockRepository stockRepository;
    
    public CreateProductResponse saveProduct(String nombre, String talle, String foto, String color, int stock, List<Long> tiendas) {
    	List<StoreModel> listStore = new ArrayList<StoreModel>();
    	
    	for(Long idTienda: tiendas) {
    		Optional<StoreModel> storeModel = storeRepository.findById(idTienda);
    		if(storeModel.isPresent()) {
    			listStore.add(storeModel.get());
    		}
    	}
    	
    	String code = RandomString.getAlphaNumericString(10);
    	
    	ProductModel product = new ProductModel(code, nombre, talle, stock, color, "FOTO", listStore);
    	product.setHabilitado(true);
		repository.save(product);
		saveNewStock(listStore, code);
		CreateProductResponse.Builder response = CreateProductResponse.newBuilder();
		response.setSuccess(true);
		return response.build();
    }
    public void saveNewStock(List<StoreModel> listStore, String code) {
    	for(StoreModel store : listStore) {
    		ProductModel productModelSaved = repository.findByCode(code);
    		if(productModelSaved != null){
    			if(stockRepository.findByProductIdAndStoreId(productModelSaved.getId(), store.getId()) == null) {
    				stocksServiceLogic.saveStock((int)store.getId(), productModelSaved.getId().intValue(), 0);
    			}
    		}
    	}
    }
    public void editStock(List<StoreModel> listStore, String code) {
        ProductModel productModelSaved = repository.findByCode(code);
        if (productModelSaved != null) {
            List<StockModel> existingStocks = stockRepository.findByProductId(productModelSaved.getId());
            List<Long> existingStoreIds = existingStocks.stream()
                    .map(stock -> stock.getStore().getId())
                    .collect(Collectors.toList());
            List<Long> newStoreIds = listStore.stream()
                    .map(StoreModel::getId)
                    .collect(Collectors.toList());
            for (StoreModel store : listStore) {
                if (!existingStoreIds.contains(store.getId())) {
                    stocksServiceLogic.saveStock((int)store.getId(), productModelSaved.getId().intValue(), 0);
                }
            }
            for (StockModel stock : existingStocks) {
                if (!newStoreIds.contains(stock.getStore().getId())) {
                    stockRepository.delete(stock);
                }
            }
        }
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
    		editStock(listStore, product.get().getCode());
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
    	if(nombre.equals("GetAllList")) {
    		List<Product> productList = generateList((List<ProductModel>) repository.findByIsHabilitado(true));
    		response.addAllProduct(productList);
    	} else {
        	if(!color.isEmpty()) {
        		List<Product> productList = generateList((List<ProductModel>) repository.findByNameAndIsHabilitado(color, true));
        		response.addAllProduct(productList);
        	} else if(!nombre.isEmpty()) {
        		List<Product> productList = generateList((List<ProductModel>) repository.findByNameAndIsHabilitado(nombre, true));
        		response.addAllProduct(productList);
        	} else if(!talle.isEmpty()) {
        		List<Product> productList = generateList((List<ProductModel>) repository.findByTalleAndIsHabilitado(talle, true));
        		response.addAllProduct(productList);
        	} else if (habilitado) {
        		List<Product> productList = generateList((List<ProductModel>) repository.findAll());
        		response.addAllProduct(productList);
        	} 
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
    
    public GetDetailProductResponse getDetailProduct(long id) {
    	GetDetailProductResponse.Builder response = GetDetailProductResponse.newBuilder();
		try {
	    	Optional<ProductModel> productModel = repository.findById(id);
			if(productModel.isPresent()) {
				ProductModel product = productModel.get();	
			    Product.Builder productBuilder = Product.newBuilder()
			            .setId(product.getId())
			            .setCodigo(product.getCode())
			            .setColor(product.getColor())
			            .setFoto(product.getPhoto())
			            .setNombre(product.getName())
			            .setStock(product.getStock())
			            .setTalle(product.getTalle());
			    for(StoreModel store : product.getStores()) {
			    	productBuilder.addIdTienda(store.getId());
			    }
				response.setProduct(productBuilder);
			}
		} catch (Exception e) {
			log.error("[ProductServiceLogic.getDetailProduct] Unexpected error.", e);
		}
		return response.build(); 
    }

}
