package com.unla.stockearte.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 10)
    private String code;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 20)
    private String size;
    @Column(nullable = false, length = 20)
    private String color;
    @Column(nullable = false, length = 20)
    private String photo;
    @ManyToMany    
    @JoinTable(
            name = "stores_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id")
        )
    private List<StoreModel> stores;
	public ProductModel(String code, String name, String size, String color, String photo,
			List<StoreModel> stores) {
		super();
		this.code = code;
		this.name = name;
		this.size = size;
		this.color = color;
		this.photo = photo;
		this.stores = stores;
	}
	public ProductModel() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<StoreModel> getStores() {
		return stores;
	}
	public void setStores(List<StoreModel> stores) {
		this.stores = stores;
	}
      
}