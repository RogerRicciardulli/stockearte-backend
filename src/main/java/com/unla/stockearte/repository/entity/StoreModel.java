package com.unla.stockearte.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "stores")
public class StoreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false, length = 20)
    private String code;
    @Column(nullable = false, length = 50)
    private String address;
    @Column(nullable = false, length = 50)
    private String city;
    @Column(nullable = false, length = 50)
    private String province;
	@Column(nullable = false)
    private boolean enabled;
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "stores_products",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
        )
    private List<ProductModel> products;
	public StoreModel(String code, String address, String city, String province, boolean enabled,
			List<ProductModel> products) {
		super();
		this.code = code;
		this.address = address;
		this.city = city;
		this.province = province;
		this.enabled = enabled;
		this.products = products;
	}	
	public StoreModel(String code, String address, String city, String province, boolean enabled) {
		super();
		this.code = code;
		this.address = address;
		this.city = city;
		this.province = province;
		this.enabled = enabled;
	}
	public StoreModel() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<ProductModel> getProducts() {
		return products;
	}
	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}
	
}