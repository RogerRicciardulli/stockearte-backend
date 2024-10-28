package com.unla.stockearte.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.stockearte_backend.CatalogoType;
import com.stockearte_backend.CatalogosType;
import com.stockearte_backend.CreateCatalogoRequest;
import com.stockearte_backend.CreateCatalogoResponse;
import com.stockearte_backend.DeleteCatalogoRequest;
import com.stockearte_backend.DeleteCatalogoResponse;
import com.stockearte_backend.GetAllCatalogoResponse;
import com.stockearte_backend.GetCatalogoByIdRequest;
import com.stockearte_backend.GetCatalogoByIdResponse;
import com.stockearte_backend.ProductoType;
import com.stockearte_backend.ProductosType;
import com.stockearte_backend.UpdateCatalogoRequest;
import com.stockearte_backend.UpdateCatalogoResponse;
import com.unla.stockearte.repository.entity.CatalogoModel;
import com.unla.stockearte.repository.entity.ProductModel;
import com.unla.stockearte.services.CatalogoServiceLogic;

@Endpoint
public class CatalogoEndpoint {

	private static final String NAMESPACE_URI = "http://stockearte-backend.com/";
	
	@Autowired
	private CatalogoServiceLogic catalogoService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCatalogoRequest")
	@ResponsePayload
	public CreateCatalogoResponse createCatalogoModel(@RequestPayload CreateCatalogoRequest request) {
		CatalogoModel catalogoModel = new CatalogoModel();
		catalogoModel.setTitulo(request.getTitulo());
		catalogoModel.setTiendaID(request.getTiendaID());
		List<ProductModel> productList = convertToProductModelList(request.getProductos());
		catalogoModel.setProductos(productList);
		
		Long id = catalogoService.create(catalogoModel).getId();
		CreateCatalogoResponse response = new CreateCatalogoResponse();
		response.setId(id);
		return response;
	}
	
	private List<ProductModel> convertToProductModelList(ProductosType productosType) {
	    List<ProductModel> productList = new ArrayList<>();
	    if (productosType != null) {
	        for (ProductoType producto : productosType.getProducto()) {
	            ProductModel productModel = new ProductModel();
	            productModel.setId(producto.getId());
	            productModel.setCode(producto.getCodigo()); 
	            productModel.setName(producto.getNombre());
	            productModel.setTalle(producto.getTalle());
	            productModel.setStock(0);
	            productModel.setColor(producto.getColor());
	            productModel.setPhoto(producto.getFoto());
	            productModel.setHabilitado(true);

	            //productModel.setStores(new ArrayList<>()); // Inicializa la lista.
	            
	            productList.add(productModel);
	        }
	    }
	    return productList;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCatalogoRequest")
	@ResponsePayload
	public UpdateCatalogoResponse updateCatalogoModel (@RequestPayload UpdateCatalogoRequest request) {
		CatalogoModel catalogoModel = new CatalogoModel();
		catalogoModel.setId(request.getId());
		catalogoModel.setTitulo(request.getTitulo());
		catalogoModel.setTiendaID(request.getTiendaID());
		List<ProductModel> productList = convertToProductModelList(request.getProductos());
		catalogoModel.setProductos(productList);
		
		boolean success = catalogoService.update(catalogoModel.getId(), catalogoModel);
		
		UpdateCatalogoResponse response = new UpdateCatalogoResponse();
		response.setSuccess(success);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCatalogoRequest")
	@ResponsePayload
	private DeleteCatalogoResponse deleteCatalogoModel (@RequestPayload DeleteCatalogoRequest request) {
		boolean success = catalogoService.delete(request.getId());
		
		DeleteCatalogoResponse response = new DeleteCatalogoResponse();
		response.setSuccess(success);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCatalogoRequest")
	@ResponsePayload
	public GetAllCatalogoResponse getAllCatalogos() {
	    List<CatalogoModel> catalogos = catalogoService.getAll();
	    GetAllCatalogoResponse response = new GetAllCatalogoResponse();
	    CatalogosType catalogosType = new CatalogosType();
	    
	    for (CatalogoModel catalogoModel : catalogos) {
	        CatalogoType catalogoType = new CatalogoType();
	        catalogoType.setId(catalogoModel.getId());
	        catalogoType.setTitulo(catalogoModel.getTitulo());
	        catalogoType.setTiendaID(catalogoModel.getTiendaID());
	        
	        ProductosType productosType = new ProductosType();
	        for (ProductModel productModel : catalogoModel.getProductos()) {
	            ProductoType productoType = new ProductoType();
	            productoType.setId(productModel.getId());
	            productoType.setCodigo(productModel.getCode());
	            productoType.setNombre(productModel.getName());
	            productoType.setTalle(productModel.getTalle());
	            productoType.setColor(productModel.getColor());
	            productoType.setFoto(productModel.getPhoto());
	            productosType.getProducto().add(productoType);
	        }
	        
	        catalogoType.setProductos(productosType);
	        catalogosType.getCatalogo().add(catalogoType);
	    }
	    
	    response.setCatalogos(catalogosType);
	    return response;
	}
	
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCatalogoByIdRequest")
    @ResponsePayload
    public GetCatalogoByIdResponse getCatalogoById(@RequestPayload GetCatalogoByIdRequest request) {
        GetCatalogoByIdResponse response = new GetCatalogoByIdResponse();
        
        try {
            CatalogoModel catalogoModel = catalogoService.getCatalogoById(request.getId());
           
            CatalogoType catalogoType = new CatalogoType();
            catalogoType.setId(catalogoModel.getId());
            catalogoType.setTitulo(catalogoModel.getTitulo());
            catalogoType.setTiendaID(catalogoModel.getTiendaID());
            
            ProductosType productosType = new ProductosType();
            for (ProductModel productModel : catalogoModel.getProductos()) {
                ProductoType productoType = new ProductoType();
                productoType.setId(productModel.getId());
                productoType.setCodigo(productModel.getCode());
                productoType.setNombre(productModel.getName());
                productoType.setTalle(productModel.getTalle());
                productoType.setColor(productModel.getColor());
                productoType.setFoto(productModel.getPhoto());
                productosType.getProducto().add(productoType);
            }
            
            catalogoType.setProductos(productosType);
            response.setCatalogo(catalogoType);
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar el catálogo: " + e.getMessage());
        }
        
        return response;
    }
}
