package com.unla.stockearte.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import com.unla.stockearte.repository.CatalogoRepository;
import com.unla.stockearte.repository.ProductsRepository;
import com.unla.stockearte.repository.entity.CatalogoModel;
import com.unla.stockearte.repository.entity.ProductModel;

@Service
public class CatalogoServiceLogic {

	@Autowired
	private CatalogoRepository repository;
	
	@Autowired
	private ProductsRepository productRepository;

	@Transactional
	public CatalogoModel create(CatalogoModel catalogoModel) {
	    List<ProductModel> productos = catalogoModel.getProductos();

	    if (productos != null) {
	        for (int i = 0; i < productos.size(); i++) {
	            ProductModel product = productos.get(i);
	            if (product.getId() == null || product.getId() == 0) {
	                product = productRepository.save(product);
	                productos.set(i, product);
	            }else {
	            ProductModel managedProduct = productRepository.findById(product.getId())
	                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

	            productos.set(i, managedProduct);
	        }
	       }
	    }

	    return repository.save(catalogoModel);
	}
	
	
//	public CatalogoModel create (CatalogoModel catalogoModel) {
//		return repository.save(catalogoModel);
//	}
	
	public boolean update(Long id, CatalogoModel catalogoModel) {
		Optional<CatalogoModel> existing = repository.findById(id);
		if(existing.isPresent()) {
			repository.save(catalogoModel);
			return true;
		}
		return false;
	}
	
	public boolean delete(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
    public List<CatalogoModel> getAll() {
        return repository.findAll();
    }
    
    @Transactional
    public CatalogoModel getCatalogoById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Catálogo no encontrado con ID: " + id));
    }
    
    public byte[] exportarCatalogoPDF(Long catalogoId) {
        // Obtener el catálogo por ID
        CatalogoModel catalogo = repository.findById(catalogoId)
            .orElseThrow(() -> new RuntimeException("Catálogo no encontrado"));

        // Crear un ByteArrayOutputStream para generar el PDF en memoria
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Crear el documento PDF
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // Crear fuente para el título y los productos
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font productFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font regularFont = new Font(Font.FontFamily.HELVETICA, 12);

            // Título del catálogo
            document.add(new Paragraph("Catálogo: " + catalogo.getTitulo(), titleFont));

            // Agregar productos al documento
            document.add(new Paragraph("Productos:", productFont));

            for (ProductModel producto : catalogo.getProductos()) {
                document.add(new Paragraph("Nombre: " + producto.getName() +
                                           ", Código: " + producto.getCode() +
                                           ", Color: " + producto.getColor() +
                                           ", Talle: " + producto.getTalle(), regularFont));
            }
        } catch (DocumentException e) {
            throw new RuntimeException("Error al generar el PDF", e);
        } finally {
            document.close();
        }

        // Devolver el contenido del PDF como un byte array
        return baos.toByteArray();
    }
}
